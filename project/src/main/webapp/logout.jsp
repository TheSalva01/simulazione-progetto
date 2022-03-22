
<%
String username = (String) session.getAttribute("nome_admin");
if (username != null) {
	session.invalidate();
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Logout page</title>
</head>
<body>
	<jsp:include page="navBar.jsp" />
	<div class="container-fluid m-0 p-0">
		<div class="page-header">
			<h3>Logout</h3>
		</div>
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3>Hai appena eseguito il logout</h3>
			</div>
			<div class="panel-body">
				<p>Per accedere di nuovo esegui il login dal menu</p>
			</div>
		</div>
	</div>
</body>
</html>
<%
}
%>
