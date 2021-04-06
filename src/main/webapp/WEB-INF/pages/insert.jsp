<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<form action="std" method="post">
	<input type="hidden" name="msg" value="i">
	<div>
		<table>
			<tr>
				<td>Roll</td>
				<td><input type="text" name="roll"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Course</td>
				<td><input type="text" name="course"></td>
			</tr>
			<tr>
				<td>Marks</td>
				<td><input type="text" name="marks"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</div>
</form>
<b>${insertStd}</b>