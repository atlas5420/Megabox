<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터 | 라이브씨어터,메가박스</title>
<%@ include file="jsp/link.jsp" %>
<link rel="stylesheet" href="css/customerservice_content.css?12">
<script src="js/board.js"></script>
</head>
<style>
	#wrap{background:white; height:1600px;}
	#nav {background-color:white;}
	#aside{background-color:white;}
</style>
<body>
<jsp:useBean id="bMgr" class="Board.BoardMgr" scope="page" />
<%@page import="java.util.*,Board.BoardBean" %>	<!-- ArrayList 사용위한 클래스 경로 설정-->
<%
	int totalRecord=0;
	int numPerPage=5;
	int totalPage=0;
	int totalBlock=0;
	int nowPage=1;
	int nowBlock=1;
	int pagePerBlock=10;//블럭당 페이지수(한블럭에 [1][2][3][4]...[15]까지 페이지 표시)
	
	int start=0;
	int end=5;
	String keyWord="";// 검색할 문자열
	String keyField="";//이름 제목 내용

	int listSize=0;
	if(request.getParameter("nowPage")!=null){
		nowPage=Integer.parseInt(request.getParameter("nowPage"));
	}
	start=(nowPage*numPerPage)-numPerPage;
	end=numPerPage;
	totalRecord=bMgr.getTotalCount(keyField,keyWord); //검색내용을 전달하여 만족하는 전체 레코드수 리턴
	totalPage= (int)Math.ceil((double)totalRecord/ numPerPage);	//전체 페이수 계산(1000개 게시물일때 페이수는 100페이지)
	totalBlock=(int)Math.ceil((double)totalPage/pagePerBlock);	//총 블럭(15개단위)개수 계산(1000개 게시물일때 블럭수는 7)
	nowBlock=(int)Math.ceil((double)nowPage/pagePerBlock); // 현재 블럭 계산(총블럭에서 몇번째인지)
	
	
	ArrayList<BoardBean> blist = bMgr.getBoardList(keyField, keyWord, start, end);
	
%>

	<div id="wrap">
		<header id="header">
			<jsp:include page="module/header.jsp" />
		</header>
		<div class="container">
			<div class="page-util"></div>
			<div class="inner-wrap">
				<div class="lnb-area">
					<aside id="aside">
						<jsp:include page="module/aside.jsp"/>
					</aside>
				</div>
				<div id="contents">
					<h2 class="tit">고객센터 홈</h2>
					<div class="input-search mb30">
						<div class="input_area">
							<label for="search01" class="label">
								빠른검색
							</label>
							<div class="board_search w460px">
								<input type="text" class="input_text" placeholder="검색어를 입력해주세요">
								<span style="color:gray"><i class="fas fa-search"></i></span>
							</div>
						</div>
					</div>
					<div class="customer_main">
						<div class="main_block">
							<div class="block_content">
								<a href="#">
									<p>
										<strong>
											자주묻는질문
										</strong>
										자주묻는질문을 확인해보세요
									</p>
								</a>
							</div>
							<div class="block_content">
								<a href="#">
									<p>
										<strong>
											분실물문의
										</strong>
										잃어버린 물건을 접수해주시면<br>
										신속히 찾아드리겠습니다
									</p>
								</a>
							</div>
							<div class="block_content">
								<a href="#">
									<p>
										<strong>
											1:1문의
										</strong>
										해결되지않은 문제가있나요?<br>
										1:1문의로 문의주세요
									</p>
								</a>
							</div>
							<div class="block_content">
								<a href="#">
									<p>
										<strong>
											단체관람 및 대관문의
										</strong>
										단체관람 또는 대관을 원하시면 
										<br>문의해주세요
									</p>
								</a>
							</div>
							<div class="block_content">
								<a href="#">
									<p>
										<strong>
											할인카드 안내
										</strong>
										멤버십 제휴카드 및 다양한 할인카드를<br> 
										통해 알뜰하게 영화감상하세요
									</p>
								</a>
							</div>
						</div>
						<div class="notice_block">
							<div class="block left">
								<div class="tit_area">
									<h3 class="tit small">자주묻는질문</h3>
									<a href="#" class="more">
										더보기
										<i class="fas fa-chevron-right"></i>
									</a>
								</div>
								<div>
									<ol class="list">
											<%
						listSize=blist.size();	//가져온 게시물의 개수를 listSize에 저장
						if(blist.isEmpty())
						{
							out.println("등록된 게시물이 없습니다.");
						}
						else
						{
							for(int i=0;i<numPerPage;i++)
							{
								if(i==listSize)
									break;
								
								BoardBean bean = blist.get(i);				
					%>
										<li>
											<a href="javascript:read('<%=bean.getNum()%>')">
												<span>
													<%=bean.getNum() %>
												</span>
												<span>
													[<%=bean.getDivi() %>]
												</span>
												<span>
													<%=bean.getSubject() %>
												</span>
												<span>
													<%=bean.getRegdate() %>
												</span>
											</a>
										</li>
		
					<%
							}
						}
					%>
									</ol>
								</div>
							</div>
							<div class="block right">
								<div class="tit_area">
									<h3 class="tit small">공지사항</h3>
									<a href="#" class="more">
										더보기
										<i class="fas fa-chevron-right"></i>
									</a>
								</div>
								<div>
									<ol class="list">
										<%
						listSize=blist.size();	//가져온 게시물의 개수를 listSize에 저장
						if(blist.isEmpty())
						{
							out.println("등록된 게시물이 없습니다.");
						}
						else
						{
							for(int i=0;i<numPerPage;i++)
							{
								if(i==listSize)
									break;
								
								BoardBean bean = blist.get(i);				
					%>
										<li>
											<a href="javascript:read('<%=bean.getNum()%>')">
												<span class="font-robo">
													<%=bean.getNum() %>
												</span>
												<span class="font-blue">
													[<%=bean.getDivi() %>]
												</span>
												<span>
													<%=bean.getSubject() %>
												</span>
												<span>
													<%=bean.getRegdate() %>
												</span>
											</a>
										</li>
		
					<%
							}
						}
					%>
									</ol>
								</div>
							</div>
						</div>
						<h3 class="tit mt70">이벤트</h3>
						<div class="event">
							<div class="left_banner">
								<a href="#">
									<img src="./img/event.JPG" alt="">
								</a>
							</div>
							<div class="right_banner">
								<a href="">
									<img src="./img/event2.JPG" alt="">
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
			
					
		<form name=readFrm method=get>
			<input type="hidden" name="num">
			<input type="hidden" name="nowPage" value=<%=nowPage%>>
		</form>
		 <footer id="footer">
			<jsp:include page="jsp/footerContents.jsp" />
		 </footer>
 
	</div>
</body>
</html>