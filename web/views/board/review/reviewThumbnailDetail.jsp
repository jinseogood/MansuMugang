<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.msmg.board.review.model.vo.*, java.util.*
	, com.msmg.board.information.model.vo.*"%>
<%
	Board b = (Board)request.getAttribute("b");
	ArrayList<BoardFile> fileList = (ArrayList<BoardFile>)request.getAttribute("fileList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>썸네일 상세보기</title>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>

#back {
	width:100%;
	height:400px;
	background-image:url("/msmg/images/common/review.png");
	margin-bottom:20px;
}

#outer {
	width: 800px;
	height:1300px;
	margin:0 auto;
}

#detail {
	display: block;
}

a {
	text-decoration: none;
	color: black;
}

#whiptable #whip tr td a:hover {
	text-decoration: none;
	color: red;
}

#date-writer-hit {
	display: inline-block;
	margin: 0;
	padding: 0;
	font-size: 12px;
	color: #555;
	text-align: right;
	float: left;
	margin-bottom: 4px;
}

#date-writer-hit2 {
	display: inline-block;
	margin: 0;
	padding: 0;
	font-size: 12px;
	color: #555;
	text-align: right;
	margin-top: 2px;
	margin-bottom: 10px;
}

div[id=date-writer-hit2] {
	width:100%;
	border-bottom: 1px solid black;
}

#article-content {
	font-size: 0.9em;
	color: #333;
	min-height: 400px;
	border-bottom: 1px solid tomato;
}

.bbs-table {
	width: 100%;
	margin: 20px 0 0 0;
	padding: 10px 0 10px 0;
}

.bbs-table th {
	color: #e83f26;
	border-top: 1px solid tomato;
	border-bottom: 1px solid tomato;
	padding-top: 8px;
	padding-bottom: 8px;
	font-size: 1.3em;
}

#whip {
	width: 800px;
	margin-top: 50px;
}

#whip tr {
	border-bottom: 1px solid tomato;
	height: 35px;
	font-size: 14px;
}

.btnlist .ddl {
	float: right;
}

.btnlist .btn {
	margin-right: 4px;
	margin-left: 4px;
}

#article-content td{
	padding:10px;
}

#mainBottom {
	width:100%;
	height:200px;
}

.detail {
	margin-left:auto;
	margin-right:auto;
}

.detailImg {
	height:200px;
}

#comment_content {
	width:600px;
	height:50px;
}

#AddBtn:hover {
	cursor:pointer;
}

#viewBtn {
	float:right;
	width:200px;
}

.btn {
	background:tomato;
	border:none;
}

.btn:hover {
	background:tomato;
}


</style>
</head>
<body>
<div id="back">
	<%@ include file="../../common/menubar.jsp"%>
</div>
	<div id="outer">
		<table class="bbs-table">
			<tr>
				<th style="text-align: left; color: #555; text-align: center;"><%= b.getTitle() %></th>
			</tr>
		</table>
		<div id="detail">
			<div id="date-writer-hit2">
				<span>  &nbsp;&nbsp;&nbsp; <%= b.getBoardDate() %>&nbsp;&nbsp;&nbsp;&nbsp;
					조회수 : <%= b.getbCount() %>
				</span> <span id="date-writer-hit">작성자 : <%=b.getuCode() %></span>
			</div>
			<input type="hidden" id="bid2" name="bid2" value="<%=b.getBoardId()%>">
			<div id="article-content" align="center">
				<table>
					<tr>
					</tr>
					<table class="detail">
					<%for (int i = 0; i < fileList.size(); i++) {%>
					<%	  BoardFile detail = fileList.get(i);    %>
						<tr>
							<td>
								<div class="detailImgArea">
								<img id="detailImg1" class="detailImg" src="<%= request.getContextPath()%>/thumbnail_uploadFiles/<%=detail.getEdit_name()%>">
								</div>
							</td>
						</tr> 
					<%} %>
					
					
					</table>
					<tr>
						<td>
							<p id="contentArea" style="height:30px" align="center">
								<%=b.getContent() %>
							</p>
						</td>
					</tr>
				</table>
			</div>
	

	</div>
	<div id='whiptable'>
		<table id='whip'>
			<tr style="border-top: 1px solid #e83f26;">
				<td width="100"><span class="glyphicon glyphicon-chevron-up"></span>
					이전글</td>
				<td align="center" width='700'><a href="#">이전글 입니다</a></td>
				<td width="100">2018-08-07</td>
			</tr>
			<tr>
				<td width="100"><span class="glyphicon glyphicon-chevron-down"></span>
					다음글</td>
				<td align="center"><a href="#">다음글 입니다</a></td>
				<td>2018-08-07</td>
			</tr>

		</table>
	</div>
	<br>


	<div class="btnlist" >
		<button class="btn btn-success"
			onclick="location.href='<%=request.getContextPath()%>/selectList.rev'" value="이전으로">이전으로</button>
		<%if(loginUser.getU_name().equals(b.getuCode())) {%>
			<div id="viewBtn" align="right">
			<button id="updateBtn" type="button" class="btn btn-success" name="bid"
				onclick="location.href='<%=request.getContextPath()%>/update.rev?num=<%=b.getBoardId()%>'">수정</button>
			<button id="deleteBtn" type="button" class="btn btn-success">삭제</button>
			</div>
		<%} %>
	</div>
	<script>
	$(function(){
		$("#deleteBtn").click(function(){
			var bid = $("#bid2").val();
			
			$.ajax({
				url:"/msmg/delete.rev",
				data:{bid:bid},
				type:"post",
				success:function(data){
					alert("게시글을 삭제하시겠습니까?");
					location.href = "/msmg/selectList.rev";
				},
				error:function(data){
					console.log("실패");
				}
			});
		});
	});
	</script>
</div>

<div id="mainBottom">
<%@include file = "../../common/footer.jsp" %>
</div>

</body>
</html>
