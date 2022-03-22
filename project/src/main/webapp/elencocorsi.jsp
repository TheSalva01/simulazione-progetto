<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.betacom.businesscomponent.model.Corso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<div class="container-fluid">

<%
if(request.getParameter("bottone") != null && request.getParameter("bottone").equals("inserisci")) {
%>
<div class="page-header">
	<h2 class="py-3 col-md-offset-1">CORSI DISPONIBILI</h2>
		<h4 class="my-3 col-md-offset-1">Scegliere il corso per l'iscrizione del corsista</h4>
</div>
<%
	List<Corso> corsi = AdminFacade.getInstance().getCorsi();
	for(Corso c: corsi){
		if(AdminFacade.getInstance().getSlotsAvailable(c) > 0) {
%>
<div class="row row-cols-1 row-cols-md-3">
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
			<button type="submit" class="btn btn-primary">Inserisci corsista</button>
		</form>
      </div>
    </div>
  </div>
  </div>
<%
		}
	}
} else {
%>
  
<div class="page-header">
	<h2 class="py-3 col-md-offset-1">I MIEI CORSI</h2>
		<h4 class="my-3 col-md-offset-1">Scegliere il corso da eliminare</h4>
</div>

<div class="container">
<%
	List<Corso> corsi = AdminFacade.getInstance().getCorsi();
	for(Corso c: corsi){
%>
<div class="row row-cols-1 row-cols-md-3">
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
			<button type="submit" class="btn btn-danger">eliminacorso</button>
		</form>
      </div>
    </div>
  </div>
  </div>

<%
	}
%>
	</div>
<%
}
%>

</div>
</body>
</html>