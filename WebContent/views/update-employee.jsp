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
<title>Add employee</title>
</head>
<body>
    <%@ include file="/views/header.jsp"%>

<form action="${pageContext.request.contextPath }/addEmployee" method="post">
Id<input type="text" value="${employee.id }" name="id" readonly>
First Name<input type="text" value="${employee.firstName }" name="firstName"><br/>
Last Name<input type="text"value="${employee.lastName }"  name="lastName"><br/>
Address<input type="text"value="${employee.address }"  name="address"><br>
Phone Number<input type="text"value="${employee.phone }"  name="phone"><br>
Note<input type="text"value="${employee.note }"  name="note"><br>
Wage<input type="text"value="${employee.wage }"  name="wage"><br>
<input type="submit" value="Submit new Employee">

</form>

<%@ include file="/views/footer.jsp"%>
</body>
</html>