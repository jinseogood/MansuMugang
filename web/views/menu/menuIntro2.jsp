<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
/* body {
	background:pink;
} */

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
			<div id="menupan" class="panel panel-default">
				<div class="panel-body">
					<b>당뇨병(糖尿病, diabetes mellitus, DM, diabetes)</b>은 높은 혈당 수치가 오랜 기간 지속되는 대사 질환군을 말한다.혈당이 높을 때의 증상으로는 소변이 잦아지고, 갈증과 배고픔이 심해진다. 이를 치료하지 않으면 다른 합병증을 유발할 수 있다. 급성의 합병증으로는 당뇨병케톤산증, 고혈당성 고삼투성 비케톤성 혼수 등이 포함된다 심각한 장기간 합병증으로는 심혈관질환, 뇌졸중, 만성신부전, 당뇨병성 궤양, 당뇨망막병 등이 포함된다.
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