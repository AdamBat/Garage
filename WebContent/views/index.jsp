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

	<h1>List of current car repairs</h1>
	<table>
		<tr>
			<th>id</th>
			<th>start date</th>
			<th>End date</th>
			<th>Problem description</th>
			<th>Repair Description</th>
			<th>Status</th>
			<th>Repair Cost</th>
			<th>Parts cost</th>
			<th>Employee wage</th>
			<th>Employee Hours</th>
			<th>Update repair</th>
			<th>Delete repair</th>
		</tr>
		<c:forEach var="fix" items="${orders}">
			<c:url var="update" value="/orders/update">
				<c:param name="id" value="${fix.id }"></c:param>
			</c:url>
			<c:url var="delete" value="/orders/delete">
				<c:param name="id" value="${fix.id }"></c:param>
			</c:url>

			<tr>
				<td><c:out value="${fix.id}"></c:out></td>
				<td><c:out value="${fix.startDate}"></c:out></td>
				<td><c:out value="${fix.endDate}"></c:out></td>
				<td><c:out value="${fix.descProblem}"></c:out></td>
				<td><c:out value="${fix.descRepair}"></c:out></td>
				<td><c:out value="${fix.status}"></c:out></td>
				<td><c:out value="${fix.repairCost}"></c:out></td>
				<td><c:out value="${fix.partsCost}"></c:out></td>
				<td><c:out value="${fix.employeeWage}"></c:out></td>
				<td><c:out value="${fix.employeeHours}"></c:out></td>
				<td><a href="${update }">Update</a></td>
				<td><a href="${delete }">Delete</a></td>
			</tr>
		</c:forEach>


	</table>
	<a href="${pageContext.request.contextPath}/orderForm">Add new
		repair</a>

	<%@ include file="/views/footer.jsp"%>
</body>
</html>