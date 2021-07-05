<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> hello </h1>
	
	<form:form action="/dojos/new/ninja/create" method="post" modelAttribute="ninja">
		<p>
			<form:label path="dojo">Dojo: </form:label>
			<select id="dojo" name="dojo">
				<c:forEach items="${dojos}" var="dojo">
				    <option value="${dojo.id}">${dojo.name}</option>
				</c:forEach>
			</select>
		</p>
		
	    <p>
	        <form:label path="firstName">First Name: </form:label>
	        <form:errors path="firstName"/>
	        <form:input path="firstName"/>
	    </p>
	    <p>
	        <form:label path="lastName">Last Name: </form:label>
	        <form:errors path="lastName"/>
	        <form:input path="lastName"/>
	    </p>
	    <p>
	        <form:label path="age">Age: </form:label>
	        <form:errors path="age"/>
	        <form:input path="age"/>
	    </p>

	    <input type="submit" value="Submit"/>
	</form:form>   
</body>
</html>