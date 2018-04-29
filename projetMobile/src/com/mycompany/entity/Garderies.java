/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

/**
 *
 * @author MacBook
 */
public class Garderies {
    private int idGarderie;
    private String nom;
    
    private String Email;
    private String adresse;
    private String description;
    private String image;
    private String objectif;
    private String proEducatif;
    private int num_tel;
    private int nb_place_dispo;
   private int nbEnfant;

    public Garderies(int idGarderie, String nom, String Email, String adresse, String description, String image, String objectif, String proEducatif, int num_tel, int nb_place_dispo, int nbEnfant) {
        this.idGarderie = idGarderie;
        this.nom = nom;
        this.Email = Email;
        this.adresse = adresse;
        this.description = description;
        this.image = image;
        this.objectif = objectif;
        this.proEducatif = proEducatif;
        this.num_tel = num_tel;
        this.nb_place_dispo = nb_place_dispo;
        this.nbEnfant = nbEnfant;
    }

    public Garderies() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdGarderie() {
        return idGarderie;
    }

    public void setIdGarderie(int id_garderie) {
        this.idGarderie = id_garderie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getProEducatif() {
        return proEducatif;
    }

    public void setProEducatif(String proEducatif) {
        this.proEducatif = proEducatif;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public int getNb_place_dispo() {
        return nb_place_dispo;
    }

    public void setNb_place_dispo(int nb_place_dispo) {
        this.nb_place_dispo = nb_place_dispo;
    }

    public int getNbEnfant() {
        return nbEnfant;
    }

    public void setNbEnfant(int nbEnfant) {
        this.nbEnfant = nbEnfant;
    }
   
}
