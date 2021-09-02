<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/login.js"></script>
</head>

<body>
	<h1 class="ci">
		<a href="#">메가박스</a>
     </h1>
     <div class="util_area">
             <div class="left_link">
                    <a href="">VIP LOUNGE</a>
                    <a href="">멤버십</a>
                    <a href="">고객센터</a>
                </div>
                <div class="right_link">
                    <div class="before">
                        <a href="">로그인</a>
                        <a href="">회원가입</a>
                    </div>
                    <a href="#">빠른예매</a>
                </div>
            </div>
            <div class="link">
                <a href="" class="sitemap"></a>
                <a href="" class="search"></a>
                <a href="" class="ticket"></a>
                <a href="" class="mypage"></a>

            </div>
	<nav id="gnb">
              <ul class="gnb_depth1">
                <li>
                      <a href="" class="gnb-txt-movie">영화</a>
                      <div class="gnb_depth2">
                          <ul>
                            <li>
                                <a href="">전체영화</a>
                            </li>
                            <li>
                                <a href="">N스크린</a>
                            </li>
                            <li>
                                <a href="">큐레이션</a>
                            </li>
                            <li>
                                <a href="">무비포스트</a>
                            </li>
                          </ul>

                      </div>
                </li>
                <li>
                    <a href="" class="gnb-txt-reserve"></a>
                    <div class="gnb_depth2">
                        <ul>
                          <li>
                              <a href="">빠른예매</a>
                          </li>
                          <li>
                              <a href="">상영시간표</a>
                          </li>
                          <li>
                              <a href="">더 부티크 프라이빗예매</a>
                          </li>
                        </ul>
                    </div>
                </li>
                <li>
                    <a href="" class="gnb-txt-theater"></a>
                    <div class="gnb_depth2">
                        <ul>
                          <li>
                              <a href="">전체극장</a>
                          </li>
                          <li>
                              <a href="">특별관</a>
                          </li>
                        </ul>
                    </div>
                </li>
                <li>
                    <a href="" class="gnb-txt-event"></a>
                    <div class="gnb_depth2">
                        <ul>
                          <li>
                              <a href="">진행중이벤트</a>
                          </li>
                          <li>
                              <a href="">지난이벤트</a>
                          </li>
                          <li>
                              <a href="">당첨자발표</a>
                          </li>
                        </ul>

                    </div>
                </li>
                <li>
                    <a href="" class="gnb-txt-store"></a>
                </li>
                <li>
                    <a href="" class="gnb-txt-benefit"></a>
                    <div class="gnb_depth2">
                        <ul>
                          <li>
                              <a href="">메가박스멤버십</a>
                          </li>
                          <li>
                              <a href="">제휴/할인</a>
                          </li>
                        </ul>
                    </div>
                </li>
              </ul>
            </nav>

	 <div id="my_modal" class="modal-layer">
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

    </div>
</body>
</html>