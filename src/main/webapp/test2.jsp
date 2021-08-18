<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<script>
var now = new Date();	// 현재 날짜 및 시간
document.write("현재 : ", now);
var yesterday = new Date(now.setDate(now.getDate() - 1));	// 어제
document.write("어제 : ", yesterday);
document.write(now.getDay());

var now = new Date();	// 현재 날짜 및 시간
document.write("현재 : ", now);
var tomorrow = new Date(now.setDate(now.getDate() + 1));	// 내일
document.write("내일 : ", tomorrow);

</script>

</body>
</html>