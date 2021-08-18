<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title> 회원가입 페이지 </title> 
<style>
.body-wrap {
    width: 100%;
    height: 100%;
    padding: 0;
}
* {
    box-sizing: border-box;
}
div {
    display: block;
}
ol, ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
}
body {
    overflow: auto;
    overflow-y: scroll;	/* 스크롤바 */
    letter-spacing: 0; /* 글자간격 */
    line-height: 1.5;
    font-size: 15px;
    color: #444;
    font-weight: 400;
    font-family: NanumBarunGothic,Dotum,'돋움',sans-serif;
}
.member-wrap{
	width: 720px;
    min-height: 100%;
    margin: 0 auto;
    padding: 80px 100px;
    background-color: #fff;
}
.gohome {
	overflow: hidden;
    display: block;
    margin: 0;
    padding: 0 0 70px 0;
    background-color:black;
}
.gohome a{
	display: block;
    width: 140px;
    height: 47px;
    margin: 0 auto;
    padding: 0;
    font-size: 0;
    line-height: 0;
    background: url(./img/megaboxlogo.png) center no-repeat;
}
.col-wrap{
	over-flow:hidden;
}
.step-member{
	overflow: hidden;
    position: relative;
    margin: 0 0 40px 0;
    padding: 0;
}
.step-member ol li:first-child {
	margin:left: 0;
}
.step-member ol li {
	float:left;
	margin:0 0 0 27px;
	padding:0;
	text-align: center;
	font-size: .9333em;
}
.member-wrap .step-member ol li .step {
    display: inline-block;
    position: relative;
    z-index: 2;
    margin: 0;
    padding: 0 0 15px 0;
    font-size: .9333em;
    letter-spacing: 0;
}
.member-wrap .step-member ol li .step.on {
    border-bottom: 2px solid #503396;
    color: #503396;
}
.step-member:after {
	content:'';
	overflow:hidden;
	position:absolute;
	left:0;
	bottom:0;
	width:100%;
	height:1px;
	background-color:#ebebeb;
}
.page-info-txt h3 {
	display:block;
	padding:0 0 10px 0;
	color: #222;
}
colgroup {
	    display: table-column-group;
}
col {
    display: table-column;
}
tbody {
    display: table-row-group;
    vertical-align: middle;
    border-color: inherit;
}
table {
    width: 100%;
    margin: 0;
    border: 0;
    table-layout: fixed;
    border-collapse: collapse;
    empty-cells: show;
}
.board-form tbody td, .board-form tbody th {
    position: relative;
    height: 50px;
    padding: 7px 15px;
    text-align: left;
    border-bottom: 1px solid #d1d5dd;
}
.board-form tbody th {
	background:#f7f8f9;
	width:150px;
}

.input-text {
    display: inline-block;
    width: 260px!important;
    height: 32px;
    padding: 0 10px;
    line-height: 30px;
    color: #444;
    border: 1px solid #d8d9db;
    vertical-align: middle;
    font-family: NanumBarunGothic,Dotum,'돋움',sans-serif;
}
.button {
    display: inline-block;
    height: 30px;
    margin: 0;
    padding: 0 15px;
    text-align: center;
    line-height: 34px;
    color: #503396;
    font-weight: 400;
    border-radius: 4px;
    font-family: NanumBarunGothic,Dotum,'돋움',sans-serif;
    text-decoration: none;
    border: 1px solid #503396;
    vertical-align: middle;
    background-color: #fff;
    cursor: pointer;
}
.button.idoverlap {
	padding : 0 5px;
	border : 1px solid #c1c1c1;
	color : #777;
	background-color : #e0e0e0;
	font-size : .8111em;
	margin-left: 2px!important;
	width:69px;
	line-height: 25px;
}


</style>
</head>

<body> 
<div class="body-wrap">
<div class="member-wrap">
	<h1 class="gohome">
		<a href="./C01Main.jsp" title="메인 페이지로 이동">MEGABOX : Life Theater</a> 
	</h1>
	<div class="col-wrap">
		<div class="step-member">
			<ol>
				<li>
					<p class="step">STEP1.본인인증</p>
				</li>
				<li>
					<p class="step">STEP2.약관동의</p>
				</li>
				<li>
					<p class="step on">STEP3.정보입력</p>
				</li>
				<li>
					<p class="step">STEP4.가입완료</p>
				</li>
			</ol>
		</div>
		<p class="page-info-txt">
			<h3>*님 안녕하세요.</h3>
			<font size=2px color=gray>회원정보를 입력해주세요</font>
		</p>


<form method="post" action=C06MemberProc.jsp>  	
	<div class="table-wrap">
		<colgroup>
			<col style="width:130px;">
			<col>
		</colgroup>
		<table class="board-form">
			<tbody>
				<tr>
					<th class="c1">생년월일</th>
					<td><input type="text" id="birth" name="userbirth" placeholder="생년월일 입력" class="input-text" required></td>
				</tr>
				<tr>
					<th class="c1">휴대폰 번호</th>
					<td>
					<input type="tel" size=5px name="ph1" placeholder="01*" pattern=[0-1]{3} class="input-text ph1" required> 
					- 
					<input type="tel" size=5px name="ph2" placeholder="****" pattern=[0-9]{3,4} class="input-text ph2" required> 
					- 
					<input type="tel" size=5px name="ph3" placeholder="****" pattern=[0-9]{4} class="input-text ph3" required></td>
				</tr>
				<tr>
					<th class="c1">아이디</th>
					<td><input type="text" id="id" name="userid" placeholder="영문, 숫자 조합(8~12자)" class="input-text" required> <a href="#"><input type=button value=중복확인 class="button idoverlap"></a></td>
				</tr>
				<tr>
					<th class="c1">비밀번호</th>
					<td><input type="password" id="pwd" name="pwd" placeholder="영문, 숫자, 특수기호 중 2가지 이상 조합" class="input-text" required></td>
				</tr>
				<tr>
					<th class="c1">비밀번호확인</th>
					<td><input type="password" id="pwcheck" name="pwcheck" placeholder="영문, 숫자, 특수기호 중 2가지 이상 조합" class="input-text" required></td>
				</tr>
				<tr>
					<th class="c1">이메일</th>
					<td><input type="email" name=email placeholder="이메일주소를 입력해 주세요" class="input-text" required></td>
				</tr>
				<tr>
					<th class="c1">무인발권기<br>기능 설정</th>
					<td>
					<input type="radio" id="ticketY" name="ticketSet">
					<label for="ticketY">"사용"</label>
					<input type="radio" id="ticketN" name="ticketSet">
					<label for="ticketN">"사용안함"</label>
					<span>※ '생년월일 + 휴대폰번호로' 티켓 출력</span>
					</td>
				</tr>
				<tr>
					<th class="c1">나만의 메가박스</th>
					<td>
					<span>자주 방문하는 메가박스를 등록해 주세요!</span>
					<a href="#"><input type="button" value="설정"></a>
					</td>
				</tr>
			</tbody>
		</table>
	</div>

<br>
<div class="footer">
<input type="submit" value=가입하기 id="fbtn1">
<button type="reset" id="fbtn2" >취소하기</button>
</div>

</form>


</div>
</div>
</div>
</body>
</html>








