<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html" %>
<link rel="stylesheet" href="css/home.css">
<title>Errore</title>
</head>
<body class="v-100">
	<jsp:include page="navBar.jsp"/>
	<div class="container-fluid center">
		<div class="page-header" style="color: #ed616f;">
			<h2>Si è verificato un errore interno</h2>
		</div>
		<br><br>
		
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3><%= exception.getClass().getName() %></h3>
			</div>
			<div class="panel-body">
				Error description: <%= exception.getMessage() %>
			</div>
		</div>
		<div>
			<button class="css-button css-button-sliding-to-left css-button-sliding-to-left--grey">Fuck go back</button>
		</div>
	</div>
</body>
</html>