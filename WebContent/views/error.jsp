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
<title>Error Page</title>
</head>
<body>

    <%@ include file="/views/header.jsp"%>
<h1>Error Page</h1>
<c:set var="var" value="${error }"></c:set>
<c:choose>
<c:when test="${var=='client' }">Before removing client you need to remove all his cars first!</c:when>
<c:when test="${var=='emp' }">Before removing employee you need to switch his repairs to another employee or remove it first!</c:when>

</c:choose>

<%@ include file="/views/footer.jsp"%>
</body>
</html>