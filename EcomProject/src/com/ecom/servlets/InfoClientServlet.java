package com.ecom.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecom.beans.Client;
import com.ecom.forms.ClientForm;

/**
 * Servlet implementation class InfoClientServlet
 */
// @WebServlet("/InfoClientServlet")
public class InfoClientServlet extends HttpServlet {
    private static final long  serialVersionUID = 1L;
    public static final String ATT_USER         = "client";
    public static final String ATT_FORM         = "form";

    public static final String VUE_SUCCES       = "/WEB-INF/ResultatPage.jsp";
    public static final String VUE_FORM         = "/WEB-INF/InfoClient.jsp";

    public InfoClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        request.getRequestDispatcher( VUE_FORM ).forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        ClientForm form = new ClientForm();
        /*
         * Appel au traitement et à la validation de la requête, et récupération
         * du bean en résultant
         */
        Client client = form.creerClient( request );

        // Stockage du formulaire et du bean dans l'objet request
        request.setAttribute( ATT_USER, client );
        request.setAttribute( ATT_FORM, form );

        if ( form.getResultat() == "Création avec succés" ) {
            request.getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            request.getRequestDispatcher( VUE_FORM ).forward( request, response );
        }

    }

}
