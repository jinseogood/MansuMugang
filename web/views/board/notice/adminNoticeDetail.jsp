<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import = "com.msmg.board.notice.model.vo.*, java.util.*"%>
<%
	Notice no = (Notice)request.getAttribute("no");
	Notice preNo = (Notice)request.getAttribute("preNo");
	Notice nextNo = (Notice)request.getAttribute("nextNo");
	 ArrayList<Attachment> list = (ArrayList<Attachment>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글읽기</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
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
	float: right;
	margin-bottom: 4px;
}

#date-writer-hit2 {
	display: inline-block;
	margin: 0;
	padding: 0;
	font-size: 12px;
	color: #555;
	margin-top: 2px;
	margin-bottom: 10px;
	width: 1000px;
	border-bottom: 1px solid #ff6347;
}

div[id=date-writer-hit2] {
	border-bottom: 1px solid #ff6347;
}

#article-content {
	font-size: 0.9em;
	color: #333;
	min-height: 400px;
	border-bottom: 1px solid #ff6347;
}

.bbs-table {
	width: 100%;
	margin: 20px 0 0 0;
	padding: 10px 0 10px 0;
}

.bbs-table th {
	color: #92B91C;
	border-top: 1px solid #ff6347;
	border-bottom: 1px solid #ff6347;
	padding-top: 8px;
	padding-bottom: 8px;
	font-size: 1.3em;
}

#whip {
	width: 1000px;
	margin-top: 50px;
}

#whip tr {
	border-bottom: 1px solid #ff6347;
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

#jjff {
	width: 100%;
	height: 400px;
	background-image: url("/msmg/images/common/notice.png");
	margin-bottom: 10px;
}

#main {
	width: 1000px;
	height: 800px;
	margin-left:auto;
	margin-right:auto;
}

#mainBottom {
	height:200px;
	width:100%;
}
</style>
<script>
	function alertDelete(){
		var check = window.confirm("글을 삭제하시겠습니까?");
		console.log("아아아");
		if(check == true){
			window.location = '<%=request.getContextPath() %>/deleteNotice.no?bno=<%= no.getBoard_no()%>';
		}
	}
</script>
</head>
<body>
	 
	<div id="main">
		<!-- 게시판 읽기 -->
		<div>
			<table class="bbs-table">
				<tr>
					<th style=" color: #555; text-align: center;"><%= no.getTitle() %></th>
				</tr>
			</table>
			<div id="detail">
				<div id="date-writer-hit2">
					<span>작성자 &nbsp; l &nbsp; <%= no.getU_name() %></span>
					<span id="date-writer-hit"> <%= no.getBoard_date() %> &nbsp;&nbsp;&nbsp; <b>l</b>&nbsp;&nbsp;&nbsp; hit <%= no.getB_count() %></span>
				</div>
				<div id="article-content"><%= no.getContent() %></div>
				<div id ='attachArea'>
				<%if(list != null){ %>
				<dl>
					<dt>첨부파일</dt>
					<%for(Attachment at : list){ %>
						<dd><a href = "downloadFile.no?edit_name=<%=at.getChangeName() %>"><%= at.getOriginName() %></a></dd>
					<%} %>
				</dl>
				<%} %>
				</div>
			</div>
		</div>
		<div id='whiptable'>
			<table id='whip'>
			<% if(nextNo != null){ %>
				<tr style="border-top: 1px solid #ff6347;">
					<td width="100"><span class="glyphicon glyphicon-chevron-up"></span>
						다음글</td>
					<td align="center" width='700'><a href="<%= request.getContextPath()%>/noticeDetail.no?board_no=<%=nextNo.getBoard_no()%>"><%= nextNo.getTitle() %></a></td>
					<td width="100"><%= nextNo.getBoard_date() %></td>
				</tr>
			<%} %>
			<%if(preNo != null){ %>
				<tr style="border-top: 1px solid #ff6347;">
					<td width="100"><span class="glyphicon glyphicon-chevron-down"></span>
						이전글</td>
					<td align="center"><a href="<%= request.getContextPath()%>/noticeDetail.no?board_no=<%=preNo.getBoard_no()%>"><%= preNo.getTitle() %></a></td>
					<td><%= preNo.getBoard_date() %></td>
				</tr>
			<%} %>
			
			</table>
		</div>
		<br>


		<div class="btnlist">
			<button class="btn btn-primary befo btn-sm"
				onclick = 'history.go(-1)'>이전으로</button>
			<button class="btn btn-primary befo btn-sm"
				onclick = "location.href = '<%=request.getContextPath() %>/selectOneEdit.no?num=<%= no.getBoard_no() %>'">수정하기</button>
			<button class="btn btn-primary befo btn-sm"
				onclick = "alertDelete();">삭제하기</button>
		</div>

	</div>
	 
</body>
</html>

