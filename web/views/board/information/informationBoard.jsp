<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.msmg.board.information.model.vo.*"%>
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");

	
 	PageInfo pi = (PageInfo)request.getAttribute("pi");
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
<title>정보게시판</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* body {
	background:pink;
} */
#back {
	width: 100%;
	height: 400px;
	/* background:#ffa500; */
	background-image: url("/msmg/images/common/information.png");
	margin-bottom: 20px;
}

.outer {
	width: 1000px;
	height: 1300px;
	margin-left: auto;
	margin-right: auto;
}

table tr {
	text-align: center;
	font-size: 15;
}


table tr:first-child {
	font-size: 15;
}

table td {
	margin:10px;
	font-size:15;
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

#container ul {
	display: inline-block;
}

div #offi {
	margin-left: 25%;
	margin-bottom: 15px;
	font-size: 32;
}

.pagination>.active>a, .pagination>.active>a:focus, .pagination>.active>a:hover,
	.pagination>.active>span, .pagination>.active>span:focus, .pagination>.active>span:hover
	{
	background-color: #D8D8D8;
	color: red;
}

#wrap {
	margin-left: auto;
	margin-right: auto;
	margin-top: 20px;
	width: 1000px;
}

#botitle {
	margin-left: 50px;
}

#wrap #btnlist #btn {
	align: left;
}

#insert {
	margin-top: 10px;
}

#jjff {
	height: 35%;
}

#botitle #botitle_sub {
	border: 1px solid black;
}

#search {
	width: 150px;
	margin-top: 10px;
}

#fas {
	background-color: rgba(255, 255, 255, 0);
}

#mainBottom {
	width: 100%;
	height: 200px;
}

#listArea td {
	padding-top:7px;
	padding-bottom:7px;
}

#writeBtn {
	background:tomato;
	border:none;
}

#tableTop {
	font-weight:bold;
}

#container button {
	background:tomato;
	border:none;
	color:white;
	 border-radius:12px;
}
</style>
</head>
<body>
	<div id="back">
		<%@ include file="../../common/menubar.jsp"%>
	</div>
	<div class="outer">
		<div id="botitle">
			<!-- <h2><b>정보게시판</b></h2s><br> -->
		</div>


		<div id="search2" align="right" style="margin-right: 50px">
			<select name="searchArea" id="result"
				style="width: 50px; height: 27px;">
				<option value="이름">이름</option>
				<option value="제목">제목</option>
			</select> <input id="search" type="text" name="search"> <i id="fas"
				class="fas fa-search fa-lg"></i>
		</div>


		<div id='wrap'>
			<table align='center' cellpadding="0" cellspacing="0" border="0">

				<!-- s : 게시판 타이틀 -->
				<tr id="tableTop" style="background: url('/msmg/images/board/table_mid.png')">
					<td width="5"><img src="/msmg/images/board/table_left.png"
						width="7" height="30" /></td>
					<td width="73"><span>번호</span></td>
					<td width="640"><span>제목</span></td>
					<td width="73"><span>작성자</span></td>
					<td width="164"><span>작성일</span></td>
					<td width="58"><span>조회수</span></td>
					<td width="7"><img src="/msmg/images/board/table_right.png"
						width="5" height="30" /></td>
				</tr>

				<% 
				
				for(Board b : list) {%>
				<tr id="listArea">
					<input type="hidden" value="<%=b.getBoardId()%>">
					<td></td>
					<td><%= b.getBoardNo() %></td>
					<td><%= b.getTitle() %></td>
					<td><%= b.getuCode() %></td>
					<td><%= b.getBoardDate() %></td>
					<td><%= b.getbCount() %></td>
					<td></td>
				</tr>
				<tr height='1' bgcolor="#D2D2D2">
					<td colspan="6" width="752"></td>
				</tr>
				<%} %>
			</table>


			<% if(loginUser != null) {%>
			<div id='btnlist' align="right" style="margin-top:10px;">
				<button id="writeBtn"type="button" class="btn btn-success"
					onclick='location.href = "<%=request.getContextPath()%>/selectWrite.bo"'>글작성</button>
					
				<!--백업 <button id="writeBtn"type="button" class="btn btn-success"
					onclick='location.href = "/msmg/views/board/information/informationWrite.jsp"'>글작성</button> -->
			</div>
			<%} %>
			
			
			<br><br>
			<div id="container">
				<button onclick="location.href='<%=request.getContextPath()%>/selectList.bo?currentPage=1'"><<</button>
				<% if(currentPage <= 1) {%>
				<button disabled><</button>
				<%} else {%>
				<button onclick="location.href='<%=request.getContextPath()%>/selectList.bo?currentPage=<%=currentPage - 1%>'"><</button>
				<%} %>
				<% for(int p = startPage; p <= endPage; p++) {
					if(p == currentPage) {
				%>
						<button disabled><%= p %></button>
				<% } else { %>
					<button onclick ="location.href='<%=request.getContextPath()%>/selectList.bo?currentPage=<%= p %>'"><%= p %></button>
				<%		   } %>
				<%} %>
				
				<% if(currentPage >= maxPage) {%>
					<button disabled>></button>
				<%}else{ %>
					<button onclick="location.href='<%= request.getContextPath() %>/selectList.bo?/currentPage=<%= currentPage + 1 %>'">></button>
				<%} %>
				<button onclick="location.href='<%=request.getContextPath()%>/selectList.bo?currentPage=<%= maxPage %>'">>></button>
			</div>
		</div>
	</div>
	<script>
      
     $(function(){
    	 $("#listArea td").mouseenter(function(){
    		$(this).parent().css({"color":"tomato", "cursor":"pointer"});
    	 }).mouseout(function(){
    		$(this).parent().css({"color":"black"});
    	 }).click(function(){
    		 var num = $(this).parent().children("input").val();
    		 location.href="<%=request.getContextPath()%>/selectOne.bo?num=" + num;
    	 });
      });
   </script>
	<div id="mainBottom">
		<%@include file="../../common/footer.jsp"%>
	</div>
</body>
</html>