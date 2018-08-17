<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
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
	width:100%;
	height:400px;
	background-image:url("/msmg/images/common/menu.png");
	margin-bottom:20px;
}

.outer {
	height:1300px;
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
	float:right;
}

.image {
	background: lightgray;
	width: 21%;
	height: 30%;
	margin: 20px;
	display: inline-block;
}

#btn {
	padding-top:20px;
}

#menupan {
	height:100px;
}

#mainBottom {
	width:100%;
	height:200px;
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
			<div id = "menupan" class="panel panel-default">
				<div class="panel-body">
					<b>고혈압(高血壓, hypertension)</b>은 혈압이 정상 범위보다 높은 만성 질환을 말한다. 고혈압은 혈액이
					혈관을 순환하는 데 심장이 더 많은 일을 하게 한다. 혈압은 맥박에서 수축기의 최고 혈압과 이완기의 최저 혈압의 두
					측정치로 요약되는데, 휴식시 정상 혈압은 수축시 100~140mmHg에 이완시 60~90mmHg이고, 혈압이 지속적으로
					140/90mmHg 이상일 때 고혈압이 있다고 말한다.
				</div>
			</div>
		</div>
			<div id="btn" class="btn-group-vertical">
				<button type="button" class="btn btn-primary"
					OnClick="location='menuIntro.jsp'">고혈압</button>
				<button type="button" class="btn btn-primary"
					OnClick="location='menuIntro2.jsp'">당뇨병</button>
				<button type="button" class="btn btn-primary"
					OnClick="location='menuIntro3.jsp'">뇌질환</button>
			</div>
			<div class="images">
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
			</div>
		</div>
	</div>
<div id="mainBottom">
<%@include file = "../common/footer.jsp" %>
</div>
</body>
</html>