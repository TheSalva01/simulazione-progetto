<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
errorPage="errore.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/home.css">
<meta charset="ISO-8859-1">
<title>Registrazione utente</title>
<script src="js/validazione.js"></script>
</head>
<body>
<jsp:include page="navBar.jsp"/>
<div class="container">
<div class="page-header">
	<h3 class="my-4">Inserire i dati per la registrazione Corsista</h3>
</div> 

<form action="/<%= application.getServletContextName()%>/registra" method="get"
class="form-horizontal" id="userForm">

<!-- ----------------------------------------NOME -->
<div class="form-row">
	<div class="form-group col-md-6">
	<label class="control-label">Nome</label>
	<div class="inputGroupContainer">
		<div class="input-group">
			<input type="text" name="nome" id="nome"
			placeholder="Nome..."
			class="form-control">
		</div>
	</div>
	<div class="col-md-7 control-label" id="infoNome"></div>
</div>

<!-- ----------------------------------------COGNOME -->
<div class="form-group col-md-6">
	<label class="control-label">Cognome</label>
	<div class="inputGroupContainer">
		<div class="input-group">
			<input type="text" name="cognome" id="cognome"
			placeholder="Cognome..."
			class="form-control">
		</div>
	</div>
	<div class="col-md-7 control-label" id="infoCognome"></div>
</div>
</div>

<div class="form-group">
    <div class="form-check">
      <input style="width:20px; height:20px;" class="form-check-input" type="checkbox" value="" id="formPrec">
      <label class="form-check-label font-weight-bold mx-2" for="formPrec">
        Precedenti formativi
      </label>
    </div>
  </div>

<div class="row">
	<div class="col-md-4 col-md-offset-1">
		<button type="submit" class="css-button css-button-sliding-to-left css-button-sliding-to-left--grey">
			Registra
		</button>
	</div>
</div>
</form>
</div>
</body>
</html>