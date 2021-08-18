<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style>
#chartable{border:2px solid black; border-radius:10px;
		   margin:0px auto; width:1000px; hegiht:500px;}
#timetable{border:1px solid black; margin:0px auto; width:1000px;
 		   border-left:none; border-right:none;
 		   text-align:center;}
button{border:none; background-color:white;}
img{}
</style>

</head>
<body>

<%@page import="java.util.*" %>
 
 <script>
 
	function getToday(){
	var today = new Date();
	var days = "";
	days = today.getDate();
	return days;
	}
	
	function getTodayLabel() {
	    var today = new Date().getDay();
			today = "오늘";
		return today;
	}
	function getTomrrowLabel() {
	    var tomorrow = new Date().getDay();
	    	tomorrow = "내일";
		return tomorrow;
	}
	function getDay1() {
    var day= new Date();
    if (day >6){
    	day =0;
    }
   	switch(day){
   	case 0: day = "일"
   	break;
   	case 1: day = "월"
   	break;
   	case 2: day = "화"
   	break;
   	case 3: day = "수"
   	break;
   	case 4: day = "목"
   	break;
   	case 5: day = "금"
   	break;
   	case 6: day = "토"
   	break;
   	}
	return day;
	}
	function getDay2() {
	var day = new Date().getDay()+3;
	switch(day){
   	case 0: day = "일"
   	break;
   	case 1: day = "월"
   	break;
   	case 2: day = "화"
   	break;
   	case 3: day = "수"
   	break;
   	case 4: day = "목"
   	break;
   	case 5: day = "금"
   	break;
   	case 6: day = "토"
   	break;
   	}
	return day;
	}
	function getDay3() {
	var day = new Date().getDay()+4;
	switch(day){
   	case 0: day = "일"
   	break;
   	case 1: day = "월"
   	break;
   	case 2: day = "화"
   	break;
   	case 3: day = "수"
   	break;
   	case 4: day = "목"
   	break;
   	case 5: day = "금"
   	break;
   	case 6: day = "토"
   	break;
   	}
	return day;
}	
	function getDay4() {
		var day = new Date().getDay()+5;
		switch(day){
	   	case 0: day = "일"
	   	break;
	   	case 1: day = "월"
	   	break;
	   	case 2: day = "화"
	   	break;
	   	case 3: day = "수"
	   	break;
	   	case 4: day = "목"
	   	break;
	   	case 5: day = "금"
	   	break;
	   	case 6: day = "토"
	   	break;
	   	}
		return day;
	}
	function getDay5() {
		var day = new Date().getDay()+6;
		if (day >6){
	    	day = 0;
	    }
		switch(day){
	   	case 0: day = "일"
	   	break;
	   	case 1: day = "월"
	   	break;
	   	case 2: day = "화"
	   	break;
	   	case 3: day = "수"
	   	break;
	   	case 4: day = "목"
	   	break;
	   	case 5: day = "금"
	   	break;
	   	case 6: day = "토"
	   	break;
	   	}
		return day;
	}	


	</script>
	
<form>
<table id="chartable">
	<tr>
		<td align=center width=150px>
		<p class="pos">
		<label for="pos"><img src=./img/영화별.png width=30px height=30px>영화별</label>
		</p>
		</td>
		<td rowspan=3>
		<table align=center width=600px height=300px margin=0px>
			<tr>
			<td>
			<jsp:include page="movieCon.jsp" />
			</td>
			</tr>
			</table>
			
		</td>
		<td rowspan=3 width=200px><a href="#"><img src="./img/인질.jpg" align=right></a></td>
	</tr>
	<tr>
		<td align=center bgcolor=lightgray>
		<p class="pos">
		<label for="pos1">
		<img src=./img/극장별.png width=30px height=30px>극장별
		</label>
		</p>
		</td>


	</tr>
	<tr>
		<td align=center bgcolor=lightgray>
		<p class="pos">
		<label for="pos1">
		<img src=./img/특별관.png width=30px height=30px>특별관
		</label>
		</p>
		</td>


	</tr>
</table>

</form>

<br>
<br>
<br>
<br>
	
<table id="timetable">
<tr>
	<td>
	<script>document.write(getToday());</script>
	<br>
	<script>document.write(getTodayLabel());</script>
	</td>
	<td>
	<script>document.write(getToday()+1);</script>
	<br>
	<script>document.write(getTomrrowLabel());</script>
	</td>
	<td>
	<script>document.write(getToday()+2);</script>
	<br>
	<script>document.write(getDay1());</script></td>
	<td>
	<script>document.write(getToday()+3);</script>
	<br>
	<script>document.write(getDay2());</script></td>
	<td>
	<script>document.write(getToday()+4);</script>
	<br>
	<script>document.write(getDay3());</script></td>
	<td>
	<script>document.write(getToday()+5);</script>
	<br>요
	<script>document.write(getDay4());</script></td>
	<td>
	<script>document.write(getToday()+6);</script>
	<br>
	<script>document.write(getDay5());</script></td>
	
	<td>
	|&nbsp;&nbsp;&nbsp;<input type="button" value="클릭" onclick="window.open('cal.jsp','window_name','width=250,height=250,location=no,status=no,scrollbars=yes');" ></td>
	</tr>
</table>

<p align=center>무대인사&nbsp;&nbsp;&nbsp;회원시사&nbsp;&nbsp;&nbsp;오픈시사&nbsp;&nbsp;&nbsp;굿즈패키지&nbsp;&nbsp;&nbsp;싱어롱&nbsp;&nbsp;&nbsp;GV&nbsp;&nbsp;&nbsp;
조조&nbsp;&nbsp;&nbsp;브런치&nbsp;&nbsp;&nbsp;심야&nbsp;&nbsp;&nbsp;
</p>
<br><br><br>

<table align=center border=1px width=1000px>
<tr align=center>
	<td><a href="#"><button>서울</button></a></td>
	<td><a href="#"><button>경기</button></a></td>
	<td><a href="#"><button>인천</button></a></td>
	<td><a href="#"><button>대전</button></a></td>
	<td><a href="#"><button>대구</button></a></td>
	<td><a href="#"><button>광주</button></a></td>
	<td><a href="#"><button>강원</button></a></td>
</tr>
<tr>
	<td colspan=7>
		<table border=1px width=1000px>
		<tr>
			<td colspan=2>강남</td>
		</tr>
		<tr>
			<td width=100px>2관<br>총103석</td>
			<td>12:10<br>60석</td>
		</tr>
		<tr>
			<td>상영관</td>
			<td>상영시간</td>
		</tr>
		</table>
	</td>
</tr>
</table>

</body>
</html>