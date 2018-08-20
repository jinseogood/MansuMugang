<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg=(String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>재료 추가</title>
<style>
	#content{
		width:300px;
		height:200px;
	}
	#content > label{
		font-weight:bold;
		font-size:24px;
	}
</style>
</head>
<body>
	<form action="<%= request.getContextPath() %>/addMaterial" method="get">
	<div id="content" align="center">
		<label>재료 추가</label>
		<table id="materialTable">
			<tr>
				<td style="background:lightgray;">재료명</td>
				<td colspan="2"><input type="text" name="matName"></td>
			</tr>
			<tr>
				<td style="background:lightgray;">알레르기</td>
				<td colspan="2"><select name="alleCode">
					<option value="A1">난류(계란)</option>
					<option value="A2">우유</option>
					<option value="A3">메밀</option>
					<option value="A4">땅콩</option>
					<option value="A5">대두</option>
					<option value="A6">밀</option>
					<option value="A7">고등어</option>
					<option value="A8">게</option>
					<option value="A9">돼지고기</option>
					<option value="A10">복숭아</option>
					<option value="A11">토마토</option>
					<option value="A12">새우</option>
					<option value="A13">호두</option>
					<option value="A14">닭고기</option>
					<option value="A15">쇠고기</option>
					<option value="A16">오징어</option>
					<option value="A17">조개류</option>
					<option value="A18">아황산류</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="disease_go" value="go" id="go"><label for="go">고혈압</label></td>
				<td><input type="checkbox" name="disease_dang" value="dang" id="dang"><label for="dang">당뇨병</label></td>
				<td><input type="checkbox" name="disease_head" value="head" id="head"><label for="head">뇌질환</label></td>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="submit" value="추가">&nbsp;<input type="reset" value="취소"></td>
			</tr>
		</table>
	</div>
	</form>
	<script>
		$(function(){
			$("input[type:submit]").click(function(){
				alert(<%= msg %>);
			});
		})
	</script>
</body>
</html>