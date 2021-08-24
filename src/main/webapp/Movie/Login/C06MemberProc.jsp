<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- Bean 파일 연결  -->
<jsp:useBean id="regBean" class="Ch11.C02MemberBean" scope="page" />

<!--전달받은 request객체의 모든 name을 regBean으로 전달  -->
<jsp:setProperty  name="regBean" property="*" />


아이디	:<jsp:getProperty name="regBean" property="userid" />
패스워드	:<%=regBean.getPwd() %><br>
이름		:<%=regBean.getName() %><br>
휴대폰	:<%=regBean.getPh1()+regBean.getPh2()+regBean.getPh3() %><br>
유선전화	:<%=regBean.getTel1()+regBean.getTel2()+regBean.getTel3() %><br>
이메일	:<%=regBean.getEmail() %><br>
우편번호	:<%=regBean.getAddrnum() %><br>
기본주소	:<%=regBean.getAddr1() %><br>
상세주소	:<%=regBean.getAddr2() %><br>

</body>
</html>