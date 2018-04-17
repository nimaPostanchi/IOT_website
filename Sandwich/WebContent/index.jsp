<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 --%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<head>
	<script type="text/javascript" src="sandwich.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Available sandwiches</title>
<style type="text/css">
#div1{
background-color: #E00049;
height: 110px;
}
</style>
</head>
<header>
<div id="div1">
<img src="logo.png" width="300" height="98">
</div>
</header>
<body onload="getAvailableSandwiches()">
<h2>Sandwiches</h2>
<h3>Veggie</h3>
<div id="avalaible"></div>
</body>
</html>