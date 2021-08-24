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
            <a href="#" title="MegaBox ������������ �̵�" class="gohome">HOMEPAGE</a>
        </h1>

        <div class="util-area">
            <div class="left-link">
                <a href="#" title="VIP LOUNGE">VIP LOUNGE</a>
                <a href="#" title="�����">�����</a>
                <a href="#" title="������">������</a>
            </div>
            <div class="right-link">
                <!-- �α����� -->   
                <div class="beforelogin r2">
                    <a href="#" title="��������">��������</a>
                </div>
                <div class="beforelogin r1">
                    <a onclick="LoginPopup()" title="�α���">�α���</a>
                    <a href="../LoginMemberjoin/logjoin/MemberJoin3.jsp" title="ȸ������">ȸ������</a>
                </div>
                <!-- �α����� -->
    <!-- 
                <div class="afterlogin" style="display: none;">
                    <a href="#" title="�α׾ƿ�">�α׾ƿ�</a>
                    <a href class="notice" title="�˸�">�˸�</a>
                    <div class="notice-wrap">
                        <p class="tit-notice">�˸���</p>
                        <div class="count">
                            <p class="left">
                                ��ü
                                <em class="totalCnt">0</em>
                                ��
                            </p>
                            <p class="right">* �ֱ� 30�� ������ ����˴ϴ�.</p>
                        </div>


                    </div>
                </div>
    -->

            </div>
        </div>

        <div class="link-area">
            <a href="#" title="����Ʈ��" class="header-openlayer sitemap">����Ʈ��</a>
            <a href="#" title="�˻�" class="header-openlayer search">�˻�</a>
            <a href="#" title="�󿵽ð�ǥ" class="link-ticket">�󿵽ð�ǥ</a>
            <a href="#" title="���� �ް��ڽ�" class="header-openlayer user">���� �ް��ڽ�</a>
        </div> 


        <nav id="gnb">
            <ul class="gnb-depth1">
                <li>
                    <a href="#" class="gnb-movie" title="��ȭ">��ȭ</a>
                            <ul class="gnb-depth2 mov">
                                <li><a href="#" title="��ü��ȭ">��ü��ȭ</a></li>
                                <li><a href="#" title="N��ũ��">N��ũ��</a></li>
                                <li><a href="#" title="ť���̼�">ť���̼�</a></li>
                                <li><a href="#" title="��������Ʈ">��������Ʈ</a></li>
                            </ul>
                </li>
                <li>
                    <a href="#" class="gnb-reserve" title="����">����</a> 
                        <ul class="gnb-depth2 resv">
                            <li><a href="#" title="��������">��������</a></li>
                            <li><a href="#" title="�󿵽ð�ǥ">�󿵽ð�ǥ</a></li>
                            <li><a href="#" title="�� ��Ƽũ �����̺� ����">�� ��Ƽũ �����̺� ����</a></li>
                        </ul>   
                </li>
                <li>
                    <a href="#" class="gnb-theater" title="����">����</a> 
                        <ul class="gnb-depth2 tht">
                            <li><a href="#" title="��ü����">��ü����</a></li>
                            <li><a href="#" title="Ư����">Ư����</a></li>
                        </ul>
                </li>
                <li>
                    <a href="#" class="gnb-event" title="�̺�Ʈ">�̺�Ʈ</a>
                        <ul class="gnb-depth2 evt">
                            <li><a href="#" title="������ �̺�Ʈ">������ �̺�Ʈ</a></li>
                            <li><a href="#" title="���� �̺�Ʈ">���� �̺�Ʈ</a></li>
                            <li><a href="#" title="��÷�ڹ�ǥ">��÷�ڹ�ǥ</a></li>
                        </ul>
                </li>
                <li>
                    <a href="#" class="gnb-store" title="�����">�����</a> 
                </li>
                <li>
                    <a href="#" class="gnb-benefit" title="����">����</a> 
                        <ul class="gnb-depth2 bnft">
                            <li><a href="#" title="�ް��ڽ� �����">�ް��ڽ� �����</a></li>
                            <li><a href="#" title="����/����">����/����</a></li>
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
                    <a href="#" title="��ȭ �������� �̵�">
                    ��ȭ
                    </a>
                    <span><img src="../img/bg-location-arr.png" class="arrimg"></span>
                    <a href="#" title="��ü��ȭ �������� �̵�">
                    ��ü��ȭ
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