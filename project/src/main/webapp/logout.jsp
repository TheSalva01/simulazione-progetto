<%
	String username = (String) session.getAttribute("username");
	if(username != null) {
		session.invalidate(); 
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" errorPage="errore.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
<jsp:include page="navBar.jsp"/>
<div class="container text center">
		<div class="card text-center">
			  <h2 class="card-header">
			    LOGOUT
			  </h2>
			  <div class="card-body">
				    <h5 class="card-title">Hai effettuato il Logout</h5>
				    <p class="card-text">Inserire le proprie credenziali nel pannello Login per accedere</p>
			  </div>
		</div>
</div>

</body>
</html>
<%
	} else { 
		response.sendRedirect("home.jsp");
	}
%>


