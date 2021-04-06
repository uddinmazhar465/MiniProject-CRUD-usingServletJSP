<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<table border="1">
		<tr>
			<th>Roll</th>
			<th>Name</th>
			<th>Course</th>
			<th>Marks</th>
		</tr>
		<c:forEach var="s" items="${allRec}">
			<tr>
				<td>${s.roll}</td>
				<td>${s.name}</td>
				<td>${s.course}</td>
				<td>${s.marks}</td>
				<td><a href="std?msg=up&r=${s.roll}">Update</a><br><a href="std?msg=del&r=${s.roll}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
<b>${deleteStd}</b>
