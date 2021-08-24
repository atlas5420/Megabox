<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="jsp/link.jsp" %>

<style>
content 
{
	width:1190px; 
	height:800px; 
	position:absolute; top:110px; left:0px; 
	margin:4px;
	border: 1px solid gray;
}
</style>

<jsp:useBean id="cnt" class="Ch13.Counter" scope="application" />

<%
	cnt.setCount();
%>

<%@page import="java.util.*, java.text.*,java.io.*" %>
<%
	//현재시간
	SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	String logTime = format.format(new Date());
	//clientIP
	String IP = request.getRemoteAddr();
	//userid
	String ID = request.getParameter("userid");
	//weblog.txt 파일에 넣기
	//Writer 클래스
	//char단위(2byte==문자)로 데이터전달 스트림
	try{
	OutputStream outf = new FileOutputStream("c:/JSPTMP/weblog.txt",true);
	//->byte단위(1byte==바이너리)로 데이터전달 스트림
	DataOutputStream outFile = new DataOutputStream(outf);
	//->기본outputStream에 추가되는 보조스트림
	//->UTF문자셋단위로 바이너리 데이터를 파일로 저장할 수 있다 
	outFile.writeUTF(logTime);
	outFile.writeUTF(IP);
	outFile.writeUTF(ID);
	outFile.flush();
	outFile.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
%>



</head>
<body>

<header>
<jsp:include page="module/header.jsp" />
</header>

<nav>
<jsp:include page="module/nav.jsp" />
</nav>

<content></content>
<section></section>

<footer>
	<%@ include file="jsp/footerContents.jsp" %>
</footer>

</body>
</html>