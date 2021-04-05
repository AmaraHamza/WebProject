<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Informations Client</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
</head>
<body>
  <div id="corps">
	<c:choose>
		<c:when test="${erreur }">
			<h5 style="color:#ffa64d"> <c:out value="${message }"/></h5>
			<h5 style="color:#ffa64d"><a href="http://localhost:8080/EcomProject/InfoClient.jsp">Cliquez ici</a> pour revenir à la page du formulaire de création de client</h5><br>
		</c:when>
		<c:otherwise>
			<h5 style="color:#ffa64d"><c:out value="${message }"/></h5>
			<p><strong>Client : </strong></p><br>
			<label>Nom Client : </label> <c:out value="${client.nom }"/>  <br>
			<label>Prénom Client : </label> <c:out value="${client.prenom }"/>  <br>
			<label>Adresse Livraison : </label> <c:out value="${client.adresseLivraison }"/> <br>
			<label>Email Client : </label> <c:out value="${client.email }"/> <br>
			<label>Tel Client : </label> <c:out value="${client.numTele }"/> <br>
		</c:otherwise>
 	</c:choose>
  </div>
</body>
</html>