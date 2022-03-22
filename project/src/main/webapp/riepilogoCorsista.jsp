<%@page import="java.util.List"%>
<%@page import="com.betacom.businesscomponent.model.Corso"%>
<%@page import="com.betacom.businesscomponent.facade.AdminFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" errorPage="/errore.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<%@include file="CDN.html" %>
		<link rel="stylesheet" href="css/home.css">
		<title>Riepologo Corsista</title>
	</head>
	<body>
		<jsp:include page="navBar.jsp"/>
			<%
				String username = (String) session.getAttribute("username");
				if(username != null) {
			%> 	
			<%
				List<Corso> c = AdminFacade.getInstance().getCorsiByCorsista(129);
				if(c != null && c.size() != 0) {
					for(int i = 0; i < c.size(); i++) {
			%>
			<main>
				<div class="card my-4">
				  <div class="card-header">
				  	<h4 class="float-left">
				  		<%=c.get(i).getNomeCorso()%> - Aula: <%=c.get(i).getAulaCorso()%>
				  	</h4>
				    <div class="float-right">
				    	<span><%=c.get(i).getDataInizioCorso()%></span><span> - </span><span><%=c.get(i).getDataFineCorso()%></span>
				    </div>
				  </div>
				  <div class="card-body">
				    <div class="blockquote mb-0">
				    	<h5>COMMENTO CORSO:</h5>
				      	<p><%=c.get(i).getCommentiCorso()%></p>
				    </div>
				  </div>
				  <div class="card-footer">
				  		<h5 class="float-left">ID DOCENTE: <%=c.get(i).getDocente()%></h5>
				    	<h5 class="float-right">COSTO: &euro; <%=c.get(i).getCostoCorso()%></h5>
				  </div>
				</div>
			<%
					}
				} else {
			%>
				<div class="card text-center">
					  <div class="card-header">
					    NESSUN CORSO TROVATO
					  </div>
					  <div class="card-body">
						    <h3 class="card-title">Il corsista non sta frequentando corsi</h3>
						    
					  </div>
				</div>
			<%
				}
			%>
		</main>
	</body>
</html>


<%
} else {
	response.sendRedirect("errore.jsp");
}
%>