<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit An Existing Trip</title>
</head>
<body>
	<form action="editListDetailsServlet" method="post">
		<input type="hidden" name="id" value="${listToEdit.id}"> Trip
		Name: <input type="text" name="tripName"
			value="${listToEdit.tripName}"><br /> Trip date: <input
			type="text" name="month" placeholder="mm" size="4" value="${month}">
		<input type="text" name="day" placeholder="dd" size="4"
			value="${date}">, <input type="text" name="year"
			placeholder="yyyy" size="4" value="${year}"> Driver Name: <input
			type="text" name="driverName"
			value="${listToEdit.driver.driverName}"><br /> Available
		Items:<br /> <select name="allItemsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<option value="${currentitem.id}">${currentitem.make}|
					${currentitem.model}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Edit List and Add Items">
	</form>
	<a href="index.html">Go add new cars instead.</a>
</body>
</html>