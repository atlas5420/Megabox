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
<jsp:useBean id="regBean" class="Ch01.Movie.C02MemberBean" scope="page" />

<!--전달받은 request객체의 모든 name을 regBean으로 전달  -->
<jsp:setProperty  name="regBean" property="*" />



생년월일	:<%=regBean.getBirth %><br>
휴대폰	:<%=regBean.getPh1()+regBean.getPh2()+regBean.getPh3() %><br>
아이디	:<jsp:getProperty name="regBean" property="userid" />
패스워드	:<%=regBean.getPwd() %><br>
<%-- 이름		:<%=regBean.getName() %><br> --%>
이메일	:<%=regBean.getEmail() %><br>

</body>
</html>