<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
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

.pagination>.active>a, 
.pagination>.active>a:focus, 
.pagination>.active>a:hover,
.pagination>.active>span, 
.pagination>.active>span:focus, 
.pagination>.active>span:hover
 {background-color: #D8D8D8; color:red;}
 
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
</style>
</head>
<body>
<!-- 게시판 리스트 -->
<div id = "jjff">
	<%@ include file = "../../common/menubar.jsp" %>
</div>
	<div id = "botitle">
		<!-- <label id = "offi">공지사항</label><br> -->
		<label style = "margin-left : 18%; font-size:17px;"><p>게시된 의견은 회신되지 않으며, 게시판의 효과적인 운영을 위하여 비방 · 욕설, 음란한 표현, 상업적인 광고, 동일한 내용 반복게시, 특정인의
		개인정보 유출 등 <br>홈페이지의 정상적인 운영을 저해하는 내용은 게시자에게 통보하지 않고 삭제될 수 있음을 알려드립니다.<br><br>

		타인의 저작물(신문기사, 사진, 동영상 등)을 관리자의 허락 없이 무단으로 복제하여 올리는 것은 저작권 침해에 해당합니다.</p></label>
	</div>
	<div id = 'wrap'>
	<table align='center' cellpadding="0" cellspacing="0" border="0">

		<!-- s : 게시판 타이틀 -->
		<tr
			style="background: url('/msmg/images/board/table_mid.png') /* #E8E8E8 */ repeat-x;">
			<td width="5"><img src="/msmg/images/board/table_left.png" width="5"
				height="30" /></td>
			<td width="73"><span>번호</span></td>
			<td width="630"><span>제목</span></td>
			<td width="73"><span>작성자</span></td>
			<td width="164"><span>작성일</span></td>
			<td width="58"><span>조회수</span></td>
			<td width="7"><img src="/msmg/images/board/table_right.png" width="5"
				height="30" /></td>
		</tr>
		<!-- e : 게시판 타이틀 -->
		<!-- s: 게시글 테스트 영역 -->
		
		<tr id='content'>
			<td></td>
			<td>1</td>
			<td><a href="/msmg/views/board/notice/readBoard.jsp">테스트입니다.</a></td>
			<td>테스트</td>
			<td>2018.08.03</td>
			<td>0</td>
			<td></td>
		</tr>
		<tr height='1' bgcolor="#D2D2D2">
			<td colspan="6" width="752"></td>
		</tr>
		<tr id='content'>
			<td colspan='7'>등록된 글이 없습니다.</td>
		</tr>
		<!-- e: 게시글 테스트 영역 끝 -->

		<!-- 게시판 끝 -->
		<tr bgcolor="#82B5DF" style="height: 1px;">
			<td colspan="6"></td>
		</tr>
		<!-- 게시판 끝 -->
	</table>
	<div id = 'btnlist' align = "right">
	<button id = 'insert' class="btn btn-primary btn-sm" onclick = 'location.href = "/msmg/views/board/notice/boradWrite.jsp"'>작성</button>
	</div>
	<div id="container">
		<ul class="pagination">
			<li><a href="#">이전</a></li>
			<li ><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li ><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">다음</a></li>
		</ul>
	</div>
	
	<%-- <div class = 'pageArea' align = 'center'>
			
			<button onclick = 'location.href = "<%=request.getContextPath()%>/selectList.no?currentPage=1"'>처음으로</button>
			<% if(currentPage <= 1){ %>
				<button disabled><</button>
			<%}else{%>
				<button onclick = "location.href = '<%=request.getContextPath()%>/selectList.no?currentPage=<%=currentPage - 1%>'">이전</button>
			<%} %>
			<%for(int p = startPage; p <= endPage; p++){
				if(p == currentPage){%>
					<button disabled><%= p %></button>				
			<%}else{%>
					<button onclick = "location.href ='<%=request.getContextPath() %>/selectList.no?currentPage=<%=p %>'"><%=p %></button>
			<%}} %>
			
			<% if(currentPage >= maxPage){ %>
				<button disabled>></button>
			<%}else{ %>
				<button onclick = "location.href = '<%=request.getContextPath() %>/selectList.no?currentPage=<%=currentPage + 1 %>'">다음</button>
			<%} %>
				<button onclick = "location.href = '<%=request.getContextPath() %>/selectList.no?currentPage=<%=maxPage %>'">끝으로</button>
		</div>
	</div> --%>
	<script>
		$(function(){
			$("#container ul li").click(function(event){
				$("#container ul li").removeClass("active");
				$(this).addClass("active");
			});
		})
	</script>
</div>
<div id="mainBottom">
<%@include file = "../../common/footer.jsp" %>
</div>
</body>
</html>