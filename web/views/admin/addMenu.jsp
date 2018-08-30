<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.msmg.admin.model.vo.*"%>
<%
	ArrayList<Material> matList=(ArrayList<Material>)request.getAttribute("matList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 추가</title>
<style>
	#content{
		width:330px;
		height:230px;
	}
	#content > label{
		font-weight:bold;
		font-size:24px;
	}
</style>
</head>
<body>
	<form action="<%= request.getContextPath() %>/addMenu" method="post" encType="multipart/form-data">
	<div id="content" align="center">
		<label>메뉴 추가</label>
		<table id="menuTable">
			<tr>
				<td style="background:lightgray;">메뉴명</td>
				<td colspan="2"><input type="text" name="menuName"></td>
			</tr>
			<tr>
				<td style="background:lightgray;">주재료</td>
				<td colspan="2"><!-- <input type="text" name="mainMat"> -->
					<select name="mainMat">
						<%
							for(int i=0;i<matList.size();i++){
						%>
								<option value="<%= matList.get(i).getM_name() %>"><%= matList.get(i).getM_name() %></option>
						<%
							}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td style="background:lightgray;">보조재료</td>
				<td colspan="2"><!-- <input type="text" name="subMat"> -->
					<select name="subMat">
						<option value="NO">없음</option>
						<%
							for(int i=0;i<matList.size();i++){
						%>
								<option value="<%= matList.get(i).getM_name() %>"><%= matList.get(i).getM_name() %></option>
						<%
							}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td style="background:lightgray;">가격</td>
				<td colspan="2"><input type="text" name="price"></td>
			</tr>
			<tr>
				<td style="background:lightgray;">메뉴정보</td>
				<td colspan="2"><input type="text" name="info"></td>
			</tr>
			<tr>
				<td style="background:lightgray;">이미지</td>
				<td colspan="2"><input type="file" id="thumbnailImg" name="thumbnailImg" multiple></td>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="submit" value="추가">&nbsp;<input type="reset" value="취소"></td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>