<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Cars</title>
<style>
.display {
display: flex;
align-items: center;
justify-content:center;
height: 100vh;
flex-direction: column}
</style>
</head>
<body class="display">
	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<tr>
					<td><input type="radio" name="id" value="${currentitem.id}"></td>
					<td>${currentitem.make}</td>
					<td>${currentitem.model}</td>
				</tr>
			</c:forEach>
			<input type="submit" value="edit" name="doThisToItem">
			<input type="submit" value="delete" name="doThisToItem">
			<input type="submit" value="add" name="doThisToItem">
			</form>
		</table>
</body>
</html>