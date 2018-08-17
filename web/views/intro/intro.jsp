<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
body {
	margin:0px;
}
#back {
	width:100%;
	height:400px;
	background-image:url("/msmg/images/common/intro.png");
}

#mainBottom {
	width:100%;
	height:200px;
}

#main {
	height:1300px;
}
</style>
</head>
<body>
	<div id="back">
	<%@ include file="../common/menubar.jsp"%>
</div>
<div id="main" align="center">
	<img src="/msmg/images/intro/intro2.png">
</div>




<div id="mainBottom">
<%@include file = "../common/footer.jsp" %>
</div>
</body>
</html>