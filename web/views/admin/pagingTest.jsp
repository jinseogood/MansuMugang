<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- <button onclick="location.href='<%= request.getContextPath() %>/selectMatList?currentPage=1'"><<</button>
					<%
						if(currentPage <= 1){
					%>
							<button disabled><</button>
					<%
						}
						else{
					%>
							<button onclick="location.href='<%= request.getContextPath() %>/selectMatList?currentPage=<%= currentPage - 1 %>'"><</button>
					<%
						}
					%>
					
					<%
						for(int p=startPage;p<=endPage;p++){
							if(p==currentPage){
					%>
								<button disabled><%= p %></button>
					<%
							}
							else{
					%>
								<button onclick="location.href='<%= request.getContextPath() %>/selectMatList?currentPage=<%= p %>'"><%= p %></button>
					<%		
							}
						}
					%>
					
					<%
						if(currentPage >= maxPage){
					%>
							<button disabled>></button>
					<%
						}
						else{
					%>
							<button onclick="location.href='<%= request.getContextPath() %>/selectMatList?currentPage=<%= currentPage + 1 %>'">></button>
					<%
						}
					%>
					<button onclick="location.href='<%= request.getContextPath() %>/selectMatList?currentPage=<%= maxPage %>'">>></button> --%>

</body>
</html>