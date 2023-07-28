<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Cities</title>
</head>
<body>
	<table border="1" style="border-collapse: collapse;">

		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<c:forEach var="student" items="${students}">
			<tr>
				<td>${student.getId()}</td>
				<td>${student.getName()}</td>
				<td>${student.getEmail()}</td>
				<td><a href="delete?id=${student.getId()}">Delete</a></td>
				<td><a href="update?id=${student.getId()}">Update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>