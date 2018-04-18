<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<head>
<script type="text/javascript" src="sandwich.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Available sandwiches</title>
<style type="text/css">
main{
margin: 10px;
}

#div1 {
	background-color: #E00049;
	height: 110px;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
th, td {
width: 140px;
text-align: center;
}
#order{
display: none;
}
</style>
</head>
<header>
<div id="div1">
	<img src="logo.png" width="300" height="95">
</div>
</header>
<body onload="getAvailableSandwiches(); getSandwiches()">
<main>
	<h2>Sandwiches</h2>
	<table>
		<tr>
			<th>Sandwich</th>
			<th>Availability</th>
			<th id="order">Order</th>
		</tr>
		<tr>
			<td>Veggie</td>
			<td><div id="available"></div></td>
			<td id="order">Order</td>
		</tr>
	</table>
	</main>
<!-- 	<script type="text/javascript">
	var randomSandwich = new XMLHttpRequest();

	function getSandwiches(){
		randomSandwich.open("GET", "Controller", true);
		randomSandwich.onreadystatechange = getSandwichCall;
		randomSandwich.send(null);
	}
	
	
/* 	var sandwich = document.getElementById("available");
	console.log(sandwich);
	if(sandwich < 8){
	$(document).ready(function() {
		$("#available").click(function() {
			$("#order").slideToggle();
		})
	})
	} */
	function getSandwichCall(){
		if (randomSandwich.status == 200) {
			if (randomSandwich.readyState == 4) {
				var serverRsponse = JSON.parse(randomSandwich.responseText);
				console.log(serverRsponse);
				if(serverRsponse < 8){
				$(document).ready(function() {
					$("#available").click(function() {
						$("#order").slideToggle();
					})
				})
				} 

				

				setTimeout("getSandwiches()", 5000);
			}
		}
	}
	
	</script> -->
</body>
</html>