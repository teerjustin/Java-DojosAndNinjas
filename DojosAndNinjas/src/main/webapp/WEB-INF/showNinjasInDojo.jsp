<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> <c:out value ="${dojo.name}"> </c:out> </h1>
		<table>
		    <thead>
		        <tr> 
		        	<td> First Name </td>
		            <td> Last Name</td>
		            <td> Age </td>

		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${dojo.ninjas}" var="ninja">
		        <tr>
		            <td> <c:out value="${ninja.firstName}">zxc</c:out></td>
		            <td> <c:out value="${ninja.lastName}"></c:out></td>
		            <td> <c:out value="${ninja.age}"></c:out></td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
</body>
</html>