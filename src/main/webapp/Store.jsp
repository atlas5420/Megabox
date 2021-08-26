<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="jsp/link.jsp" %>
<link rel="stylesheet" href="css/store.css?1">
<style>
	#wrap{height:2300px;background-color:white;}
</style>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
		$(function(){
  $('.store > div').hide();
  $('.tab_list a').click(function () {
    $('.store > div').hide().filter(this.hash).fadeIn();
    $('.tab_list a').removeClass('active');
    $(this).addClass('active');
    return false;
  }).filter(':eq(0)').click();
  });
	</script>

</head>
<body>
	<div id="wrap">
		<header id="header">
			<%@include file="module/header.jsp" %>
		</header>
		<div class="content">
			<div class="inner-wrap">
				<h2 class="title">스토어</h2>
				<div class="tab_list">
					<ul>
						<li><a href="#store">새로운상품</a></li>
						<li><a href="#megaticket">메가티켓</a></li>
						<li>팝콘/음료/굿즈</li>
						<li>포인트몰</li>
					</ul>
				</div>
				<div id="store">
				<div class="storemain">
					<div class="bestgoods">
						<a href="#">
							<div class="slogun">
								<p class="font_blue">
									커피구독출시
								</p>
								<p class="font_purple">
									매일 커피한잔 구독
								</p>
							</div>
							<div class="goods">
								<p class="name">
									[처음구독특가]
								</p>
								<p class="txt">
									아메리카노30잔
								</p>
							</div>
							<div class="price">
								<p class="sale">
									<em>14,900</em>
									<span>원</span>
								</p>
								<p class="original">
									<em>0</em>
									<span>원</span>
								</p>
							</div>
							<p class="img">
								<img src="./img/bestgoods.png">
							</p>
						</a>
						
					</div>
				</div>
				<div class="tit">
					<h3 class="title">메가박스티켓</h3>
					<div class="right">
						<a href="#">더보기></a>
					</div>
				</div>
				<div id="megaticket" class="storelist">
					<ul class="list">
						<li>
							<a href="#">
								<div class="label">
									대표상품
								</div>
								<div class="img">
									<img src="./img/일반관람권.png" alt="">
								</div>
								<div class="info">
									<div class="tit">
										<p class="name">
											[2021] 일반관람권(2D)
										</p>
										<p class="bundle">
											일반관람권
										</p>
									</div>
									<div class="price">
										<p class="original">
											12,000원
										</p>
										<p class="sale">
											<em>11,000</em>
											<span>원</span>
										</p>
									</div>
								</div>
							</a>
						</li>
						<li>
							<a href="#">
								<div class="img">
									<img src="./img/더 부티크 전용관람권.png">
								</div>
								<div class="info">
									<div class="tit">
										<p class="name">
											더 부티크 전용관람권
										</p>
										<p class="bundle">
											2D 더 부티크 전용관람권
										</p>
									</div>
									<div class="price">
										<p class="original">
											14,000원
										</p>
										<p class="sale">
											<em>13,000</em>
											<span>원</span>
										</p>
									</div>
								</div>
							</a>
						</li>
						<li>
							<a href="#">
								<div class="img">
									<img src="./img/MX전용관람권.png">
								</div>
								<div class="info">
									<div class="tit">
										<p class="name">
											MX 전용 관람권
										</p>
										<p class="bundle">
											2D MX 전용관람권
										</p>
									</div>
									<div class="price">
										<p class="original">
											14,000원
										</p>
										<p class="sale">
											<em>13,000</em>
											<span>원</span>
										</p>
									</div>
								</div>
							</a>
						</li>
						<li>
							<div class="label">
								NEW
							</div>
							<a href="#">
								<div class="img">
									<img src="./img/Dolby.png">
								</div>
								<div class="info">
									<div class="tit">
										<p class="name">
											[2021] Dolby Cinema 전용관
											람권
										</p>
										<p class="bundle">
											Dolby Cinema 전용관람권(2D)
										</p>
									</div>
									<div class="price">
										<p class="original"></p>
										<p class="sale">
											<em>15,000</em>
											<span>원</span>
										</p>
									</div>
								</div>
							</a>
						</li>
					</ul>
					</div>
				</div>
				<div class="tit">
					<h3 class="title">팝콘/음료/굿즈</h3>
					<div class="right">
						<a href="#">더보기></a>
					</div>
				</div>
				<div class="storelist" id="megaticket">
					<ul class="list">
						<li>
							<a href="#">
								<div class="label new">
									NEW
								</div>
								<div class="img">
									<img src="./img/아메리카노30잔.png">
								</div>
								<div class="info">
									<div class="tit">
										<p class="name">
											[처음구독특가] 아메리카노30잔
										</p>
										<p class="bundle">
											아메리카노 30잔+영화관람권1매
										</p>
									</div>
									<div class="price">
										<p class="sale">
											<em>14,900</em>
											<span>원</span>
										</p>
										<p class="ea">
											240개 남음
										</p>
									</div>
								</div>
							</a>
						</li>
						<li>
							<div class="label">
								대표상품
							</div>
							<a href="#">
								<div class="img">
									<img src="./img/러브콤보.png">
								</div>
								<div class="info">
									<div class="tit">
										<p class="name">
											러브콤보
										</p>
										<p class="bundle">
											팝콘(L) 1+탄산음료(R) 2
										</p>
									</div>
									<div class="price">
										<p class="sale">
											<em>9,000</em>
											<span>원</span>
										</p>
									</div>
								</div>
							</a>
						</li>
						<li>
							<div class="label best">
								BEST
							</div>
							<a href="#">
								<div class="img">
									<img src="./img/더블콤보.png">
								</div>
								<div class="info">
									<div class="tit">
										<p class="name">
											더블콤보
										</p>
										<p class="bundle">
											팝콘(R) 2+탄산음료(R) 2
										</p>
									</div>
									<div class="price">
										<p class="original"></p>
										<p class="sale">
											<em>12,000</em>
											<span>원</span>
										</p>
									</div>
								</div>
							</a>
						</li>
					</ul>
				</div>
				<div></div>
				<div class="tit">
					<h3 class="title">포인트몰</h3>
					<div class="right">
						<a href="#">더보기></a>
					</div>
				</div>
				<div class="storelist" id="point">
					<ul class="list">
						<li>
							<a href="#">
								<div class="img">
									<img src="./img/포인트위크.jpg">
								</div>
								<div class="info">
									<div class="tit">
										<p class="name">
											[포인트위크 9월] 커밍순
										</p>
										<p class="bundle">
											메가7 포인트위크
										</p>
									</div>
									<div class="price">
										<p class="sale">
											<em>0</em>
											<span>Point</span>
										</p>
										<p class="ea">
											1개 남음
										</p>
									</div>
								</div>
							</a>
						</li>
						<li>
							<a href="#">
								<div class="img">
									<img src="./img/포인트위크.jpg">
								</div>
								<div class="info">
									<div class="tit">
										<p class="name">
											[포인트위크 9월] 커밍순2
										</p>
										<p class="bundle">
											메가7 포인트위크
										</p>
									</div>
									<div class="price">
										<p class="sale">
											<em>0</em>
											<span>Point</span>
										</p>
										<p class="ea">
											1개 남음
										</p>
									</div>
								</div>
							</a>
						</li>
						<li>
							<a href="#">
								<div class="img">
									<img src="./img/포인트위크.jpg">
								</div>
								<div class="info">
									<div class="tit">
										<p class="name">
											[포인트위크 9월] 커밍순3
										</p>
										<p class="bundle">
											메가7 포인트위크
										</p>
									</div>
									<div class="price">
										
										<p class="sale">
											<em>0</em>
											<span>Point</span>
										</p>
										<p class="ea">
											1개 남음
										</p>
									</div>
								</div>
							</a>
						</li>
						<li>
							<div class="label new">
								NEW
							</div>
							<a href="#">
								<div class="img">
									<img src="./img/포인트위크.jpg">
								</div>
								<div class="info">
									<div class="tit">
										<p class="name">
											[포인트위크 9월] 커밍순4
										</p>
										<p class="bundle">
											메가7 포인트위크
										</p>
									</div>
									<div class="price">
										<p class="sale">
											<em>0</em>
											<span>Point</span>
										</p>
										<p class="ea">
											1개 남음
										</p>
									</div>
								</div>
							</a>
						</li>
					</ul>
				</div>
				</div>
			</div>
			<footer id="footer">
				<%@include file="jsp/footerContents.jsp"  %>
			</footer>
		</div>
		
</body>
</html>