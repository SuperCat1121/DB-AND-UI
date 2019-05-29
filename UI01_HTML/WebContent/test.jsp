<%@page import="com.biz.EmpBiz"%>
<%@page import="com.biz.EmpBizImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.dto.EmpDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
</head>
<body>
	<table>
		<%
			EmpBiz biz = new EmpBizImpl();
			List<EmpDto> selectList = biz.selectList();
			for(EmpDto dto : selectList) {
		%>
		<tr>
			<td>
				<% out.print(dto.getEmpno()); %>
			</td>
			<td>
				<% out.print(dto.getEname()); %>
			</td>
			<td>
				<% out.print(dto.getJob()); %>
			</td>
			<td>
				<% out.print(dto.getMgr()); %>
			</td>
			<td>
				<% out.print(dto.getHiredate()); %>
			</td>
			<td>
				<% out.print(dto.getSal()); %>
			</td>
			<td>
				<% out.print(dto.getComm()); %>
			</td>
			<td>
				<% out.print(dto.getDeptno()); %>
			</td>
			<td>
				<% out.print(dto.getSalary()); %>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>