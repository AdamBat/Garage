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
<title>Add order</title>
</head>
<body>
    <%@ include file="/views/header.jsp"%>

<form action="${pageContext.request.contextPath }/addOrder" method="get">
Start Date<input type="text" name="startDate"><br/>
End Date<input type="text" name="endDate"><br/>
Employee<select name="employeeId">
<c:forEach var="employee" items="${employees }">
<option value="${employee.id }"><c:out value="${employee.lastName }"></c:out>
</option>
</c:forEach>
</select>
<br>
Problem description<input type="text" name="descProblem"><br>
Repair description<input type="text" name="descRepair"><br>
Status<input type="text" name="status"><br>
Repair Cost<input type="text" name="repairCost"><br>
Parts Cost<input type="text" name="partsCost"><br>
Employee Hours<input type="text" name="employeeHours"><br>
<input type="submit" value="Submit new Repair">

</form>

<%@ include file="/views/footer.jsp"%>
</body>
</html>