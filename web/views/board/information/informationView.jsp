<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.msmg.board.information.model.vo.*" %>
<% 
	ArrayList<Reply> list = (ArrayList<Reply>)request.getAttribute("replylist");
	ArrayList<Reply> list2 = (ArrayList<Reply>)request.getAttribute("r");
	
	Board b = (Board)request.getAttribute("b");
   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보게시판 상세보기</title>
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
	width:100%;
	border-bottom: 1px solid black;
}

#content {
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



#replyAddTable tr td {
	border-top:1px solid #e83f26;
	border-bottom:1px solid #e83f26;
}

#replyAddTable td {
	height:30px;
	border-left:1px solid #e83f26;
	border-right:1px solid #e83f26;
}

#replyContent {
	width:600px;
	height:50px;
}

#date {
	font-size:12px;
}

#deleteBtn {
	background:tomato;
	border:none;
}

#updateBtn {
	background:tomato;
	border:none;
}

#viewBtn {
	width:150px;
	float:right;	
}

#boardList {
	background:tomato;
	border:none;
}

input {
	display:block-line;
	border:none;
}

input[type=text]{
	width:100px;
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
				<th style="color: #555; text-align: center;">
				<input style="border:none; text-align:center" id="title" value="<%=b.getTitle()%>" readonly></th>
			</tr>
		</table>
		<div id="detail">
			<div id="date-writer-hit2">
				<span id="date-writer-hit">작성자 : <input type = "text" name="title" value="<%=b.getuCode()%>" readonly></span>
				<span>날짜 : <input type = "text" value="<%=b.getBoardDate()%>" readonly></span>
				<span>조회수 : <input type = "text" value="<%=b.getbCount()%>" readonly></span>
				<input type="hidden" id = "date" value="<%=b.getBoardDate()%>">
			</div>
			<div id="content" readonly><%= b.getContent() %>
				<input type="hidden" id="content2" value="<%=b.getContent()%>" >
				<input type="hidden" id="bid2" name="bid2" value="<%=b.getBoardId()%>">
			</div>
		
		
	
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
		<table id="replyAddTable">
			<%for(int i=0; i < list2.size(); i++) {%>
				<tr>
				<td width="100px"><%= list2.get(i).getU_code() %>
				                  <br><div id="date"><%= list2.get(i).getRe_date() %></div></td>
				<td width="600px"><%= list2.get(i).getRe_content() %></td>
				<%if(loginUser.getU_name().equals(list2.get(i).getU_code())) {%>
					<td width='100'><a href='#'>수정</a> | <a href='#'>삭제</a></td>
				<%} else {%>
					<td width="100px"></td>
				<%} %>
				</tr>
			<%} %>
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
					$("#replyAddTable").html("");
					for(var i = 0; i < data.length; i++){
						$("#replyAddTable").append("<tr><td width='100px'>" + data[i].u_code , data[i].re_date +"</td><td width='600px'>" + data[i].re_content + "</td>"
								+ "<td width='100'><a href='#'>수정</a>" + " | " + "<a href='#'>삭제</a></td></tr>")
					}
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
		<button id="boardList" class="btn btn-success"
			onclick="location.href='<%=request.getContextPath()%>/selectList.bo'">이전으로</button>
		<%if(loginUser.getU_name().equals(b.getuCode())) {%>
			<div id="viewBtn" align="right">
			<button id="updateBtn" type="button" class="btn btn-success" name="bid"
				onclick="location.href='<%=request.getContextPath()%>/selectInfor.bo?num=<%=b.getBoardId()%>'">수정</button>
			<button id="deleteBtn" type="button" class="btn btn-success">삭제</button>
			</div>
		<%} %>
	</div>
	<script>
	$(function(){
		$("#deleteBtn").click(function(){
			var bid = $("#bid2").val();
			
			$.ajax({
				url:"/msmg/deleteInfor.bo",
				data:{bid:bid},
				type:"post",
				success:function(data){
					location.href = "/msmg/selectList.bo";
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
