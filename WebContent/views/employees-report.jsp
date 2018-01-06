<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
<%@include file="/css/style.css"%>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home sweet home</title>
</head>
<body>
    <%@ include file="/views/header.jsp"%>
<table>
<tr>
<th>Name</th>
<th>Hours</th>
</tr>
<c:forEach  var="emp" items="${map }">
<tr>
<td><c:out value="${emp.key }"></c:out>
<td><c:out value="${emp.value }"></c:out>
</c:forEach>

</table>

<%@ include file="/views/footer.jsp"%>
</body>
</html>