<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이용가이드</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
body {
	margin:0px;
}

#back {
	width:100%;
	height:400px;
	background-image:url("/msmg/images/common/guide.png");
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
	<img src="/msmg/images/intro/guide2.png">
</div>

<div id="mainBottom">
<%@include file = "../common/footer.jsp" %>
</div>
</body>
</html>