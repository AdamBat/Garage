<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style><%@include file="/css/style.css"%></style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Clients list</title>
</head>
<body>
	<%@ include file="/views/header.jsp"%>
	Search Client by Last Name
<form action="${pageContext.request.contextPath }/clientSearch">
<input type="text" name="lastName">
<input type="submit" value="search">
</form>	
	<h1>Clients list</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Date of Birth</th>
			<th>Update Client</th>
			<th>Delete Client</th>
		</tr>
		<c:forEach var="client" items="${clients }">
			<c:url var="update" value="/client/update">
				<c:param name="id" value="${client.id }"></c:param>
			</c:url>
			<c:url var="delete" value="/client/delete">
				<c:param name="id" value="${client.id }"></c:param>
			</c:url>
			<tr>
				<td><c:out value="${client.id}"></c:out></td>
				<td><c:out value="${client.firstName}"></c:out></td>
				<td><c:out value="${client.lastName}"></c:out></td>
				<td><c:out value="${client.dateOfBirth}"></c:out></td>
				<td><a href="${update }">Update</a></td>
				<td><a href="${delete }">Delete</a></td>
		</c:forEach>

	</table>
	<a href="${pageContext.request.contextPath}/clientForm">Add new
		client</a>

	<%@ include file="/views/footer.jsp"%>
</body>
</html>