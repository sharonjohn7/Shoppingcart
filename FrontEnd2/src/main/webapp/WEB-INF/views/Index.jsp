<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<a href='<c:url value="/" />'>Home</a><br/><br/><br/>
<a href='<c:url value="/add" />'>Add User</a><br/><br/>
<a href='<c:url value="/upd" />'>Update User</a><br/><br/>
<a href='<c:url value="/del" />'>Delete User</a><br/><br/>
<a href='<c:url value="/viewall" />'>View Users</a>
</body>
</html>