<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
table{margin:0px auto;}
</style>
</head>
<body>
<%@page import="java.util.*" %>
<%
    Calendar cal = Calendar.getInstance();
    int year = request.getParameter("y") == null ? cal.get(Calendar.YEAR) : Integer.parseInt(request.getParameter("y"));
    int month = request.getParameter("m") == null ? cal.get(Calendar.MONTH) : (Integer.parseInt(request.getParameter("m")) - 1);

    // ���ۿ��� Ȯ��
    // - Calendar MONTH�� 0-11������
    cal.set(year, month, 1);
    int bgnWeek = cal.get(Calendar.DAY_OF_WEEK);

    // ����/������ ���
    // - MONTH ���� ǥ����� ����ϱ� ������ +1�� �� ���¿��� �����
    int prevYear = year;
    int prevMonth = (month + 1) - 1;
    int nextYear = year;
    int nextMonth = (month  + 1) + 1;

    // 1���� ��� ������ 12���� ����
    if (prevMonth < 1) {
        prevYear--;
        prevMonth = 12;
    }

    // 12���� ��� ������ 1���� ����
    if (nextMonth > 12) {
        nextYear++;
        nextMonth = 1;
    }
%>
<table border="0" cellpadding="0" cellspacing="0">
<tr>
    <td align="center" bgcolor="purple" style="font-weight:bold"><a href="./cal.jsp?y=<%=prevYear%>&m=<%=prevMonth%>">��</a> <%=year%>�� <%=month+1%>�� <a href="./cal.jsp?y=<%=nextYear%>&m=<%=nextMonth%>">��</a></td>
</tr>
<tr>
    <td>

        <table>
        <tr style="font-weight:bold">
            <td>��</td>
            <td>��</td>
            <td>ȭ</td>
            <td>��</td>
            <td>��</td>
            <td>��</td>
            <td>��</td>
        </tr>
        <tr align=center>
<%
    // ���ۿ��ϱ��� �̵�
    for (int i=1; i<bgnWeek; i++) out.println("<td>&nbsp;</td>");

    // ù��~������������ ó��
    // - ��¥�� �Ϸ羿 �̵��Ͽ� ���� �ٲ𶧱��� �׸���
    while (cal.get(Calendar.MONTH) == month) {
        out.println("<td>" + cal.get(Calendar.DATE) + "</td>");

        // ������� ��� �����ٷ� ����
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) out.println("</tr><tr>");

        // ��¥ ������Ű��
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE)+1);
    }

    // �������� ����ϱ��� ��ĭ���� ó��
    for (int i=cal.get(Calendar.DAY_OF_WEEK); i<=7; i++) out.println("<td>&nbsp;</td>");
%>
        </tr>
        </table>

    </td>
</tr>
</table>

</body>
</html>