package com.ecom.beans;

public class Client {
 private String idClient;
 private String nom;
 private String prenom;
 private String email;
 private String adresseLivraison;
 private String numTele;
 
 public Client(String idClient, String nom, String prenom, String email, String adresseLivraison, String numTele) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresseLivraison = adresseLivraison;
		this.numTele = numTele;
	}


public Client() {
	super();
}


public String getIdClient() {
	return idClient;
}
public void setIdClient(String idClient) {
	this.idClient = idClient;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAdresseLivraison() {
	return adresseLivraison;
}
public void setAdresseLivraison(String adresseLivraison) {
	this.adresseLivraison = adresseLivraison;
}
public String getNumTele() {
	return numTele;
}
public void setNumTele(String numTele) {
	this.numTele = numTele;
}
 
 
 
}
