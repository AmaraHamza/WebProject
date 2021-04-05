package com.ecom.beans;

public class Commande {
    private Client client;
    private String idCmd;
    private String dateCmd;
    private String montant;
    private String modePaiement;
    private String statutPaiement;
    private String modeLivraison;
    private String statutLivraison;

    public Commande() {
        super();
    }

    public Commande( Client client, String idCmd, String dateCmd, String montant, String modePaiment,
            String statutPaiment, String modeLivraison, String statutLivraison ) {
        super();
        this.client = client;
        this.idCmd = idCmd;
        this.dateCmd = dateCmd;
        this.montant = montant;
        this.modePaiement = modePaiment;
        this.statutPaiement = statutPaiment;
        this.modeLivraison = modeLivraison;
        this.statutLivraison = statutLivraison;
    }

    public Client getClient() {
        return client;
    }

    public void setClient( Client client ) {
        this.client = client;
    }

    public String getIdCmd() {
        return idCmd;
    }

    public void setIdCmd( String idCmd ) {
        this.idCmd = idCmd;
    }

    public String getDateCmd() {
        return dateCmd;
    }

    public void setDateCmd( String dt ) {
        this.dateCmd = dt;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant( String montant ) {
        this.montant = montant;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement( String modePaiement ) {
        this.modePaiement = modePaiement;
    }

    public String getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement( String statutPaiement ) {
        this.statutPaiement = statutPaiement;
    }

    public String getModeLivraison() {
        return modeLivraison;
    }

    public void setModeLivraison( String modeLivraison ) {
        this.modeLivraison = modeLivraison;
    }

    public String getStatutLivraison() {
        return statutLivraison;
    }

    public void setStatutLivraison( String statutLivraison ) {
        this.statutLivraison = statutLivraison;
    }

}
