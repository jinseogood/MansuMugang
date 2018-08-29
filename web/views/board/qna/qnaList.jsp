<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import = "java.util.*, com.msmg.board.qna.model.vo.*"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list");
	
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	
%>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8>
<title>QnA</title>
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

table{
font-family: 'Nanum Gothic', sans-serif;
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
	background-image:url("/msmg/images/common/Q.png");
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
<!-- 게시판 리스트 -->
<div id = "jjff">
	<%@ include file = "../../common/menubar.jsp" %>
</div>
	<!-- <div id = "botitle">
		<label id = "offi">공지사항</label><br>
		<label style = "margin-left : 18%; font-size:17px;"><p>게시된 의견은 회신되지 않으며, 게시판의 효과적인 운영을 위하여 비방 · 욕설, 음란한 표현, 상업적인 광고, 동일한 내용 반복게시, 특정인의
		개인정보 유출 등 <br>홈페이지의 정상적인 운영을 저해하는 내용은 게시자에게 통보하지 않고 삭제될 수 있음을 알려드립니다.<br><br>

		타인의 저작물(신문기사, 사진, 동영상 등)을 관리자의 허락 없이 무단으로 복제하여 올리는 것은 저작권 침해에 해당합니다.</p></label>
	</div> -->
	<%if(loginUser != null){ %>
	<div id = 'wrap'>
	<table align='center' cellpadding="0" cellspacing="0" border="0">

		<!-- s : 게시판 타이틀 -->
		<tr
			style="background: url('/msmg/images/board/table_mid2.png') /* #E8E8E8 */ repeat-x; height : 30px;">
			<td width="5"><img src="/msmg/images/board/table_left1.png" width="5" style = "background : no-repeat;"
				height="30" /></td>
			<td width="73"><span>번호</span></td>
			<td width="630"><span>제목</span></td>
			<td width="73"><span>작성자</span></td>
			<td width="164"><span>작성일</span></td>
			<td width="58"><span>조회수</span></td>
			<td width="7"><img src="/msmg/images/board/table_right1.png" width="5"  style = "background : no-repeat;"
				height="30" /></td>
		</tr>
		<!-- e : 게시판 타이틀 -->
		<!-- s: 게시글 테스트 영역 -->
		
		<% 
			if(list.size() > 0){ 
				for(Qna q : list){
		%>
		<tr id='content'>
			<td></td>
			<% if(q.getRef_bno() == q.getBoard_id()){ %>
			<td><%= q.getBoard_no() %></td>
			<td style = "text-align : left;"><a href = "<%= request.getContextPath() %>/qnaDetail.qna?board_id=<%=q.getBoard_id() %>"><%= q.getTitle()  %></a></td>
			<%}else{ %>
			<td></td>
			<td style = "text-align : left;"><a href = "<%= request.getContextPath() %>/qnaDetail.qna?board_id=<%=q.getBoard_id() %>">
			<img src = '/msmg/images/board/enter.png'><%= q.getTitle() %></a></td>
			<%} %>
			<td><%= q.getU_name() %></td>
			<td><%= q.getBoard_date() %></td>
			<td><%= q.getB_count() %></td>
			<td></td>
		</tr>
		<tr height='1' bgcolor="#D2D2D2">
			<td colspan="6" width="752"></td>
		</tr>
		
		<%}
				}else{%>
		<tr id='content'>
			<td colspan='7'>등록된 글이 없습니다.</td>
		</tr>
		<%} %>
		<!-- e: 게시글 테스트 영역 끝 -->

		<!-- 게시판 끝 -->
		<tr bgcolor="#ff6347" style="height: 1px;">
			<td colspan="6"></td>
		</tr>
		<!-- 게시판 끝 -->
	</table>
	<div id = 'btnlist' align = "right">
	<button id = 'insert' class="btn btn-primary btn-sm" onclick = 'location.href = "<%= request.getContextPath() %>/insertQna.Qna"'>작성</button>
	</div>
	<div id="container">
		<button onclick = 'location.href = "<%=request.getContextPath()%>/qnaList.qna?currentPage=1"'><<</button>
			<% if(currentPage <= 1){ %>
				<button disabled><</button>
			<%}else{%>
				<button onclick = "location.href = '<%=request.getContextPath()%>/qnaList.qna?currentPage=<%=currentPage - 1%>'"><</button>
			<%} %>
			<%for(int p = startPage; p <= endPage; p++){
				if(p == currentPage){%>
					<button disabled><%= p %></button>				
			<%}else{%>
					<button onclick = "location.href ='<%=request.getContextPath() %>/qnaList.qna?currentPage=<%=p %>'"><%=p %></button>
			<%}} %>
			
			<% if(currentPage >= maxPage){ %>
				<button disabled>></button>
			<%}else{ %>
				<button onclick = "location.href = '<%=request.getContextPath() %>/qnaList.qna?currentPage=<%=currentPage + 1 %>'">></button>
			<%} %>
				<button onclick = "location.href = '<%=request.getContextPath() %>/qnaList.qna?currentPage=<%=maxPage %>'">>></button>
	</div>
	
</div>
<%}else{
	//request.setAttribute("msg", "잘못된 경로");
	//request.getRequestDispatcher("../../member/LoginForm.jsp").forward(request, response);
	response.sendRedirect("../../member/LoginForm.jsp");
}%>
<div id="mainBottom">
<%@include file = "../../common/footer.jsp" %>
</div>
</body>
</html>