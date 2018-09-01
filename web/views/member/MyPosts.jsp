<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import = "java.util.*, com.msmg.mypage.model.vo.*"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	   
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

	#sidebar { 
  width: 190px; 
  position: fixed; 
  margin-left: 0%;
  /* margin-top: 10%;  */
  background: #ffb1a3;
  border-radius:10px;
}

#sidebar a{
	text-decoration:none;
}
.ui-widget-header { padding: 0.3em; }
</style>
</head>
<body>
<!-- 게시판 리스트 -->
<div id = "jjff">
	<%@ include file = "../common/menubar.jsp" %>
</div>

<div id="sidebar">
        <ul>
          <li><a onclick="location.href='<%=request.getContextPath()%>/selectAllergy.me'">회원정보 수정</a></li>
  		  <li><a onclick="test();">장바구니</a></li>
  		  <li><a href="<%= request.getContextPath() %>/selectBuyAll.mp">주문내역</a></li>
  		  <li><a href="<%= request.getContextPath() %>/mypageQnaList.mp">1:1 문의내역</a></li>
  		  <li><a href="<%= request.getContextPath() %>/selectBoard.mp">내가 쓴 글</a></li>
  		  <li><a href="/msmg/views/member/Withdrawal.jsp">회원 탈퇴</a></li>
      	</ul>
	</div>

	<%if(loginUser != null){ %>
	<div id = 'wrap'>
	<table align='center' cellpadding="0" cellspacing="0" border="0">

		<!-- s : 게시판 타이틀 -->
		<tr
			style="background: url('/msmg/images/board/table_mid2.png') /* #E8E8E8 */ repeat-x; height : 30px;">
			<td width="5"><img src="/msmg/images/board/table_left1.png" width="5" style = "background : no-repeat;"
				height="30" /></td>
			<td width="150"><span>게시판구분</span></td>
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
				for(Board b : list){
		%>
		<tr id='content'>
			<td></td>
			<% if(b.getRef_bno() == b.getBoard_id()){ %>
			<td><%= b.getBoard_no() %></td>
			<td style = "text-align : left;"><a href = "<%= request.getContextPath() %>/boardList.mp?board_id=<%=b.getBoard_id() %>"><%= b.getTitle()  %></a></td>
			<%}else{ %>
			<td></td>
			<td style = "text-align : left;"><a href = "<%= request.getContextPath() %>/boardList.mp?board_id=<%=b.getBoard_id() %>">
			<img src = '/msmg/images/board/enter.png'><%= b.getTitle() %></a></td>
			<%} %>
			<td><%= b.getU_code() %></td>
			<td><%= b.getBoard_date() %></td>
			<td><%= b.getB_count() %></td>
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
	<%-- <div id = 'btnlist' align = "right">
	<button id = 'insert' class="btn btn-primary btn-sm" onclick = 'location.href = "<%= request.getContextPath() %>/insertQna.Qna"'>작성</button>
	</div> --%>
	<div id="container">
		<button onclick = 'location.href = "<%=request.getContextPath()%>/boardList.mp?currentPage=1"'><<</button>
			<% if(currentPage <= 1){ %>
				<button disabled><</button>
			<%}else{%>
				<button onclick = "location.href = '<%=request.getContextPath()%>/boardList.mp?currentPage=<%=currentPage - 1%>'"><</button>
			<%} %>
			<%for(int p = startPage; p <= endPage; p++){
				if(p == currentPage){%>
					<button disabled><%= p %></button>				
			<%}else{%>
					<button onclick = "location.href ='<%=request.getContextPath() %>/boardList.mp?currentPage=<%=p %>'"><%=p %></button>
			<%}} %>
			
			<% if(currentPage >= maxPage){ %>
				<button disabled>></button> 
			<%}else{ %>
				<button onclick = "location.href = '<%=request.getContextPath() %>/boardList.mp?currentPage=<%=currentPage + 1 %>'">></button>
			<%} %>
				<button onclick = "location.href = '<%=request.getContextPath() %>/boardList.mp?currentPage=<%=maxPage %>'">>></button>
	</div>
	
</div>
<%}else{
	//request.setAttribute("msg", "잘못된 경로");
	//request.getRequestDispatcher("../../common/errorPage.jsp").forward(request, response);
	response.sendRedirect("../../member/LoginForm.jsp");
}%>
<div id="mainBottom">
	<script>
		function test(){
			var a = "<%= loginUser.getU_code()%>";
			location.href = "<%= request.getContextPath() %>/selectCart.fo?ucode="+a;
		}
	
	
	</script>
<%@include file = "../common/footer.jsp" %>
</div>
</body>
</html>