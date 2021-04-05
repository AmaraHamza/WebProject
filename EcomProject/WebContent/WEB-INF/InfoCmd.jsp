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
            <form method="post" action="creationCommande">
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
                <fieldset>
                    <legend>Informations commande</legend>
                    
                    <label for="dateCommande">Date <span class="requis">*</span></label>
                    <input type="text" id="dateCommande" name="dateCommande" value="<c:out  value="${cmd.dateCmd }"/>" size="20" maxlength="20" disabled />
                    <br />
                    
                    <label for="montantCommande">Montant <span class="requis">*</span></label>
                    <input type="text" id="montantCommande" name="montantCommande" value="<c:out  value="${cmd.montant }"/>" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['montantCommande'] }</span>
                    <br />
                    
                    <label for="modePaiementCommande">Mode de paiement <span class="requis">*</span></label>
                    <input type="text" id="modePaiementCommande" name="modePaiementCommande" value="<c:out  value="${cmd.modePaiement }"/>" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['modePaiementCommande'] }</span>
                    <br />
                    
                    <label for="statutPaiementCommande">Statut du paiement</label>
                    <input type="text" id="statutPaiementCommande" name="statutPaiementCommande" value="<c:out  value="${cmd.statutPaiement }"/>" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['statutPaiementCommande'] }</span>
                    <br />
                    
                    <label for="modeLivraisonCommande">Mode de livraison <span class="requis">*</span></label>
                    <input type="text" id="modeLivraisonCommande" name="modeLivraisonCommande" value="<c:out  value="${cmd.modeLivraison }"/>" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['modeLivraisonCommande'] }</span>
                    <br />
                    
                    <label for="statutLivraisonCommande">Statut de la livraison</label>
                    <input type="text" id="statutLivraisonCommande" name="statutLivraisonCommande" value="<c:out  value="${cmd.statutLivraison }"/>" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['statutLivraisonCommande'] }</span>
                    <br />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
</body>
</html>