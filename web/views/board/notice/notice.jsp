<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import = "java.util.*, com.msmg.board.notice.model.vo.*"%>
<%
	//페이징 처리
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	
	int listCount = pi.getListCount(); //리스트 갯수
	int currentPage = pi.getCurrentPage(); //현재 페이지
	int maxPage = pi.getMaxPage(); //최대 페이지
	int startPage = pi.getStartPage(); // 시작 페이지
	int endPage = pi.getEndPage(); // 끝 페이지
%>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8>
<title>공지사항 :: 공지사항</title>
<!-- 폰트 -->
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<style>
table tr {
	text-align: center;
	font-size: 13;
}

table tr:first-child {
	font-size: 12;
}

a {
	text-decoration: none;
	color: black;
}

a:hover {
	color: red;
}

#content {
	height: 25px;
}

#container {
	width: 100%;
	margin-left: 0 auto;
	margin-right: 0 auto;
	text-align: center;
}

#container ul{
	display : inline-block;
}
div #offi {
	margin-left: 20%;
	margin-bottom: 15px;
	font-size: 32;
}

 #wrap {
 	margin-left : auto;
 	margin-right : auto;
 	margin-top : 20px;
 	width : 1000px;
 	height:1300px;
 }
 
 #wrap #btnlist #btn {
 	align : left;
 }
 
 #insert {
 	margin-top : 10px;
 	   background:tomato;
 }
 
 #botitle {
 	height : 150px;
 }
 
 #jjff {
 	height:400px;
	background-image:url("/msmg/images/common/notice.png");
	margin-bottom:15px;
 }
 
 #botitle #botitle_sub {
 	border : 1px solid black;
 }
 #botitle #botitle_sub div{
 display : inline-block;
	border : 1px solid black;
	height : 40px;
	width : 300px;
}

#mainBottom {
	width:100%;
	height:200px;
}

#container button {
   background:tomato;
   border:none;
   color:white;
    border-radius:12px;
    border : 1px solid tomato;
}
</style>
</head>
<body>
	<!-- s : 메뉴바 추가 -->
	<div id = "jjff">
		<%@ include file = "../../common/menubar.jsp" %>
	</div>
	<!-- e : 메뉴바 추가 -->
	
	<!-- 게시판 리스트 -->
	<div id = 'wrap'>
		<table align='center' cellpadding="0" cellspacing="0" border="0">
			<!-- s : 게시판 타이틀 -->
			<tr	style="background: url('/msmg/images/board/table_mid2.png') /* #E8E8E8 */ repeat-x; height : 30px;">
				<td width="5"><img src="/msmg/images/board/table_left1.png" width="5" style = "background : no-repeat;" height="30" /></td>
				<td width="73"><span>번호</span></td>
				<td width="630"><span>제목</span></td>
				<td width="73"><span>작성자</span></td>
				<td width="164"><span>작성일</span></td>
				<td width="58"><span>조회수</span></td>
				<td width="7"><img src="/msmg/images/board/table_right1.png" width="5"  style = "background : no-repeat;" height="30" /></td>
			</tr>
			<!-- e : 게시판 타이틀 -->
			
			<!-- s : 게시글 리스트 영역 -->
			<% if(list.size() > 0){ 
				for(Notice n : list){ %>
			<!-- 페이지 리스트 출력 -->
			<tr id='content'>
				<td></td>
				<td><%= n.getBoard_no() %></td>
				<td><a href = "<%= request.getContextPath() %>/noticeDetail.no?board_no=<%=n.getBoard_no() %>"><%= n.getTitle()  %></a></td>
				<td><%= n.getU_name() %></td>
				<td><%= n.getBoard_date() %></td>
				<td><%= n.getB_count() %></td>
				<td></td>
			</tr>
			<tr height='1' bgcolor="#D2D2D2">
				<td colspan="6" width="752"></td>
			</tr>
		<%}
				}else{%>
			<!-- 리스트에 공지사항이 없을 때 -->
			<tr id='content'>
				<td colspan='7'>등록된 글이 없습니다.</td>
			</tr>
		<%} %>
		<!-- e: 게시글 리스트 영역 -->

		<!-- 게시판 끝 -->
		<tr bgcolor="#ff6347" style="height: 1px;">
			<td colspan="6"></td>
		</tr>
	</table>
	<!-- 게시판 끝 -->
	<!-- 글쓰기  -->
	<div id = 'btnlist' align = "right" style = "height : 10px;"></div>
		<!-- s : 페이징 처리 -->
		<div id="container">
			<button onclick = 'location.href = "<%=request.getContextPath()%>/noticeList.no?currentPage=1"'><<</button>
				<% if(currentPage <= 1){ %>
					<button disabled><</button>
				<%}else{%>
					<button onclick = "location.href = '<%=request.getContextPath()%>/noticeList.no?currentPage=<%=currentPage - 1%>'"><</button>
				<%} %>
				<%for(int p = startPage; p <= endPage; p++){
					if(p == currentPage){%>
						<button disabled><%= p %></button>				
				<%}else{%>
						<button onclick = "location.href ='<%=request.getContextPath() %>/noticeList.no?currentPage=<%=p %>'"><%=p %></button>
				<%}} %>
				<% if(currentPage >= maxPage){ %>
					<button disabled>></button>
				<%}else{ %>
					<button onclick = "location.href = '<%=request.getContextPath() %>/noticeList.no?currentPage=<%=currentPage + 1 %>'">></button>
				<%} %>
					<button onclick = "location.href = '<%=request.getContextPath() %>/noticeList.no?currentPage=<%=maxPage %>'">>></button>
		</div>
		<!-- e : 페이징 처리  -->
	</div>
	<!-- s : 풋터 추가 -->
	<div id="mainBottom">
		<%@include file = "../../common/footer.jsp" %>
	</div>
	<!-- e : 풋터 추가 -->
</body>
</html>