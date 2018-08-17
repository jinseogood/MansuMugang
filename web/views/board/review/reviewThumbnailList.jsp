<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
.outer {
	width: 1000px;
	height: 1300px;
	margin-left: auto;
	margin-right: auto;
	padding-left: 20px;
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

.thumb-list {
	display:inline-block;
}

.thumb-list:hover {
	cursor:pointer;
	opacity:0.5;
}

#mainBottom {
	width:100%;
	height:200px;
}

</style>
</head>
<body>
	<div id="back">
		<%@ include file="../../common/menubar.jsp"%>
	</div>
	<div class="outer">
		<br>
		<!-- <h2 aling="left">후기 게시판</h2> -->

		<div id="search2" align="right" style="margin-right: 50px; margin-bottom:40px;">
			<select name="searchArea" id="result"
				style="width: 50px; height: 27px;">
				<option value="이름">이름</option>
				<option value="제목">제목</option>
			</select>
			<input id="search" type="text" name="search">
			<i id="fas" class="fas fa-search fa-lg"></i>
		</div>
		
		
		
		<div class="thumbnailArea">
			<%-- <% for(int i = 0; i < list.size(); i++) {
			HashMap<String, Object> hmap = list.get(i);
	%> --%>
			<div class="thumb-list" align="center">
				<div>
					<input type="hidden" <%-- value="<%=hmap.get("bid")%>" --%>>
					<img
						src="/msmg/thumbnail_uploadFiles/b.png<%-- <%=hmap.get("changeName")%> --%>"
						width="200px" height="150px">
				</div>
				<p>
					No.
					<%-- <%=hmap.get("bno") %> <%= hmap.get("btitle") %> --%>
					<br> 조회수 :
					<%-- <%= hmap.get("bcount") %> --%>
				</p>
			</div>
			<script>
				$(function(){
					$(".thmb-list").click(function(){
						var num = $(this).children().children().eq(0).val();
						location.href="<%=request.getContextPath()%>/selectOne.tn?num=" + num;
					});	
				});
				
			</script>
			
		</div>
	</div>
	<div id="mainBottom">
	<%@include file="../../common/footer.jsp"%>
	</div>
</body>
</html>