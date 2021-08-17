<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.main-wrap{
	z-index: -1;
	display:block;
	
}
.layer-header {
	overflow: hidden;
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 45px;
    background: #503396;
}
.header-wrap {
	background-color: #503396;
}
.btn-login-close{
	float:right;
	display: block;
    position: absolute;
    top: 13px;
    right: 20px;
    width: 20px;
    height: 20px;
    margin: 0;
    padding: 0;
    border: 0;
    backgroung-color:none;
    text-indent: -9999px;
    background: url(./img/close.png) no-repeat center;
    cursor:pointer;
}

.tit {
	color: #fff;
    font-size: 1.2em;
    line-height: 10px;
}

.layer-content {
	z-index: 2;
	display:block;
	position:relative;
	background-color:yellow;
	top:50px;
	width: 800px;
	height: 400px;
}
.input-text {
    display: inline-block;
    width: 100%;
    height: 32px;
    padding: 0 10px;
    line-height: 30px;
    color: #444;
    border: 1px solid #d8d9db;
    vertical-align: middle;
    font-family: NanumBarunGothic,Dotum,'돋움',sans-serif;
}
.link a {
    display: inline-block;
    position: relative;
    vertical-align: middle;
    margin: 0 0 0 27px;
    padding: 0;
    font-size: .9333em;
    color: #666;
}
}

.link a:before {
    content: '';
    display: block;
    position: absolute;
    left: -15px;
    top: 50%;
    width: 1px;
    height: 16px;
    margin-top: -8px;
    background-color: #d8d9db;
    pointer-events: none;
}
</style>
</head>
<body>
<div class="main-container">
	<div class="main-wrap">
		<header class="layer-header">
			<div class="header-wrap">
				<h3 class="tit">로그인</h3>
				<input type="button" value="창닫기" class="btn-login-close" onclick="window.close()">
			</div>
		</header>
	</div>
	<form method=post action="C05LoginProc.jsp">
	<div class="layer-content">
		<div class="login-input-area">
			<input type="text" name="userid" placeholder="아이디" title="아이디를 입력하세요" class="input-text id">
			<input type="text" name="userpwd" placeholder="비밀번호" title="비밀번호를 입력하세요" class="input-text pwd">
			<div class="save-id">
				<input id="chkIdSave" type="checkbox">아이디 저장
			</div>
			<button id="btnLogin" type="button">로그인</button>
		</div>
		<div class="link">
			<a href="#" title="ID/PW 찾기 선택">ID/PW 찾기</a>
			<a href="#" title="회원가입 선택">회원가입</a>
			<a href="#" title="비회원 예매확인">비회원 예매확인</a>
		</div>
		<div class="sns-login">
			<a href="#" title="페이스북으로 로그인 선택">
				<img src="./img/ico-facebook.png" alt="페이스북">
			</a>
			<a href="#" title="네이버으로 로그인 선택">
				<img src="./img/ico-naver.png" alt="네이버">
			</a>
			<a href="#" title="카카오톡으로 로그인 선택">
				<img src="./img/ico-kakao.png" alt="카카오톡">
			</a>
			<a href="#" title="페이코으로 로그인 선택">
				<img src="./img/ico-payco.png" alt="페이코">
			</a>
		</div>
	</div>
	</form>
	
</div>

</body>
</html>