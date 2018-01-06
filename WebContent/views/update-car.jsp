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
<title>Add Car</title>
</head>
<body>
    <%@ include file="/views/header.jsp"%>

<form action="${pageContext.request.contextPath }/addCar" method="post">
Id<input type="text" value="${car.id }" name="id" readonly>
Client<select name="client_id">
<c:forEach var="client" items="${clients }">
<option value="${client.id }"><c:out value="${client.lastName }"></c:out>
</option>
</c:forEach>
</select>
Brand<input type="text"value="${car.brand }" name="brand"><br/>
Model<input type="text"value="${car.model}" name="model"><br>
Year<input type="text"value="${car.year}" name="year"><br>
Reg Nr<input type="text"value="${car.regNr }" name="regNr"><br>
Next Review<input type="text"value="${car.nextReview }" name="nextReview"><br>
<input type="submit" value="Submit new Car">

</form>

<%@ include file="/views/footer.jsp"%>
</body>