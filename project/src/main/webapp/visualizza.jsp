<%@page import="com.betacom.businesscomponent.model.Corso"%>
<%@page import="com.betacom.businesscomponent.model.Corsista"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.betacom.businesscomponent.facade.AdminFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="/errore.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html"%>
<link rel="stylesheet" href="css/home.css">
<title>Visualizza</title>
</head>
<body>
	<jsp:include page="navBar.jsp" />
	<%
		String username = (String) session.getAttribute("username");
		if(username != null) {
	%> 	
	<h2 class="p-3">STATISTICHE</h2>

	<div class="container-fluid d-flex">
		<div class="card text-white bg-info mb-3 m-2"
			style="max-width: 16rem;">
			<div class="card-body">
				<h5 class="card-title">Numero di corsisti totale</h5>
				<h1 class="card-text"><%=AdminFacade.getInstance().getNumber()%></h1>
			</div>
		</div>

		<div class="card text-white bg-info mb-3 m-2"
			style="max-width: 16rem;">
			<div class="card-body">
				<h5 class="card-title">Corso più frequentato</h5>
				<h1 class="card-text"><%=AdminFacade.getInstance().getTrendCourse() == null ? "Nessuno" : AdminFacade.getInstance().getTrendCourse().getNomeCorso()%></h1>
			</div>
		</div>

		<div class="card text-white bg-info mb-3 m-2"
			style="max-width: 16rem;">
			<div class="card-body">
				<h5 class="card-title">Inizio ultimo corso</h5>
				<%
					Date date = AdminFacade.getInstance().getLastDate();
	
					String data = new SimpleDateFormat("dd/MM/yyyy").format(date);
				%>
				<h1 class="card-text"><%=data%></h1>
			</div>
		</div>

		<div class="card text-white bg-info mb-3 m-2"
			style="max-width: 16rem;">
			<div class="card-body">
				<h5 class="card-title">Durata media corsi</h5>
				<h1 class="card-text"><%=AdminFacade.getInstance().getMidLength()%>
					giorni
				</h1>
			</div>
		</div>

		<div class="card text-white bg-info mb-3 m-2"
			style="max-width: 16rem;">
			<div class="card-body">
				<h5 class="card-title">N^ commenti</h5>
				<h1 class="card-text"><%=AdminFacade.getInstance().getComment()%></h1>
			</div>
		</div>
	</div>

	<div class="container-fluid m-0 p-0">
		<h2 class="mx-4 my-3 float-left">CORSISTI</h2>
		<div class="float-right m-3"></div>
		<table class="table table-striped table-hover">
			<thead class="thead-dark">
				<tr class="font-weight-bold text-center">
					<th class="col-1" scope="col"><h5 class="m-0">ID</h5></th>
					<th class="col-3" scope="col"><h5 class="m-0">Nome</h5></th>
					<th class="col-3" scope="col"><h5 class="m-0">Cognome</h5></th>
					<th class="col-2" scope="col"><h5 class="m-0">Prec. Form.</h5></th>
					<th class="col-3" scope="col"><h5 class="m-0">#</h5></th>
				</tr>
			</thead>
			<%
			List<Corsista> c = AdminFacade.getInstance().getCorsisti();
			for (int i = 0; i < c.size(); i++) {
			%>
			 
			<tbody>
				<tr class="font-weight-bold text-center">
					<th class="col-1" scope="row"><%=c.get(i).getCodCorsista()%></th>
					<td class="col-3"><%=c.get(i).getNomeCorsista()%></td>
					<td class="col-3"><%=c.get(i).getCognomeCorsista()%></td>
					<td class="col-2"><input style="width: 20px; height: 20px;"
						disabled type="checkbox" name="precForm"
						<%if (c.get(i).getPrecForm() == 1) {
							out.print("checked");
						}%> />
					</td>
					<td class="col-3">
						<form action="/<%= application.getServletContextName()%>/riepilogocorsi" method="get">
						<input type="hidden" name="codCorso" value="<%= c.get(i).getCodCorsista() %>">
							<button class="css-button css-button-sliding-to-left css-button-sliding-to-left--grey">Dettagli Corsi</button>		
						</form>
						
					</td>
				</tr>
			</tbody>
			<%
				}
			%>
		</table>
	</div>
	
	<div class="container-fluid m-0 p-0">
		<h2 class="mx-4 my-3 float-left">CORSI CON POSTI DISPONIBILI</h2>
		<div class="float-right m-3"></div>
		<table class="table table-striped table-hover">
			<thead class="thead-dark">
				<tr class="font-weight-bold text-center">
					<th class="col-3" scope="col"><h5 class="m-0">Nome</h5></th>
					<th class="col-3" scope="col"><h5 class="m-0">Data inizio</h5></th>
					<th class="col-3" scope="col"><h5 class="m-0">Data fine</h5></th>
					<th class="col-3" scope="col"><h5 class="m-0">Prezzo</h5></th>
				</tr>
			</thead>
			<%
			List<Corso> corsi = AdminFacade.getInstance().getCorsi();
			for (int i = 0; i < corsi.size(); i++) {
				if(AdminFacade.getInstance().getSlotsAvailable(corsi.get(i)) > 0) {
			%>
			<tbody>
				<tr class="font-weight-bold text-center">
					<th class="col-3" scope="row"><%=corsi.get(i).getNomeCorso()%></th>
					<%
					String dataInizio = new SimpleDateFormat("dd/MM/yyyy").format(corsi.get(i).getDataInizioCorso());
					String dataFine = new SimpleDateFormat("dd/MM/yyyy").format(corsi.get(i).getDataFineCorso());
					%>
					<td class="col-3"><%=dataInizio%></td>
					<td class="col-3"><%=dataFine%></td>
					<td class="col-3"><%=corsi.get(i).getCostoCorso()%></td>
				</tr>
			</tbody>
			<%
				}
			}
			%>
		</table>
	</div>
</body>
</html>


<%
} else {
	response.sendRedirect("errore.jsp");
}
%>