<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style><%@include file="/css/style.css"%></style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home sweet home</title>
</head>
<body>
	<%@ include file="/views/header.jsp"%>
	<h1>Employees List</h1>
	<table>
		<tr>
			<th>id</th>
			<th>First name</th>
			<th>Last name</th>
			<th>address</th>
			<th>Phone Number</th>
			<th>Note</th>
			<th>Wage</th>
			<th>Update Employee</th>
			<th>Delete Employee</th>
		</tr>
		<c:forEach var="emp" items="${empList}">
			<c:url var="update" value="/employee/update">
				<c:param name="id" value="${emp.id }"></c:param>
			</c:url>
			<c:url var="delete" value="/employee/delete">
				<c:param name="id" value="${emp.id }"></c:param>
			</c:url>
			<tr>
				<td><c:out value="${emp.id }"></c:out></td>
				<td><c:out value="${emp.firstName }"></c:out></td>
				<td><c:out value="${emp.lastName}"></c:out></td>
				<td><c:out value="${emp.address }"></c:out></td>
				<td><c:out value="${emp.phone }"></c:out></td>
				<td><c:out value="${emp.note }"></c:out></td>
				<td><c:out value="${emp.wage }"></c:out></td>
				<td><a href="${update }">Update</a></td>
				<td><a href="${delete }">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/employeeForm">Add new
		employee</a>
	<%@ include file="/views/footer.jsp"%>

</body>
</html>