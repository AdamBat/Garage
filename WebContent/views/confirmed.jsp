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
    <c:set var="var" value="${add }"></c:set>
     <c:set var="var1" value="${del }"></c:set>
     <c:set var="var2" value="${upd }"></c:set>
<c:choose>
<c:when test="${var =='car'}">New car has been added</c:when>
<c:when test="${var =='emp'}">New employee has been added</c:when>
<c:when test="${var =='client'}">New client has been added</c:when>
<c:when test="${var =='order'}">New repair has been added</c:when>
<c:when test="${var1 =='car'}">Car has been deleted</c:when>
<c:when test="${var1 =='emp'}">Employee has been deleted</c:when>
<c:when test="${var1 =='client'}">Client has been deleted</c:when>
<c:when test="${var1 =='order'}">Order has been deleted</c:when>
<c:when test="${var2 =='car'}">Car has been updated</c:when>
<c:when test="${var2 =='emp'}">Employee has been updated</c:when>
<c:when test="${var2 =='client'}">Client has been updated</c:when>
<c:when test="${var2 =='order'}">Order has been update</c:when>
</c:choose>
<%@ include file="/views/footer.jsp"%>
</body>
</html>