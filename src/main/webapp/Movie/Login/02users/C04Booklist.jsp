<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="jsp/link.jsp" %>

<style>
* {height:10px;}
#contents {width:100%;height:800px;}
#contents ul {list-style:none; text-align:center; }
#contents ul li {width:200px; height:300px; border:1px solid gray; float:left; margin:30px;}
#contents ul li form img{width:95%; height:200px; border:1px solid gray;}
#contents ul li form h4 {margin: 10px;}
#contents ul li form a { margin : 10px;}
</style>
</head>
<body>
<header>
<jsp:include page="module/header.jsp" />
</header>

<nav>
<jsp:include page="module/nav.jsp" />
</nav>

<aside></aside>
<content>
<div id = contents>

<ul>
	<li>
		<form>
			<input type=hidden name=title id=title value="이것이 리눅스다">
			<input type=hidden name=publisher id=publisher value="한빛미디어">
			<input type=hidden name=price id=price value="20000">
			<img src="이것이리눅스다.jpg">
			<h4>이것이 리눅스다</h4>
			<font>20000</font><br>
			<a href="#" onclick="addtoCart(0)">장바구니</a><a href="#" onclick="buyProd()">구매하기</a>
		</form>
	</li>
	<li>
		<form>
			<input type=hidden name=title id=title value="윤성우의열혈C">
			<input type=hidden name=publisher id=publisher value="00출판사">
			<input type=hidden name=price id=price value="30000">
			<img src="열혈C.jpg">
			<h4>윤성우의 열혈C</h4>
			<font>30000</font><br>
			<a href="#" onclick="addtoCart(1)">장바구니</a><a href="#" onclick="buyProd()">구매하기</a>
		</form>
	</li>
	<li>
		<form>
			<input type=hidden name=title id=title value="자바의정석">
			<input type=hidden name=publisher id=publisher value="00출판사">
			<input type=hidden name=price id=price value="25000">
			<img src="자바의정석.jpg">
			<h4>자바의 정석</h4>
			<font>25000</font><br>
			<a href="#" onclick="addtoCart(2)">장바구니</a><a href="#" onclick="buyProd()">구매하기</a>
		</form>
	</li>
	<li>
		<form>
			<input type=hidden name=title id=title value="DOITJAVA">
			<input type=hidden name=publisher id=publisher value="00출판사">
			<input type=hidden name=price id=price value="30000">
			<img src="DOITJAVA.jpg">
			<h4>Do It 자바</h4>
			<font>30000</font><br>
			<a href="#" onclick="addtoCart(3)">장바구니</a><a href="#" onclick="buyProd()">구매하기</a>
		</form>
	</li>
</ul>
</div>
</content>
<script>
function addtoCart(num)
{
	title=document.forms[num].elements[0].value;
	//document.forms[인덱스번호] : 해당되는 폼을 선택할 수 있음
	//https://www.w3schools.com/jsref/coll_doc_forms.asp
	//https://developer.mozilla.org/en-US/docs/Web/API/Document/forms
	//https://chachahoya.tistory.com/36
	publisher=document.forms[num].elements[1].value;
	price=document.forms[num].elements[2].value;
	
	isok = confirm("도서명 : "+title+"\n출판사 : " + publisher + "\n가격 : " +price+"\n장바구니에 추가하시겠습니까?");
	if(isok==true)
		{
			document.forms[num].action="C04addCart.jsp?title="+title+"&publisher="+publisher+"&price="+price;
			//form객체의 action속성 : Sets or returns the value of the action attribute in a form
			//form양식의 작동되는 url변경
			document.forms[num].submit();
			//form객체의 submit()메서드 : Submits a form
			alert("장바구니에 담았습니다.");				
		}
	else
		{
			alert("장바구니 담기를 취소합니다");
		}
}
function buyProd()
{
	isok = confirm("구매하기 페이지로 이동하시겠습니까?");
	if(isok==true)
		{
			location.href="C04buyProd.jsp";
		}
	else
		{
			alert("구매하기 페이지 이동을 취소합니다")
		}
	
}
</script>


<footer>
	<%@ include file="jsp/footerContents.jsp" %>
</footer>


</body>
</html>