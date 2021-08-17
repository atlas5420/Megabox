<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="prodRepo" class="Ch13.ProdRepository" scope="session" />
<%@ page import="Ch13.Product" %>

<%
	//Booklist로부터 책이름/출판사/가격 정보를 받기
	String title = request.getParameter("title");
	String publisher = request.getParameter("publisher");
	String price = request.getParameter("price");
	//세션객체로부터 ID정보 받기
	String userid = (String)session.getAttribute("idKey");
	//Product 객체 생성
	Product prod = new Product(userid, title, publisher, price);
	//저장소에 추가
	prodRepo.addProduct(userid, prod);
%>

<script>
	location.href="C04Booklist.jsp";
</script>

</body>
</html>