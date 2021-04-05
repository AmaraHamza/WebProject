package com.ecom.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecom.beans.Client;
import com.ecom.beans.Commande;
import com.ecom.forms.CommandeForm;

//@WebServlet("/InfoCmdServlet")
public class InfoCmdServlet extends HttpServlet {

    private static final long  serialVersionUID = 1L;
    public static final String ATT_CMD          = "cmd";
    public static final String ATT_CLIENT       = "client";
    public static final String ATT_FORM         = "form";
    public static final String VUE_SUCCES       = "/WEB-INF/ResultatPageCmd.jsp";
    public static final String VUE_FORM         = "/WEB-INF/InfoCmd.jsp";

    public InfoCmdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        request.getRequestDispatcher( VUE_FORM ).forward( request, response );

    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        CommandeForm form = new CommandeForm();
        /*
         * Appel au traitement et à la validation de la requête, et récupération
         * du bean en résultant
         */
        Commande cmd = form.creerCommande( request );
        Client client = cmd.getClient();

        // Stockage du formulaire et du bean dans l'objet request
        request.setAttribute( ATT_CLIENT, client );
        request.setAttribute( ATT_CMD, cmd );
        request.setAttribute( ATT_FORM, form );

        if ( form.getResultat() == "Création avec succés" ) {
            request.getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            request.getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }
}
