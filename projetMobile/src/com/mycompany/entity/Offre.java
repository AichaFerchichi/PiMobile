/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author user
 */
public class Offre {
  private int id_offre;
  private String description;
  private String adresse;
  private String sexe;
  private String numtel;
  private String experience;
  private String lieu_baby;
  private String fumeuse;
  private String enfant;
  private String conduite;
  private String agregation;
  private String dispo;
  private String image;
  private String nfumeuse;
  private String nenfant;
  private String nconduite;
  private String nagregation;
  private int id_babysitter;
  private int age;
  private String date_publication;
  private int note;
  private int etat;
  private int nbApp;

    public Offre() {
    }

   



   


    public Offre(int id_offre, String description, String adresse, String sexe, String numtel, String experience, String lieu_baby, String fumeuse, String enfant, String conduite, String agregation, String dispo, String image, String nfumeuse, String nenfant, String nconduite, String nagregation, int id_babysitter, int age, String date_publication, int note, int etat, int nbApp) {
        this.id_offre = id_offre;
        this.description = description;
        this.adresse = adresse;
        this.sexe = sexe;
        this.numtel = numtel;
        this.experience = experience;
        this.lieu_baby = lieu_baby;
        this.fumeuse = fumeuse;
        this.enfant = enfant;
        this.conduite = conduite;
        this.agregation = agregation;
        this.dispo = dispo;
        this.image = image;
        this.nfumeuse = nfumeuse;
        this.nenfant = nenfant;
        this.nconduite = nconduite;
        this.nagregation = nagregation;
        this.id_babysitter = id_babysitter;
        this.age = age;
        this.date_publication = date_publication;
        this.note = note;
        this.etat = etat;
        this.nbApp = nbApp;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLieu_baby() {
        return lieu_baby;
    }

    public void setLieu_baby(String lieu_baby) {
        this.lieu_baby = lieu_baby;
    }

    public String getFumeuse() {
        return fumeuse;
    }

    public void setFumeuse(String fumeuse) {
        this.fumeuse = fumeuse;
    }

    public String getEnfant() {
        return enfant;
    }

    public void setEnfant(String enfant) {
        this.enfant = enfant;
    }

    public String getConduite() {
        return conduite;
    }

    public void setConduite(String conduite) {
        this.conduite = conduite;
    }

    public String getAgregation() {
        return agregation;
    }

    public void setAgregation(String agregation) {
        this.agregation = agregation;
    }

    public String getDispo() {
        return dispo;
    }

    public void setDispo(String dispo) {
        this.dispo = dispo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNfumeuse() {
        return nfumeuse;
    }

    public void setNfumeuse(String nfumeuse) {
        this.nfumeuse = nfumeuse;
    }

    public String getNenfant() {
        return nenfant;
    }

    public void setNenfant(String nenfant) {
        this.nenfant = nenfant;
    }

    public String getNconduite() {
        return nconduite;
    }

    public void setNconduite(String nconduite) {
        this.nconduite = nconduite;
    }

    public String getNagregation() {
        return nagregation;
    }

    public void setNagregation(String nagregation) {
        this.nagregation = nagregation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getNbApp() {
        return nbApp;
    }

    public void setNbApp(int nbApp) {
        this.nbApp = nbApp;
    }
   
    


    public int getId_offre() {
        return id_offre;
    }

    public int getId_babysitter() {
        return id_babysitter;
    }

    public String getDate_publication() {
        return date_publication;
    }

    public String getDescription() {
        return description;
    }

  

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public void setId_babysitter(int id_babysitter) {
        this.id_babysitter = id_babysitter;
    }

    public void setDate_publication(String date_publication) {
        this.date_publication = date_publication;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Offre{" + "id_offre=" + id_offre + ", description=" + description + ", adresse=" + adresse + ", sexe=" + sexe + ", numtel=" + numtel + ", experience=" + experience + ", lieu_baby=" + lieu_baby + ", fumeuse=" + fumeuse + ", enfant=" + enfant + ", conduite=" + conduite + ", agregation=" + agregation + ", dispo=" + dispo + ", image=" + image + ", nfumeuse=" + nfumeuse + ", nenfant=" + nenfant + ", nconduite=" + nconduite + ", nagregation=" + nagregation + ", id_babysitter=" + id_babysitter + ", age=" + age + ", date_publication=" + date_publication + ", note=" + note + ", etat=" + etat + ", nbApp=" + nbApp + '}';
    }


    
    
}
