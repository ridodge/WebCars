<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<form style="display:flex; flex-direction: column;" action="editItemServlet" method="post">
		Make: <input type="text" name="make" value="${itemToEdit.make}">
		Model: <input type="text" name="model" value="${itemToEdit.model}">
		<input type="hidden" name="id" value="${itemToEdit.id}"> <input
			type="submit" value="Save Edited Item">
	</form>
</body>
</html>