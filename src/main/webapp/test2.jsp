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
var now = new Date();	// ���� ��¥ �� �ð�
document.write("���� : ", now);
var yesterday = new Date(now.setDate(now.getDate() - 1));	// ����
document.write("���� : ", yesterday);
document.write(now.getDay());

var now = new Date();	// ���� ��¥ �� �ð�
document.write("���� : ", now);
var tomorrow = new Date(now.setDate(now.getDate() + 1));	// ����
document.write("���� : ", tomorrow);

</script>

</body>
</html>