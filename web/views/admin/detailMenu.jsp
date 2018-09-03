<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.msmg.admin.model.vo.*"%>
<%
	ArrayList<Material> matList=(ArrayList<Material>)request.getAttribute("matList");
	Menu m=(Menu)request.getAttribute("menu");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>메뉴 수정</title>
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
	<form id="detailForm" action="" method="post" encType="multipart/form-data">
	<div id="content" align="center">
		<label>메뉴 수정</label>
		<table id="menuTable">
			<input type="hidden" id="mCode" value="<%= m.getMenuCode() %>">
			<tr>
				<td style="background:lightgray;">메뉴명</td>
				<td colspan="2"><input type="text" name="menuName" value="<%= m.getMenuName() %>"></td>
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
				<td colspan="2"><input type="text" name="price" value="<%= m.getPrice() %>"></td>
			</tr>
			<tr>
				<td style="background:lightgray;">메뉴정보</td>
				<td colspan="2"><input type="text" name="info" value="<%= m.getMenuInfo() %>"></td>
			</tr>
			<tr>
				<td style="background:lightgray;">이미지</td>
				<td colspan="2"><input type="file" id="thumbnailImg" name="thumbnailImg" multiple></td>
			</tr>
			<tr align="center">
				<td colspan="3"><button onclick="editMenu();">수정</button>&nbsp;<button onclick="deleteMenu();">삭제</button></td>
			</tr>
		</table>
	</div>
	</form>
	<script>
		function editMenu(){
			var mCode=$("#menuTable").children("input[type='hidden']").val();
			console.log(mCode);
			$("#detailForm").attr("action", "<%= request.getContextPath() %>/updateMenu?menuCode="+mCode+"");
		}
		
		function deleteMenu(){
			var mCode=$("#menuTable").children("input[type='hidden']").val();
			console.log(mCode);
			$("#detailForm").attr("action", "<%= request.getContextPath() %>/deleteMenu?menuCode="+mCode+"");
		}
	</script>
</body>
</html>