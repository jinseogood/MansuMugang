<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.msmg.food.model.vo.*"%>
<%
	ArrayList<MenuList> list = (ArrayList<MenuList>)request.getAttribute("list");
	int count = 0;
%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>메뉴소개</title>
<style>
#back {
	width: 100%;
	height: 400px;
	background-image: url("/msmg/images/common/menu.png");
	margin-bottom: 20px;
}

.outer {
	height: 1300px;
}

#intro {
	border: 1px solid black;
	width: 100px;
	height: 50px;
}

.images {
	width: 94%;
	height: 700px;
	overflow: scroll;
	overflow-x: hidden;
	text-align: center;
	float: right;
}

.image {
	background: lightgray;
	width: 21%;
	height: 30%;
	margin: 20px;
	display: inline-block;
}

#btn {
	padding-top: 20px;
}

#menupan {
	height: 100px;
}

#mainBottom {
	width: 100%;
	height: 200px;
}

.topMenu {
	display: inline-block;
	width: 60%;
	height: 90%;
	border: 1px solid lightgray;
	border-radius: 3px;
	margin-left: 50px;
	margin-right: 50px;
	position: relative;
}

.topMenu:hover {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}

.topMenuImg {
	width: 90%;
	height: 60%;
	margin-left: 10px;
	margin-right: 10px;
	margin-top: 10px;
	/* position:absolute; */
}

.topMenuImg>img {
	width: 100%;
	height: 100%;
}
table td {
	height: 200px;
	width: 330px;
}
td .info {
	height:70px;
}

td .like {
	text-align: right;
	font-size:20px;
}
</style>
</head>
<body>
	<div id="back">
		<%@ include file="../common/menubar.jsp"%>
	</div>
	<div class="outer">
		<div class="container">
			<div>
				<div id="menupan" class="panel panel-default">			
					<div class="panel-body">
						<b>뇌증(腦症, encephalopathy)</b>은 뇌의 질병을 의미한다. 뇌병증(腦病症), 뇌병(腦病), 뇌질환(腦疾患) 등으로도 부른다.
					</div>
				</div>
			</div>
			<div id="btn" class="btn-group-vertical">
				<button type="button" class="btn btn-primary"
					OnClick="location='<%= request.getContextPath()%>/MenuListG.fo'">고혈압</button>
				<button type="button" class="btn btn-primary"
					OnClick="location='<%= request.getContextPath()%>/MenuListD.fo'">당뇨병</button>
				<button type="button" class="btn btn-primary"
					OnClick="location='<%= request.getContextPath()%>/MenuListH.fo'">뇌질환</button>
			</div>
			<div class="images">
				<table align="center" text-align="center">
					<% for(int j = 0 ; j <= list.size()/3 ; j++){ %>
						
					<tr>
						<% for(int i = count ; i < list.size() ; ){ %>
						<td align="center">
							<div id="g1" class="topMenu">
								<div id="g1-img" class="topMenuImg">
									<img
										src="<%= request.getContextPath() %>/images/food/<%= list.get(i).getImg_name() %>">
									<div class="info"><%=list.get(i).getMenu_info()%></div>
									<div class="like" text-align="right">♡♥</div>
								</div>
							</div>
						</td>
						<% 
										i++;
										count = i;
										if(count%3 == 0){
											break;
											
										}
									%>
						<% } %>
					</tr>
					<% } %>
				</table>
			</div>
		</div>
	</div>
	<div id="mainBottom">
		<%@include file="../common/footer.jsp"%>
	</div>
</body>
</html>