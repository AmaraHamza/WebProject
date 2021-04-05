package com.ecom.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.ecom.beans.Client;
import com.ecom.beans.Commande;

public class CommandeForm {

    // Client Attributs
    public static final String  ATT_NOM_CLIENT         = "nomClient";
    public static final String  ATT_PRENOM_CLIENT      = "prenomClient";
    public static final String  ATT_ADR_LIV            = "adresseClient";
    public static final String  ATT_EMAIL_CLIENT       = "emailClient";
    public static final String  ATT_TELE_CLIENT        = "telephoneClient";

    // Cmd Attributs
    public static final String  ATT_MONTANT_CMD        = "montantCommande";
    public static final String  ATT_MODE_PAIMENT_CMD   = "modePaiementCommande";
    public static final String  ATT_STATUT_PAIMENT_CMD = "statutPaiementCommande";
    public static final String  ATT_MODE_LIV_CMD       = "modeLivraisonCommande";
    public static final String  ATT_STATUT_LIV_CMD     = "statutLivraisonCommande";
    public static final String  ATT_DATE_CMD           = "DateCmd";

    // Utilities
    public static final String  FORMAT_DATE            = "dd/MM/yyyy HH:mm:ss";
    private String              resultat;
    private Map<String, String> erreurs                = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    public Commande creerCommande( HttpServletRequest request ) {
        Commande cmd = new Commande();
        Client client = new Client();
        // Récuperation du client
        String nom = getValeurChamp( request, ATT_NOM_CLIENT );
        String prenom = getValeurChamp( request, ATT_PRENOM_CLIENT );
        String adresseLiv = getValeurChamp( request, ATT_ADR_LIV );
        String email = getValeurChamp( request, ATT_EMAIL_CLIENT );
        String numTel = getValeurChamp( request, ATT_TELE_CLIENT );

        // Récuperation de la commande
        String montant = getValeurChamp( request, ATT_MONTANT_CMD );
        String modePaiement = getValeurChamp( request, ATT_MODE_PAIMENT_CMD );
        String statutPaiement = getValeurChamp( request, ATT_STATUT_PAIMENT_CMD );
        String modeLiv = getValeurChamp( request, ATT_MODE_LIV_CMD );
        String statutLiv = getValeurChamp( request, ATT_STATUT_LIV_CMD );

        /* Récupération de la date courante */
        DateTime dt = new DateTime();
        /* Conversion de la date en String selon le format choisi */
        DateTimeFormatter formatter = DateTimeFormat.forPattern( FORMAT_DATE );
        String date = dt.toString( formatter );

        // Validation des champs, Revelation des erreurs, stockage des données
        // dans le bean Client
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( ATT_NOM_CLIENT, e.getMessage() );
        }
        client.setNom( nom );

        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            setErreur( ATT_PRENOM_CLIENT, e.getMessage() );
        }
        client.setPrenom( prenom );

        try {
            validationAdresse( adresseLiv );
        } catch ( Exception e ) {
            setErreur( ATT_ADR_LIV, e.getMessage() );
        }
        client.setAdresseLivraison( adresseLiv );

        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( ATT_EMAIL_CLIENT, e.getMessage() );
        }
        client.setEmail( email );

        try {
            validationNumTele( numTel );
        } catch ( Exception e ) {
            setErreur( ATT_TELE_CLIENT, e.getMessage() );
        }
        client.setNumTele( numTel );

        // Enregistrer l'objet client dans l'objet commande
        cmd.setClient( client );

        // Validation des champs, Revelation des erreurs, stockage des données
        // dans le bean Commande
        try {
            validationMontant( montant );
        } catch ( Exception e ) {
            setErreur( ATT_MONTANT_CMD, e.getMessage() );
        }
        cmd.setMontant( montant );

        try {
            validationModePaiement( modePaiement );
        } catch ( Exception e ) {
            setErreur( ATT_MODE_PAIMENT_CMD, e.getMessage() );
        }
        cmd.setModePaiement( modePaiement );

        try {
            validationStatutPaiement( statutPaiement );
        } catch ( Exception e ) {
            setErreur( ATT_STATUT_PAIMENT_CMD, e.getMessage() );
        }
        cmd.setStatutPaiement( statutPaiement );

        try {
            validationModeLivraison( modeLiv );
        } catch ( Exception e ) {
            setErreur( ATT_MODE_LIV_CMD, e.getMessage() );
        }
        cmd.setModeLivraison( modeLiv );

        try {
            validationStatutLivraison( statutLiv );
        } catch ( Exception e ) {
            setErreur( statutLiv, e.getMessage() );
        }
        cmd.setStatutLivraison( statutLiv );
        cmd.setDateCmd( date );

        if ( erreurs.isEmpty() ) {
            resultat = "Création avec succés";
        } else {
            resultat = "Echec de création";
        }

        return cmd;
    }

    /**
     * Valide l'adresse mail saisie.
     */
    private void validationEmail( String email ) throws Exception {
        if ( email != null && email.trim().length() != 0 ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    /**
     * Validation le nom de client saisi.
     */
    private void validationNom( String nom ) throws Exception {
        if ( nom == null || nom.trim().length() < 2 ) {
            throw new Exception( "Le nom de client doit contenir au moins 2 caractères." );
        }
    }

    /**
     * Validation le prenom de client saisi.
     */
    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom != null && prenom.trim().length() < 2 ) {
            throw new Exception( "Le prenom de client doit contenir au moins 2 caractères." );
        }
    }

    /**
     * Validation de l'adresse de client saisi.
     */
    private void validationAdresse( String adresse ) throws Exception {
        if ( adresse != null && adresse.trim().length() < 10 ) {
            throw new Exception( "L'adresse de client doit contenir au moins 10 caractères." );
        }
    }

    /**
     * Validation de numéro de téléphone de client saisi.
     */
    private void validationNumTele( String numTele ) throws Exception {
        if ( numTele != null && numTele.trim().length() < 4 ) {
            throw new Exception( "Le numéro de téléphone de client doit contenir au moins 4 chiffres." );
        }

        if ( !numTele.matches( "[0-9]+" ) ) {
            throw new Exception( "Le numéro de téléphone doit uniquement contenir des chiffres." );
        }
    }

    /**
     * Validation de mode de paiement saisi.
     */
    private void validationModePaiement( String modePaiement ) throws Exception {
        if ( modePaiement != null && modePaiement.trim().length() < 2 ) {
            throw new Exception( "Le mode de paiement doit contenir au moins 2 caractères." );
        }
    }

    /**
     * Validation du statut de paiement saisi.
     */
    private void validationStatutPaiement( String statutPaiement ) throws Exception {
        if ( statutPaiement != null && statutPaiement.trim().length() < 2 ) {
            throw new Exception( "Le statut de paiement doit contenir au moins 2 caractères." );
        }
    }

    /**
     * Validation du mode de livraison saisi.
     */
    private void validationModeLivraison( String modeLivraison ) throws Exception {
        if ( modeLivraison != null && modeLivraison.trim().length() < 2 ) {
            throw new Exception( "Le mode de livraison doit contenir au moins 2 caractères." );
        }
    }

    /**
     * Validation du statut de livraison saisi.
     */
    private void validationStatutLivraison( String statutLivraison ) throws Exception {
        if ( statutLivraison != null && statutLivraison.trim().length() < 2 ) {
            throw new Exception( "Le statut de livraison doit contenir au moins 2 caractères." );
        }
    }

    /**
     * Validation du montant saisi.
     */
    private void validationMontant( String montant ) throws Exception {
        if ( montant == null ) {
            throw new Exception( "Veuillez renseigner le montant de la commande." );
        } else {
            try {
                Double.parseDouble( montant );
            } catch ( NumberFormatException nfe ) {
                throw new Exception( "Le montant de la commande doit être un décimal." );
            }
        }
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}
