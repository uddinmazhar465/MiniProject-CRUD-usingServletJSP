<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<form action="std" method="post">
	<input type="hidden" name="msg" value="u">
	<div>
		<table>
			<tr>
				<td>Roll</td>
				<td><input type="text" name="roll" value="${getStd.roll}"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${getStd.name}"></td>
			</tr>
			<tr>
				<td>Course</td>
				<td><input type="text" name="course" value="${getStd.course}"></td>
			</tr>
			<tr>
				<td>Marks</td>
				<td><input type="text" name="marks" value="${getStd.marks}"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</div>
</form>
<b>${updateStd}</b>