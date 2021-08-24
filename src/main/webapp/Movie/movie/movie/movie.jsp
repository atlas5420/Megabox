<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link href="../css/moviestyle.css" type="text/css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/js/all.min.js"></script>
    <script lang="javascript">
        function LoginPopup() {window.open("../LoginMemberjoin/LoginPopup.jsp", "a", "width=850, height=500, left=200, top=150")}
    </script>
</head>
<body>
    <header id="header">
        <h1 class="homepos">
            <a href="#" title="MegaBox 메인페이지로 이동" class="gohome">HOMEPAGE</a>
        </h1>

        <div class="util-area">
            <div class="left-link">
                <a href="#" title="VIP LOUNGE">VIP LOUNGE</a>
                <a href="#" title="멤버십">멤버십</a>
                <a href="#" title="고객센터">고객센터</a>
            </div>
            <div class="right-link">
                <!-- 로그인전 -->   
                <div class="beforelogin r2">
                    <a href="#" title="빠른예매">빠른예매</a>
                </div>
                <div class="beforelogin r1">
                    <a onclick="LoginPopup()" title="로그인">로그인</a>
                    <a href="../LoginMemberjoin/logjoin/MemberJoin3.jsp" title="회원가입">회원가입</a>
                </div>
                <!-- 로그인후 -->
    <!-- 
                <div class="afterlogin" style="display: none;">
                    <a href="#" title="로그아웃">로그아웃</a>
                    <a href class="notice" title="알림">알림</a>
                    <div class="notice-wrap">
                        <p class="tit-notice">알림함</p>
                        <div class="count">
                            <p class="left">
                                전체
                                <em class="totalCnt">0</em>
                                건
                            </p>
                            <p class="right">* 최근 30일 내역만 노출됩니다.</p>
                        </div>


                    </div>
                </div>
    -->

            </div>
        </div>

        <div class="link-area">
            <a href="#" title="사이트맵" class="header-openlayer sitemap">사이트맵</a>
            <a href="#" title="검색" class="header-openlayer search">검색</a>
            <a href="#" title="상영시간표" class="link-ticket">상영시간표</a>
            <a href="#" title="나의 메가박스" class="header-openlayer user">나의 메가박스</a>
        </div> 


        <nav id="gnb">
            <ul class="gnb-depth1">
                <li>
                    <a href="#" class="gnb-movie" title="영화">영화</a>
                            <ul class="gnb-depth2 mov">
                                <li><a href="#" title="전체영화">전체영화</a></li>
                                <li><a href="#" title="N스크린">N스크린</a></li>
                                <li><a href="#" title="큐레이션">큐레이션</a></li>
                                <li><a href="#" title="무비포스트">무비포스트</a></li>
                            </ul>
                </li>
                <li>
                    <a href="#" class="gnb-reserve" title="예매">예매</a> 
                        <ul class="gnb-depth2 resv">
                            <li><a href="#" title="빠른예매">빠른예매</a></li>
                            <li><a href="#" title="상영시간표">상영시간표</a></li>
                            <li><a href="#" title="더 부티크 프라이빗 예매">더 부티크 프라이빗 예매</a></li>
                        </ul>   
                </li>
                <li>
                    <a href="#" class="gnb-theater" title="극장">극장</a> 
                        <ul class="gnb-depth2 tht">
                            <li><a href="#" title="전체극장">전체극장</a></li>
                            <li><a href="#" title="특별관">특별관</a></li>
                        </ul>
                </li>
                <li>
                    <a href="#" class="gnb-event" title="이벤트">이벤트</a>
                        <ul class="gnb-depth2 evt">
                            <li><a href="#" title="진행중 이벤트">진행중 이벤트</a></li>
                            <li><a href="#" title="지난 이벤트">지난 이벤트</a></li>
                            <li><a href="#" title="당첨자발표">당첨자발표</a></li>
                        </ul>
                </li>
                <li>
                    <a href="#" class="gnb-store" title="스토어">스토어</a> 
                </li>
                <li>
                    <a href="#" class="gnb-benefit" title="혜택">혜택</a> 
                        <ul class="gnb-depth2 bnft">
                            <li><a href="#" title="메가박스 멤버십">메가박스 멤버십</a></li>
                            <li><a href="#" title="제휴/할인">제휴/할인</a></li>
                        </ul>
                </li>
            </ul>
        </nav>

    </header>
<!-- 
    <div class="container">
        <div class="page-util">
            <div class="inner-wrap">
                <div class="locate">
                    <span><img src="../img/bg-location-home.png" alt="HOME" class="homeimg"></span>
                    <span><img src="../img/bg-location-arr.png" class="arrimg"></span>
                    <a href="#" title="영화 페이지로 이동">
                    영화
                    </a>
                    <span><img src="../img/bg-location-arr.png" class="arrimg"></span>
                    <a href="#" title="전체영화 페이지로 이동">
                    전체영화
                    </a>
                </div>
            </div>

         
            <div class="contents">
                <div class="inner-wrap">
                    <h2 class="allmovie"></h2>
                    <div></div>
                </div>
            </div>

        </div>
        
    </div>
 -->

</body>
</html>