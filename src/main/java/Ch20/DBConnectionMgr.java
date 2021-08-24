/**
 * Copyright(c) 2001 iSavvix Corporation (http://www.isavvix.com/)
 *
 *                        All rights reserved
 *
 * Permission to use, copy, modify and distribute this material for
 * any purpose and without fee is hereby granted, provided that the
 * above copyright notice and this permission notice appear in all
 * copies, and that the name of iSavvix Corporation not be used in
 * advertising or publicity pertaining to this material without the
 * specific, prior written permission of an authorized representative of
 * iSavvix Corporation.
 *
 * ISAVVIX CORPORATION MAKES NO REPRESENTATIONS AND EXTENDS NO WARRANTIES,
 * EXPRESS OR IMPLIED, WITH RESPECT TO THE SOFTWARE, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR ANY PARTICULAR PURPOSE, AND THE WARRANTY AGAINST
 * INFRINGEMENT OF PATENTS OR OTHER INTELLECTUAL PROPERTY RIGHTS.  THE
 * SOFTWARE IS PROVIDED "AS IS", AND IN NO EVENT SHALL ISAVVIX CORPORATION OR
 * ANY OF ITS AFFILIATES BE LIABLE FOR ANY DAMAGES, INCLUDING ANY
 * LOST PROFITS OR OTHER INCIDENTAL OR CONSEQUENTIAL DAMAGES RELATING
 * TO THE SOFTWARE.
 *
 */
package Ch20;

import java.sql.*;
import java.util.Properties;
import java.util.Vector;

/**
 * Manages a java.sql.Connection pool.
 *
 * @author  Anil Hemrajani
 */
public class DBConnectionMgr {
    private Vector connections = new Vector(10);
    private String _driver = "com.mysql.cj.jdbc.Driver",
    _url = "jdbc:mysql://localhost:3306/boarddb?useUnicode=true&characterEncoding=UTF-8",
    _user = "root",
    _password = "1234";
    private boolean _traceOn = false;
    private boolean initialized = false;
    private int _openConnections = 10;	//기본값 10
    private static DBConnectionMgr instance = null;	//싱글턴패턴

    public DBConnectionMgr() {
    }

    /** Use this method to set the maximum number of open connections before
     unused connections are closed.
     */

    public static DBConnectionMgr getInstance() {	//싱글턴패턴, 관리객체는 하나만 만듦
        if (instance == null) {
            synchronized (DBConnectionMgr.class) {
                if (instance == null) {
                    instance = new DBConnectionMgr();
                }
            }
        }
        return instance;
    }

    public void setOpenConnectionCount(int count) {	
        _openConnections = count;
    }

    public void setEnableTrace(boolean enable) {
        _traceOn = enable;
    }

    /** Returns a Vector of java.sql.Connection objects */
    public Vector getConnectionList() {
        return connections;
    }

    /** Opens specified "count" of connections and adds them to the existing pool */
    public synchronized void setInitOpenConnections(int count)	//추가로 확장시킨 연결객체
            throws SQLException {
        Connection c = null;
        ConnectionObject co = null;
        
        for (int i = 0; i < count; i++) {
            c = createConnection();
            co = new ConnectionObject(c, false);
            connections.addElement(co);
            trace("ConnectionPoolManager: Adding new DB connection to pool (" + connections.size() + ")");
        }
    }

    /** Returns a count of open connections */
    public int getConnectionCount() {
        return connections.size();
    }

    /** Returns an unused existing or new connection.  */
    public synchronized Connection getConnection()	//★
            throws Exception {
        if (!initialized) {	//초기화 되어있지 않으면
            Class c = Class.forName(_driver);	//드라이버에 적재
            DriverManager.registerDriver((Driver) c.newInstance());
            initialized = true;	
        }
        Connection c = null;
        ConnectionObject co = null;		
        boolean badConnection = false;

        for (int i = 0; i < connections.size(); i++) { //10
            co = (ConnectionObject) connections.get(i);	//i번째 커넥션오브젝트 객체
            // If connection is not in use, test to ensure it's still valid!
            if (!co.inUse) { //사용중이지 않다면
                try {
                    badConnection = co.connection.isClosed();	//닫혀있으면? true 열려있으면? false
                    if (!badConnection)	//false면 올바르게 연결되어있지 않음(사용중이 아닌데 열려있다??)  ↓아래와 같이 처리
                        badConnection = (co.connection.getWarnings() != null); //true넣기
                } catch (Exception e) {
                    badConnection = true;
                    e.printStackTrace();
                }
                // Connection is bad, remove from pool
                if (badConnection) {	//연결객체가 문제가 있다면
                    connections.removeElementAt(i);	//해당연결객체 제거
                    trace("ConnectionPoolManager: Remove disconnected DB connection #" + i); //문제가 있다고 화면에 출력
                    continue;	//다음요소 확인 //false라면 아래 코드로 이동
                }
                c = co.connection;
                co.inUse = true; //사용중으로 바꿈
                trace("ConnectionPoolManager: Using existing DB connection #" + (i + 1)); //표시
                break;
            }
        }

        if (c == null) {
            c = createConnection();
            co = new ConnectionObject(c, true);
            connections.addElement(co);
            trace("ConnectionPoolManager: Creating new DB connection #" + connections.size());
        }
        return c;
    }

    /** Marks a flag in the ConnectionObject to indicate this connection is no longer in use */
    public synchronized void freeConnection(Connection c) {
        if (c == null)
            return;

        ConnectionObject co = null;

        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.get(i);
            if (c == co.connection) {
                co.inUse = false;
                break;
            }
        }

        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.get(i);
            if ((i + 1) > _openConnections && !co.inUse)
                removeConnection(co.connection);
        }
    }

    public void freeConnection(Connection c, PreparedStatement p, ResultSet r) {	//오버로딩
        try {
            if (r != null) r.close();
            if (p != null) p.close();
            freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void freeConnection(Connection c, Statement s, ResultSet r) {
        try {
            if (r != null) r.close();
            if (s != null) s.close();
            freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void freeConnection(Connection c, PreparedStatement p) {
        try {
            if (p != null) p.close();
            freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void freeConnection(Connection c, Statement s) {
        try {
            if (s != null) s.close();
            freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** Marks a flag in the ConnectionObject to indicate this connection is no longer in use */
    public synchronized void removeConnection(Connection c) {	//연결 객체 제거
        if (c == null)
            return;

        ConnectionObject co = null;
        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.get(i);
            if (c == co.connection) {
                try {
                    c.close();
                    connections.removeElementAt(i);
                    trace("Removed " + c.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    private Connection createConnection()	//연결객체 추가할 때 createConnection() 위 코드에 있음
            throws SQLException {
        Connection con = null;
        
        try {
            if (_user == null)
                _user = "";
            if (_password == null)
                _password = "";

            Properties props = new Properties();	//map과 유사 키와 값 넣을 수 있음
            props.put("user", _user);
            props.put("password", _password);

            con = DriverManager.getConnection(_url, props);
        } catch (Throwable t) {
            throw new SQLException(t.getMessage());
        }
        return con;
    }

    /** Closes all connections and clears out the connection pool */
    public void releaseFreeConnections() {
        trace("ConnectionPoolManager.releaseFreeConnections()");

        Connection c = null;
        ConnectionObject co = null;

        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.get(i);
            if (!co.inUse)
                removeConnection(co.connection);
        }
    }

    /** Closes all connections and clears out the connection pool */
    public void finalize() {
        trace("ConnectionPoolManager.finalize()");

        Connection c = null;
        ConnectionObject co = null;

        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.get(i);
            try {
                co.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            co = null;
        }
        connections.removeAllElements();
    }

    private void trace(String s) {
        if (_traceOn)
            System.err.println(s);
    }
}

class ConnectionObject {
    public java.sql.Connection connection = null;
    public boolean inUse = false;

    public ConnectionObject(Connection c, boolean useFlag) {
        connection = c;
        inUse = useFlag;
    }
}