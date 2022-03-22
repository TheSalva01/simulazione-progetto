
<%@page import="java.util.List"%>
<%@page import="com.betacom.businesscomponent.facade.AdminFacade"%>
<%@page import="com.betacom.businesscomponent.model.Corsista"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<%@include file="CDN.html" %>
	<link rel="stylesheet" href="css/home.css">
	<title>Controllo Corsisti</title>
	</head>
	<body>
		<jsp:include page="navBar.jsp"/>
		<%
			String username = (String) session.getAttribute("username");
			if(username != null) {
		%> 	
		<main>
			<div class="container-fluid m-0 p-0">
				<h2 class="mx-4 my-3 float-left">CORSISTI</h2>
				<div class="float-right m-3">
					<button class="css-button css-button-sliding-to-left css-button-sliding-to-left--grey">Nuovo Corsista</button>
					<button class="css-button css-button-sliding-to-left css-button-sliding-to-left--grey">Statistiche</button>
					<button class="css-button css-button-sliding-to-left css-button-sliding-to-left--grey">Elimina Corsi</button>
				</div>
				<table class="table table-striped table-hover">
					<thead class="thead-dark">
					    <tr class="font-weight-bold text-center">
						      <th class="col-3" scope="col"><h5 class="m-0">ID</h5></th>
						      <th class="col-3" scope="col"><h5 class="m-0">Nome</h5></th>
						      <th class="col-3" scope="col"><h5 class="m-0">Cognome</h5></th>
						      <th class="col-3" scope="col"><h5 class="m-0">Prec. Form.</h5></th>
					    </tr>
					</thead>
					<%
						List<Corsista> c = AdminFacade.getInstance().getCorsisti();
						for(int i = 0; i < c.size(); i++) {
					%>
					<tbody>
					    <tr class="font-weight-bold text-center">
					   		<th class="col-3" scope="row"><%=c.get(i).getCodCorsista()%></th>
					      	<td class="col-3"><%=c.get(i).getNomeCorsista()%></td>
					      	<td class="col-3"><%=c.get(i).getCognomeCorsista()%></td>
						    <td class="col-3">
								<input style="width:20px; height:20px;" disabled type="checkbox" name="precForm" <% if (c.get(i).getPrecForm() == 1) {out.print("checked");} %>/>
							</td>
					    </tr>
					</tbody>
					<%
						}
					%>
				</table>
			</div>
			<%
				} else {
			%>
				<div class="card text-center">
					  <div class="card-header">
					    Non puoi accedere a questa pagina
					  </div>
					  <div class="card-body">
						    <h3 class="card-title">EFFETTUARE LOGIN</h3>
						    <p class="card-text">Inserire le proprie credenziali nel pannello Login per accedere</p>
					  </div>
				</div>
			<%
				}
			%>
		</main>
	</body>
</html>
