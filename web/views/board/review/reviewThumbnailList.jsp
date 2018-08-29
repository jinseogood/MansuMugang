<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.msmg.board.information.model.vo.*"%>
<% ArrayList<HashMap<String, Object>> list
	= (ArrayList<HashMap<String, Object>>)request.getAttribute("list");
	
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
<meta charset="UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>썸네일 리스트</title>
<style>

.outer {
	width: 1000px;
	height: 1300px;
	margin-left: auto;
	margin-right: auto;
}

#back {
	width: 100%;
	height:400px;
	background-image:url("/msmg/images/common/review.png");
	margin-bottom: 20px;
}

#search {
	width: 150px;
	height:27px;
	margin-top:10px;
}

#fas {
	 background-color: rgba( 255, 255, 255, 0 );
}

.thumbnailArea {
	width:1000px;
	height:550px;
 	margin-left:auto;
	margin-right:auto;
}

.thumb-list {
	width:220px;
	border:1px solid white;
	display:inline-block;
	margin:10px;
	align:center;
}

.thumb-list:hover {
	cursor:pointer;
	opacity:0.5;
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
}

</style>
</head>
<body>
	<div id="back">
		<%@ include file="../../common/menubar.jsp"%>
	</div>
	<div class="outer">
		<br>

		<div class="thumbnailArea">
			<%
			for(int i = 0; i < list.size(); i++) {
				HashMap<String, Object> hmap = list.get(i);
			%>
			<div class="thumb-list" align="Center">
				<div>
				<input id="bno" type="hidden" value="<%= hmap.get("boardNo")%>">
					<img
						src="/msmg/thumbnail_uploadFiles/<%=hmap.get("editName")%>"
						width="220px" height="200px">
				</div>
				<p><b><%= hmap.get("title") %></b><br>
				     조회수 : <%= hmap.get("bcount") %>
				</p>
			</div>
			<%} %>
		</div>
		<br><br>
		<div id="container" align="center">
				<button onclick="location.href='<%=request.getContextPath()%>/selectList.rev?currentPage=1'"><<</button>
				<% if(currentPage <= 1) {%>
				<button disabled><</button>
				<%} else {%>
				<button onclick="location.href='<%=request.getContextPath()%>/selectList.rev?currentPage=<%=currentPage - 1%>'"><</button>
				<%} %>
				<% for(int p = startPage; p <= endPage; p++) {
					if(p == currentPage) {
				%>
						<button disabled><%= p %></button>
				<% } else { %>
					<button onclick ="location.href='<%=request.getContextPath()%>/selectList.rev?currentPage=<%= p %>'"><%= p %></button>
				<%		   } %>
				<%} %>
				
				<% if(currentPage >= maxPage) {%>
					<button disabled>></button>
				<%}else{ %>
					<button onclick="location.href='<%= request.getContextPath() %>/selectList.rev?/currentPage=<%= currentPage + 1 %>'">></button>
				<%} %>
				<button onclick="location.href='<%=request.getContextPath()%>/selectList.rev?currentPage=<%= maxPage %>'">>></button>
			</div>
			<script>
					$(".thumb-list").click(function(){
						var num = $("#bno").val();
						
						console.log(num);
						
						location.href="<%=request.getContextPath()%>/selectOne.rev?num=" + num;
					});	
				
			</script>
		<button onclick="location.href='/msmg/views/board/review/reviewThumbnailInsertForm.jsp'">작성하기</button>
	</div>
	<div id="mainBottom">
	<%@include file="../../common/footer.jsp"%>
	</div>
</body>
</html>