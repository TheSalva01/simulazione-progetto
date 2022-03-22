<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@include file="CDN.html" %>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/style.css">
	<meta charset="ISO-8859-1">
	<title>Accesso negato</title>
</head>
	<body>
		<jsp:include page="navBar.jsp"/>
		<div class="container text-center mt-5 mx-auto">
			<div class="card border-danger mb-3 mx-auto" style="width: 60vw;">
		  		<h3 class="card-header text-danger">ERRORE</h3>
		  		<div class="card-body text-danger">
		    		<h5>Hai effettuato 5 tentativi errati</h5>
		    		<h6>Assicurati che le credenziali inserite siano corrette</h6>
		    		<p></p>
		    		<a href="./home.jsp" class="card-text text-danger">Effettua il login</a>
		  		</div>
			</div>
		</div>
	</body>
</html>