<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos</title>
</head>
<body>
	<h1> All Dojos </h1>
		<table>
		    <thead>
		        <tr>
		            <th>Dojo Name</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${dojos}" var="dojo">
		        <tr>
		            <td> <c:out value="${dojo.name}"></c:out></td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		<a href = "<c:url value = "/dojos/new"/>">Create a new dojo</a>
</body>
</html>