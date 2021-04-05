<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
</head>
<body>
	<div>
            <form method="post" action="creationClient">
                <fieldset>
                    <legend>Informations client</legend>
    
                    <label for="nomClient">Nom <span class="requis">*</span></label>
                    <input type="text" id="nomClient" name="nomClient" value="<c:out  value="${client.nom }"/>" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['nomClient'] }</span>
                    <br />
                    
                    <label for="prenomClient">Prénom </label>
                    <input type="text" id="prenomClient" name="prenomClient" value="<c:out  value="${client.prenom }"/>" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['prenomClient'] }</span>
                    <br />
    
                    <label for="adresseClient">Adresse de livraison <span class="requis">*</span></label>
                    <input type="text" id="adresseClient" name="adresseClient" value="<c:out  value="${client.adresseLivraison }"/>" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['adresseClient'] }</span>
                    <br />
    
                    <label for="telephoneClient">Numéro de téléphone <span class="requis">*</span></label>
                    <input type="text" id="telephoneClient" name="telephoneClient" value="<c:out  value="${client.numTele }"/>" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['telephoneClient'] }</span>
                    <br />
                    
                    <label for="emailClient">Adresse email</label>
                    <input type="email" id="emailClient" name="emailClient" value="<c:out  value="${client.email }"/>" size="20" maxlength="60" />
                    <span class="erreur">${form.erreurs['emailClient'] }</span>
                    <br />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
</body>
</html>