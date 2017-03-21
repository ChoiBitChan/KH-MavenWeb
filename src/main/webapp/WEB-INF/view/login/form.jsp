<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form:form commandName="loginCommand">
		<form:errors element="div" />
		아이디: <form:input path="userId" />
		<form:errors path="userId" element="div" />
		<br />
		암호: <form:password path="password" showPassword="false" />
		<form:errors path="password" />
		<br />
		<input type="submit" />
	</form:form>
</body>
</html>