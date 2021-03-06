<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.betacom.businesscomponent.model.Corso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/errore.jsp"%>
<%@page import="com.betacom.businesscomponent.facade.AdminFacade"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Elenco corsi</title>
</head>
<body>
<jsp:include page="navBar.jsp"/>
<%
	String username = (String) session.getAttribute("username");
	if(username != null) {
%> 	

<div class="container-fluid">

<%
if(session.getAttribute("bottone") != null && session.getAttribute("bottone").equals("inserisci")) {
%>
<div class="page-header">
	<h2 class="py-3 col-md-offset-1 text-center">CORSI DISPONIBILI</h2>
	<h4 class="my-3 col-md-offset-1 text-center">Scegliere il corso per l'iscrizione del corsista</h4>
</div>

<div class="row row-cols-1 row-cols-md-3">
<%
	List<Corso> corsi = AdminFacade.getInstance().getCorsi();
	for(Corso c: corsi){
		if(AdminFacade.getInstance().getSlotsAvailable(c) > 0) {
%>
  <div class="col mb-4">
    <div class="card">
      <img src="img/corsionline.jpg" class="card-img-top" alt="corso">
      <div class="card-body">
        <h5 class="card-title"><%= c.getNomeCorso() %></h5>
        <p class="card-text">
        	Corso che va dal <%= new SimpleDateFormat("dd/MM/YYYY").format(c.getDataInizioCorso()) %><br>
        	al <%= new SimpleDateFormat("dd/MM/YYYY").format(c.getDataFineCorso()) %><br>
        	in aula <%= c.getAulaCorso() %><br>
        	al prezzo di <%= c.getCostoCorso() %>&euro;
        </p>
        <form action="/<%= application.getServletContextName()%>/inseriscicorsista" method="post">
        <input type="hidden" name="codCorso" value="<%= c.getCodCorso() %>">
        <input type="hidden" name="nomeCorso" value="<%= c.getNomeCorso() %>">
        <input type="hidden" name="dataInizio" value="<%= new SimpleDateFormat("dd/MM/yyyy").format(c.getDataInizioCorso())%>">
        <input type="hidden" name="dataFine" value="<%= new SimpleDateFormat("dd/MM/yyyy").format(c.getDataFineCorso()) %>">
        <input type="hidden" name="costoCorso" value="<%= c.getCostoCorso()%>">
        <input type="hidden" name="commenti" value="<%= c.getCommentiCorso()%>">
        <input type="hidden" name="aula" value="<%= c.getAulaCorso()%>">
        <input type="hidden" name="docente" value="<%= c.getDocente()%>">
			<button type="submit" class="btn btn-primary">Inserisci corsista</button>
		</form>
      </div>
    </div>
  </div>
<%
		}
	}
%>
  </div>
<%
} else if(session.getAttribute("bottone") != null && session.getAttribute("bottone").equals("elimina")){
%>
  
<div class="page-header">
	<h2 class="py-3 col-md-offset-1 text-center">I MIEI CORSI</h2>
		<h4 class="my-3 col-md-offset-1 text-center">Scegliere il corso da eliminare</h4>
</div>

<div class="row row-cols-1 row-cols-md-3">
<%
	List<Corso> corsi = AdminFacade.getInstance().getCorsi();
	for(Corso c: corsi){
%>
  <div class="col mb-4">
    <div class="card">
      <img src="img/corsionline.jpg" class="card-img-top" alt="corso">
      <div class="card-body">
        <h5 class="card-title"><%= c.getNomeCorso() %></h5>
        <p class="card-text">
        	Corso che va dal <%= new SimpleDateFormat("dd/MM/YYYY").format(c.getDataInizioCorso()) %><br>
        	al <%= new SimpleDateFormat("dd/MM/YYYY").format(c.getDataFineCorso()) %><br>
        	in aula <%= c.getAulaCorso() %><br>
        	al prezzo di <%= c.getCostoCorso() %>&euro;
        </p>
        <form action="/<%= application.getServletContextName()%>/eliminacorso" method="post">
        <input type="hidden" name="codCorso" value="<%= c.getCodCorso() %>">
        <input type="hidden" name="nomeCorso" value="<%= c.getNomeCorso() %>">
        <input type="hidden" name="dataInizio" value="<%= new SimpleDateFormat("dd/MM/yyyy").format(c.getDataInizioCorso())%>">
        <input type="hidden" name="dataFine" value="<%= new SimpleDateFormat("dd/MM/yyyy").format(c.getDataFineCorso()) %>">
        <input type="hidden" name="costoCorso" value="<%= c.getCostoCorso()%>">
        <input type="hidden" name="commenti" value="<%= c.getCommentiCorso()%>">
        <input type="hidden" name="aula" value="<%= c.getAulaCorso()%>">
        <input type="hidden" name="docente" value="<%= c.getDocente()%>">
			<button type="submit" class="btn btn-danger">Elimina corso</button>
		</form>
      </div>
    </div>
  </div>
 <%
	}
%>
  </div>
<%
} else {
	response.sendRedirect("errore.jsp");
}
%>

<hr>
<a href="home.jsp">Torna alla home</a>

</div>
</body>
</html>

<%
} else {
	response.sendRedirect("errore.jsp");
}
%>