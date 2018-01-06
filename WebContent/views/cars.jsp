<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style><%@include file="/css/style.css"%></style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cars List</title>
</head>
<body>
	<%@ include file="/views/header.jsp"%>
	<h1>Cars List</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Client_id</th>
			<th>Brand</th>
			<th>Model</th>
			<th>prod year</th>
			<th>Reg Nr</th>
			<th>Next Review Date</th>
			<th>Update Car</th>
			<th>Delete Car</th>
		</tr>
		<c:forEach var="car" items="${cars }">
			<c:url var="update" value="/car/update">
				<c:param name="id" value="${car.id }"></c:param>
			</c:url>
			<c:url var="delete" value="/car/delete">
				<c:param name="id" value="${car.id }"></c:param>
			</c:url>
			<tr>
				<td><c:out value="${car.id }"></c:out></td>
				<td><c:out value="${car.client_id }"></c:out></td>
				<td><c:out value="${car.brand }"></c:out></td>
				<td><c:out value="${car.model }"></c:out></td>
				<td><c:out value="${car.year }"></c:out></td>
				<td><c:out value="${car.regNr }"></c:out></td>
				<td><c:out value="${car.nextReview }"></c:out></td>
				<td><a href="${update }">Update</a></td>
				<td><a href="${delete }">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/carForm">Add new car</a>


	<%@ include file="/views/footer.jsp"%>
</body>
</html>