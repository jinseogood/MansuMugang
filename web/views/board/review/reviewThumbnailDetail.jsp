<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.msmg.board.review.model.vo.*, java.util.*
	, com.msmg.board.information.model.vo.*"%>
<%
	ArrayList<Reply> list = (ArrayList<Reply>)request.getAttribute("replylist");
	ArrayList<Reply> list2 = (ArrayList<Reply>)request.getAttribute("r");

	Board b = (Board)request.getAttribute("b");
	ArrayList<BoardFile> fileList = (ArrayList<BoardFile>)request.getAttribute("fileList");
	
	Board preR = (Board)request.getAttribute("preR");
	Board nextR = (Board)request.getAttribute("nextR");
	
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
	min-height:1300px;
	margin:0 auto;
	margin-bottom:700px;
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

#replyContent {
	width:600px;
	height:50px;
}

#replyAddBtn {
	color:white;
}

#replyAddBtn:hover {
	cursor:pointer;
}

#replyAddTable tr td {
	border-top:1px solid tomato;
	border-bottom:1px solid tomato;
}

#replyAddTable td {
	height:30px;
	border-left:1px solid tomato;
	border-right:1px solid tomato;
}

#date {
	font-size:12px;
}

#content22 {
	color:blue;
}

a:hover {
	cursor:pointer;
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
								<div class="detailImgArea" align="center">
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
	
	<div id="replyArea" style="margin-top:10px; text-align:center">
		<div id="replyWriteArea">
			<table border="1" bordercolor="tomato" height="50px">
				<tr bgcolor="tomato">
					<form id="writeCommentForm">
						<td width="100"></td>
						<td width="600">
							<input type ="text" id="replyContent" name="replyContent">
						</td>
						<td width="100">
							<div id="replyAddBtn">댓글 등록</div>
						</td>
					</form> 
				</tr>
			</table>
		</div>
		<br>
		<div id="replyAddArea">
			<table id="replyAddTable" class="listBox">
				<%for (int i=0; i < list2.size(); i++) {%>
					<tr>
					<td style="display:none;" id="replyNo"><input type="hidden" value="<%=list2.get(i).getReply_no()%>"></td>
					<td width="100"><%= list2.get(i).getU_code() %>
									<br><div id="date"><%= list2.get(i).getRe_date() %></div></td>
					<td width="600" id="content11"><%= list2.get(i).getRe_content() %></td>
					<td width="600px" id="content22" style="display:none;"><input type="text" style="padding-left:10px; width:600px; height:30px; color:blue;" value="<%= list2.get(i).getRe_content() %>"></td>
					<%if(loginUser.getU_name().equals(list2.get(i).getU_code())) {%>
						<td id="update" width="50"><a>수정</a></td>
						<td style="display:none;"id="update2" width='50px'><a>등록</a></td>
						<td id="delete" width="50"><a>삭제</a></td>
					<%} else{%>
						<td width="50px"></td>
						<td width="50px"></td>
					<%} %>
					</tr>
				<%} %>
			</table>
		</div>
		
		<script>
		$(function(){
			$(".listBox #update").click(function(){
				$(this).parent().children("#content11").hide();
				$(this).parent().children("#content22").show();
				$(this).parent().children("#update").hide();
				$(this).parent().children("#update2").show();
			});
			
			$(".listBox #update2").click(function(){
				var num = $(this).parent().children("#replyNo").children("input").val();
				var bid = <%=b.getBoardId()%>;
				var content = $(this).parent().children("#content22").children("input").val();
				
				location.href="<%=request.getContextPath()%>/updateReply.rev?num=" + num + "&bid=" + bid + "&content=" + content;
			})
			
			$(".listBox #delete").click(function(){
				self.window.alert("댓글을 삭제하시겠습니까?");
				var num = $(this).parent().children("#replyNo").children("input").val();
				var bid = <%=b.getBoardId()%>
				
				location.href="<%= request.getContextPath() %>/deleteReply.rev?num=" + num + "&bid=" + bid;
			});
			
		});
		
		
		
		
		
		
		
		
		
		$(function(){
			$("#replyAddBtn").click(function(){
				var writter = <%= loginUser.getU_code()%>
				var bid = <%= b.getBoardId()%>
				var content = $("#replyContent").val();
				
				console.log(writter);
				console.log(bid);
				console.log(content);
				
				$.ajax({
					url:"/msmg/insertReviewReply.rev",
					data:{writter:writter,
						  content:content,
						  bid:bid},
					type:"post",
					success:function(data){
						
						self.window.alert("댓글 등록 완료!");
						
						location.href="<%=request.getContextPath()%>/selectOne.rev?num=" + bid;
						
						
						/* $("#replyAddTable").html("");
						for(var i = 0; i < data.length; i++){
							$("#replyAddTable").append("<tr><td width='100px'>" + data[i].u_code + "<br>" + data[i].re_date +"</td><td width='600px'>" + data[i].re_content + "</td>"
									+ "<td width='100px'><a href='#'>수정</a>" + " | " + "<a href='#'>삭제</a></td></tr>")
						} */
					},
					error:function(data){
						console.log("실패");
					}
				});
			});
		});
		</script>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	<div id='whiptable'>
		<table id='whip'>
		<% if(preR != null) {%>
			<tr style="border-top: 1px solid #e83f26;">
				<td width="100"><span class="glyphicon glyphicon-chevron-up"></span>
					이전글</td>
				<td align="center" width='700'><a href="<%=request.getContextPath()%>/selectOne.rev?num=<%=preR.getBoardId()%>"><%=preR.getTitle() %></a></td>
				<td width="100"><%=preR.getBoardDate()%></td>
			</tr>
			<%} %>
			
		<%if(nextR != null) {%>
			<tr>
				<td width="100"><span class="glyphicon glyphicon-chevron-down"></span>
					다음글</td>
				<td align="center" width="700"><a href="<%=request.getContextPath()%>/selectOne.rev?num=<%=nextR.getBoardId()%>"><%=nextR.getTitle() %></a></td>
				<td width="100"><%=nextR.getBoardDate() %></td>
			</tr>
			<%} %>
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
