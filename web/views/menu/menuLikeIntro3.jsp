<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.msmg.food.model.vo.*, java.util.*"%>
<%
	ArrayList<MenuList> list = (ArrayList<MenuList>) request.getAttribute("list");
	ArrayList<MenuList> MenuList = (ArrayList<MenuList>) request.getAttribute("MenuList");
	int count = 0;
%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">
<link ="stylesheet" type="text/css"
	href="/msmg/web/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
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
	height: 1100px;
}

#intro {
	border: 1px solid black;
	width: 100px;
	height: 50px;
}

.images {
	width: 94%;
	height: 900px;
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
	width: 70%;
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

.topMenuImg>div>img {
	width: 100%;
	height: 100%;
}

table td {
	height: 250px;
	width: 330px;
}
.btn-warning{
	
	width:80px;
	height:40px;
}

td .in {
	margin-top:10px;
	height: 45px;
}

td .like {
	text-align: right;
	/* font-size:20px; */
}

td .n{
	margin-top:5px;
	font-weight:bold;
}

.like>a {
	text-decoration: none;
}

.fa {
	font-size: 25px;
	cursor: pointer;
	user-select: none;
}

.fa:hover {
	color: darkblue;
}

@media ( max-width : 1023px ) {
	.images {
		float: none;
		width: auto;
		height: auto;
	}
	.topMenuImg {
		float: none;
		width: auto
	}
	.topMenu {
		display: block;
		width: auto;
		height: auto;
	}
}

@media ( max-width : 767px ) {
	.topMenu {
		height: auto;
	}
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
				<% if(loginUser != null){ %>
				<button type="button" class="btn btn-warning"
					OnClick="location='<%=request.getContextPath()%>/MenuListG.fo?user='+<%= loginUser.getU_code() %>">고혈압</button>
				<button type="button" class="btn btn-warning"
					OnClick="location='<%=request.getContextPath()%>/MenuListD.fo?user='+<%= loginUser.getU_code() %>">당뇨병</button>
				<button type="button" class="btn btn-warning"
					OnClick="location='<%=request.getContextPath()%>/MenuListH.fo?user='+<%= loginUser.getU_code() %>">뇌질환</button>
				<% }else{ %>
				<button type="button" class="btn btn-warning"
					OnClick="location='<%=request.getContextPath()%>/MenuListG.fo'">고혈압</button>
				<button type="button" class="btn btn-warning"
					OnClick="location='<%=request.getContextPath()%>/MenuListD.fo'">당뇨병</button>
				<button type="button" class="btn btn-warning"
					OnClick="location='<%=request.getContextPath()%>/MenuListH.fo'">뇌질환</button>
				<% } %>

			</div>
			<div class="images">
				
				<table align="center" text-align="center">
					<%
						for (int j = 0; j <= MenuList.size() / 3; j++) {
					%>

					<tr>
						<%
							for (int i = count; i < MenuList.size();) {
						%>

						<%
							if (loginUser != null) {																			
						%>

						<td align="center">
							<div id="g1" class="topMenu">
								<div id="g1-img" class="topMenuImg">
									<div>
										<img
											src="<%=request.getContextPath()%>/images/food/<%=MenuList.get(i).getImg_name()%>">
									</div>
									<div class="n"><%=MenuList.get(i).getMenu_name()%></div>
									<div class="in"><%=MenuList.get(i).getMenu_info()%></div>
									<div class="like" text-align="right">
										<input type="hidden" value="<%=MenuList.get(i).getMenu_code()%>">
									</div>
								</div>
							</div>
						</td>
						<%							
										
							}
						i++;
						count = i;
									if (count % 3 == 0) {
										break;

									}

								
							}
						%>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>
	</div>
	<div align="center">
	<%
					if (loginUser != null) {
				%>
				<button type="button" class="btn btn-warning"
					OnClick="location='<%=request.getContextPath()%>/MenuListHLike.fo?user='+<%=loginUser.getU_code()%>">찜목록</button>
				<button type="button" class="btn btn-warning"
					OnClick="location='<%=request.getContextPath()%>/MenuListH.fo?user='+<%=loginUser.getU_code()%>">전체목록</button>
				<%
					}
				%>
	</div>	
	<br><br>	
	<div id="mainBottom">
		<%@include file="../common/footer.jsp"%>
	</div>

</body>
</html>