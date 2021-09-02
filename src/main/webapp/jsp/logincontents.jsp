<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="wrap">
            <header class="header">
                <h3 class="tit">로그인</h3>
            </header>
            <div class="layer-con" style="height:439px;">
                <div class="tab-wrap">
                    <div class="logintab">
                        <div class="loginmember">
                            <div class="inner-wrap">
                                <div class="col left">
                                    <div class="login-input">
                                        <input type="text" name="userid" placeholder="아이디" title="아이디를 입력하세요" class="input-text id">
                                        <input type="password" name="userpwd" placeholder="비밀번호" title="비밀번호를 입력하세요" class="input-text pwd">
                                        <div class="chk-util">
                                            <div class="left">
                                                <input type="checkbox" id="chkid">
                                                <label for="chkid">
                                                    아이디저장
                                                </label>
                                            </div>
                                            <div class="right">
                                                <div class="ad">
                                                    <a href="#" title="휴대폰간편로그인선택" target="_blank">
                                                        <span>
                                                            휴대폰간편로그인
                                                        </span>
                                                        <em>
                                                            광고
                                                        </em>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                        <button id="btnLogin" type="button">로그인</button>
                                        <div class="link">
                                            <a href="">
                                                ID/PW찾기
                                            </a>
                                            <a href=""> 
                                                회원가입
                                            </a>
                                            <a href="">
                                                비회원 예매
                                            </a>
                                        </div>
                                        <div class="snslogin">
                                            <a href="">
                                            	<img src="img/ico-facebook.png">
                                            </a>
                                            <a href="">
												<img src="img/ico-kakao.png">
											</a>
                                            <a href="">
                                            	<img src="img/ico-naver.png">
                                            </a>
                                            <a href="">
                                            	<img src="img/ico-payco.png">
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col right">
                                    <div>
                                        <a href="">
                                            
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <button type="button" class="btn-modal-close">

            </button>
      </div>
</body>
</html>