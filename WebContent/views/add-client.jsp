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
<title>Add client</title>
</head>
<body>
    <%@ include file="/views/header.jsp"%>

<form action="${pageContext.request.contextPath }/addClient" method="get">
First Name<input type="text" name="firstName"><br/>
Last Name<input type="text" name="lastName"><br/>
Date of Birth<input type="text" name="dateOfBirth"><br>
<input type="submit" value="Submit new Client">

</form>

<%@ include file="/views/footer.jsp"%>
</body>
</html>