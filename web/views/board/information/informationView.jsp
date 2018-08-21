<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.msmg.board.information.model.vo.*" %>
<% 
	ArrayList<Reply> list = (ArrayList<Reply>)request.getAttribute("replylist");
	
	Board b = (Board)request.getAttribute("b");
   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 만들기</title>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
/* body {
	background:pink;
} */
#back {
	width:100%;
	height:400px;
	background-image:url("/msmg/images/common/information.png");
	margin-bottom:20px;
}

#outer {
	height: 1300px;
	width:800px;
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
	border-bottom: 1px solid black;
}

#article-content {
	font-size: 0.9em;
	color: #333;
	min-height: 400px;
	border-bottom: 1px solid #e83f26;
}

.bbs-table {
	width: 100%;
	margin: 20px 0 0 0;
	padding: 10px 0 10px 0;
}

.bbs-table th {
	color: #e83f26;
	border-top: 1px solid #e83f26;
	border-bottom: 1px solid #e83f26;
	padding-top: 8px;
	padding-bottom: 8px;
	font-size: 1.3em;
}

#whip {
	width: 800px;
	margin-top: 50px;
}

#whip tr {
	border-bottom: 1px solid #e83f26;
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

#mainBottom{
		width:100%;
		height:200px;
}

#replyAddBtn{
	cursor:pointer;
}

#replyAddArea table{
	border-top:1px solid #e83f26;
	border-bottom:1px solid #e83f26;
}

#replyComment {
	border-left:1px solid #e83f26;
	border-right:1px solid #e83f26;
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
				<th style="text-align: left; color: #555; text-align: center;"><%=b.getTitle() %></th>
			</tr>
		</table>
		<div id="detail">
			<div id="date-writer-hit2">
				<span id="date-writer-hit">작성자 : <%=b.getuCode() %></span>
				&nbsp;&nbsp;
				<span>날짜 : <%=b.getBoardDate() %> &nbsp;&nbsp;&nbsp;</span>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span>조회수 : <%= b.getbCount() %></span>
			</div>
				
			<div id="article-content"><%= b.getContent() %></div>
		
		
	
	<div id="replyArea" style="margin-top:10px; text-align:center">
	<div id="replayWriteArea">
		<table border="1" bordercolor="#e83f26" height="50px">
			<tr bgcolor="#ff9788">
			<form id="writeCommentForm">
				<td width="100">
				</td>
				<td width="600">
						<input type="text" id="replyContent" name = "replyContent">
				</td>
				<td width="100">
						<div id="replyAddBtn">댓글등록</div>
						
				</td>
			</form>
			</tr>
		</table>
	</div>
	
	<br>
	<div id="replyAddArea">
	<table height="35px" id="replyAddTable">
				<tr>
				<td width="100">
				</td>
				<td id="replyComment" width="600">
				</td>
				<td width="100">
						<a href="#">답변</a>
							<a href="#">수정</a>
							<a href="#">삭제</a>
				</td>
				</tr>
		</table>
		</div>
	</div>
	</div>
	
	<script>
	$(function(){
		$("#replyAddBtn").click(function(){
			var writter = <%= loginUser.getU_code() %>
			var bid = <%= b.getBoardId()%>
			var content = $("#replyContent").val();
			
			console.log(writter)
			console.log(bid)
			console.log(content)
			
			$.ajax({
				url:"/msmg/insertReply.bo",
				data:{writter:writter,
					  content:content,
					  bid:bid},
				type:"post",
				success:function(data){
					console.log(data);
					$("#replyAddTable").append("<tr><td>"+data[0].u_code+"</td>")
					
				}, 
				error:function(data){
					console.log("실패");
				}
			});
		});
	});
	</script>


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


	<div class="btnlist">
		<button class="btn btn-default befo btn-sm"
			onclick="location.href='<%=request.getContextPath()%>/selectList.bo'">이전으로</button>
		<%if(loginUser.getU_name().equals(b.getuCode())) {%>
		<button class="btn btn-default ddl btn-sm">삭제</button>
		<button class="btn btn-default ddl btn-sm" onclick="location.href='../information/informationModify.jsp'">수정</button>
		<%} %>
		
	</div>
</div>

<div id="mainBottom">
<%@include file = "../../common/footer.jsp" %>
</div>


</body>
</html>
