package com.ecom.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ecom.beans.Client;

public class ClientForm {
    public static final String  ATT_NOM_CLIENT    = "nomClient";
    public static final String  ATT_PRENOM_CLIENT = "prenomClient";
    public static final String  ATT_ADR_LIV       = "adresseClient";
    public static final String  ATT_EMAIL_CLIENT  = "emailClient";
    public static final String  ATT_TELE_CLIENT   = "telephoneClient";

    private String              resultat;
    private Map<String, String> erreurs           = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    public Client creerClient( HttpServletRequest request ) {

        Client client = new Client();
        String nom = getValeurChamp( request, ATT_NOM_CLIENT );
        String prenom = getValeurChamp( request, ATT_PRENOM_CLIENT );
        String adresseLiv = getValeurChamp( request, ATT_ADR_LIV );
        String email = getValeurChamp( request, ATT_EMAIL_CLIENT );
        String numTel = getValeurChamp( request, ATT_TELE_CLIENT );

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

        if ( erreurs.isEmpty() ) {
            resultat = "Création avec succés";
        } else {
            resultat = "Echec de création";
        }

        return client;
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
