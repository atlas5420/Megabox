<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title> 회원가입 페이지 </title>
    <link href="./css/MemberJoin3.css" type="text/css" rel="stylesheet">
</head>
<body>
    <div class="body-wrap">
        <div class="member-wrap">
            <h1 class="gohome">
                <a href="./C01Main.jsp" title="메인 페이지로 이동"><img src="./img/megaboxlogo.png">MEGABOX : Life Theater</a> 
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
                            <td><input type="text" id="id" name="userid" placeholder="영문, 숫자 조합(8~12자)" class="input-text" required>
                                <a href="#"><input type=button value=중복확인 class="button idoverlap"></a></td>
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
                            <label for="ticketN">"사용안함"</label><br>
                            <span>※ '생년월일 + 휴대폰번호로' 티켓 출력</span>
                            </td>
                        </tr>
                        <tr>
                            <th class="c1">나만의 메가박스</th>
                            <td>
                            <span>자주 방문하는 메가박스를 등록해 주세요!</span>
                            <a href="#"><input type="button" value="설정" class="button setmegabox"></a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        <div class="marketing-agree">
            <p class="phr">마케팅 활용을 위한 개인정보 수집 이용 안내(선택)</p>
            <div class="cont">
                <dl>
                    <dt>수집목적</dt>
                    <dd>고객맞춤형 상품 및 서비스 추천, 당사 신규 상품/서비스 안내 및 권유,<br>
                        사은/할인 행사 등 각종 이벤트 정보 등의 안내 및 권유</dd>
                    <dt>수집항목</dt>
                    <dd>이메일, 휴대폰번호, 주소, 생년월일, 선호영화관, 문자/이메일/앱푸쉬<br>
                        정보수신동의 여부, 서비스 이용기록, 포인트 적립 및 사용 정보, 접속 로그</dd>
                    <dt>보유기간</dt>
                    <dd>회원 탈퇴 시 혹은 이용 목적 달성 시 까지</dd>
                </dl>
                <div class="markag radagree">
                    <input type="radio" id="agree" name="agreeSet">
                    <label for="agreeY">"동의"</label>
                    <input type="radio" id="disagree" name="agreeSet">
                    <label for="disagree">"미동의"</label>
                </div>
                <p class="samedt">혜택 수신설정</p>
                <div class="markag chebox">
                    <input type="checkbox" id="push">
                    <label for="push">알림</label>
                    <input type="checkbox" id="SMS">
                    <label for="SMS">SMS</label>
                    <input type="checkbox" id="email">
                    <label for="email">이메일</label>
                </div>
                <p class="samedd">
                    ※ 이벤트, 신규 서비스, 할인 혜택 등의 소식을 전해 드립니다.<br>
                    (소멸포인트 및 공지성 안내 또는 거래정보와 관련된 내용은<br> 수신 동의 여부와 상관없이 발송됩니다.)
                </p>
            </div>
        </div>
        <br>
        <div class="footer">
        <input type="submit" value="회원가입" class="button join">
        </div>
        
        </form>
        
        
        </div>
        </div>
        </div>
</body>
</html>