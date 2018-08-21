<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.msmg.member.model.vo.*" %>
<% Member loginUser = (Member)session.getAttribute("loginUser"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<title>메뉴바</title>
<style>
	@font-face { font-family: 'GyeonggiBatang'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/GyeonggiBatang.woff') format('woff'); font-weight: normal; font-style: normal; }

	body{
		font-family: 'GyeonggiBatang';
	}
	#info{
		width:80%;
		height:25px;
		margin-left:auto;
		margin-right:auto;
		text-align:right;
		color:black;
	}
	#info > a{
		text-decoration:none;
		color:black;
		font-size:11px;
	}
	#info > a > label:hover{
		cursor:pointer;
	}
	#menubar{
		width:80%;
		height:130px;
		background:white;
		color:black;
		margin-left:auto;
		margin-right:auto;
		display:block;
	}
	#menubarLogo{
		float:left;
		width:30%;
		height:100%;
	}
	#menubarLogo > a > img{
		width:25%;
		height:100%;
	}
	#menuContent{
		width:55%;
		display:inline-block;
	}
	#menuTitle{
		display:table-cell;
		text-align:center;
		vertical-align:middle;
		width:160px;
		height:130px;
	}
	#menuTitle > a{
		text-decoration:none;
		color:black;
		font-weight:bold;
		font-size:25px;
	}
	#menuTitle > a:hover{
		color:#FFBDA3;
	}
	#submenubar{
		display:none;
		width:80%;
		height:100px;
		padding-top:10px;
		margin-left:auto;
		margin-right:auto;
		background-color:rgba(255, 255, 255, 0.9);
	}
	#submenubarLeft{
		float:left;
		width:30%;
		height:100%;
	}
	#submenuContent{
		width:55%;
		display:inline-block;
	}
	#submenuTitle{
		display:table-cell;
		text-align:center;
		vertical-align:middle;
		width:160px;
		height:25px;
		font-size:15px;
	}
	#submenuTitle > a{
		text-decoration:none;
		color:black;
	}
	#submenuTitle > a:hover{
		text-decoration:underline;
		color:darkgray;
	}
	
	#informationB:hover {
		cursor:pointer;
		color:gray;
	}
</style>
</head>
<body>
	<div id="info">
	<% 
		if(loginUser != null && !(loginUser.getU_id().equals("admin"))){ 
	%>
			<label><%= loginUser.getU_name() %>님 만수무강하세요!</label>&nbsp; | &nbsp; <a href = "views/member/EditMyInformation.jsp"><label>마이페이지</label></a> | <a onclick = "logout();"><label>로그아웃</label></a>
	<% 
		}else if(loginUser != null && loginUser.getU_id().equals("admin")){
	%>
			<script>
				$(function(){
					location.href="/msmg/views/admin/adminPage.jsp";
				});
			</script>
	<%
		}else{
	%>
		<a href="/msmg/views/member/LoginForm.jsp"><label>로그인</label></a> | <a href="/msmg/views/member/MemberJoinForm.jsp"><label>회원가입</label></a>
	<%
		}
	%>
	</div>
	<div id="menubar" class = "hidden-xs">
		<div id="menubarLogo" align="center">
			<a href="/msmg/index.jsp"><img src="/msmg/images/common/menubarLogo2.png"></a>
		</div>
		<div id="menuContent">
			<div id="menuTitle"><a href="#">소개</a></div>
			<div id="menuTitle"><a href="#">식단</a></div>
			<div id="menuTitle"><a href="#">커뮤니티</a></div>
			<div id="menuTitle"><a href="#">고객센터</a></div>
		</div>
	</div>
	<div id="submenubar" class = "hidden-xs">
		<div id="submenubarLeft"></div>
		<div id="submenuContent">
			<div id="submenuTitle">
				<a href="/msmg/views/intro/intro.jsp">회사소개</a>
				<br><br><br>
				<a href="/msmg/views/intro/guide.jsp">이용가이드</a>
			</div>
			<div id="submenuTitle">
				<a href="/msmg/views/menu/menuIntro.jsp">메뉴소개</a>
				<br><br><br>
				<a href="/msmg/views/foodPlan/menu_plan.jsp">식단짜기</a>
			</div>
			<div id="submenuTitle">
				<div id="informationB" onclick="location.href='<%=request.getContextPath()%>/selectList.bo'">정보게시판</div>
				<!-- <a href="/msmg/views/board/information/informationBoard.jsp">정보게시판</a> -->
				<br><br>
				<a href="/msmg/views/board/review/reviewThumbnailList.jsp">후기게시판</a>
			</div>
			<div id="submenuTitle">
				<a href = "<%= request.getContextPath() %>/noticeList.bo">공지사항</a>
				<br><br><br>
				<a href="/msmg/views/board/notice/notice.jsp">Q&A</a>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function(){
		    $("#menuContent").hover(function(){
		        $("#submenubar").slideDown("slow");
		    });
		    $("#submenubar").mouseleave(function(){
		    	$("#submenubar").slideUp("slow");
		    });
		    
		});
		
		function logout(){
			var check = window.confirm("로그아웃 하시겠습니까?");
			
			if(check == true){
				location.href = "<%= request.getContextPath() %>/logout.me"
			}
		}
	</script>
</body>
</html>