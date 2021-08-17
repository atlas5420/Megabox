<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="C01Main.jsp"><img src="" ></a> 
<ul>
	<li><a href="C03MemberJoin3.jsp">회원가입</a>&nbsp;&nbsp;|</li>
	<li>&nbsp;&nbsp;<a onclick="LoginPopup()">로그인</a>&nbsp;&nbsp;|</li>
	<li>&nbsp;&nbsp;<a href="#">장바구니</a>&nbsp;&nbsp;|</li>
	<li>&nbsp;&nbsp;<a href="#">내강의실</a></li>
</ul>

<script language="javascript">
function LoginPopup() { window.open("./C04Popup.jsp", "a", "width=850, height=500, left=500, top=250"); }
</script>

</body>
</html>