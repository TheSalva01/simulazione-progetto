<%-- <%
	String username = (String) session.getAttribute("username");
	if(username != null) {
%> 	 --%>
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
		<main>
			<h2 class="mx-4 my-3">Lista Corsisti:</h2>
			<table class="table">
				<thead class="thead-dark">
				    <tr>
					      <th scope="col">#</th>
					      <th scope="col">Nome</th>
					      <th scope="col">Cognome</th>
					      <th scope="col">Prec Form</th>
				    </tr>
				</thead>
					<%
						List<Corsista> c = AdminFacade.getInstance().getCorsisti();
						for(int i = 0; i < c.size(); i++) {
					%>
					<tbody>
					    <tr>
						      <th scope="row">1</th>
						      <td><%=c.get(i).getNomeCorsista()%></td>
						      <td><%=c.get(i).getCognomeCorsista()%></td>
					    </tr>
					</tbody>
					<%
						}
					%>
				</table>
				
			</ul>
		</main>
	</body>
</html>
<%-- <%
	}
%> --%>