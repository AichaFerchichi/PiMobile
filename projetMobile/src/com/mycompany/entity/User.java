/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.util.Date;

/**
 *
 * @author BEN MLAH
 */
public class User
{
        public static Integer idUserConnected;
        private int id;
        private String username;
        private String username_canonical;
        private String email;
        private String email_canonical;
        private Boolean enabled;
        private String salt;
        private String password;
        private Date last_login;
        private String confirmation_token;

    public static Integer getIdUserConnected() {
        return idUserConnected;
    }

    public static void setIdUserConnected(Integer idUserConnected) {
        User.idUserConnected = idUserConnected;
    }

    public User(int id) {
        this.id = id;
    }
        private Date password_requested_at;
        private String roles;
        private String nom;
        private String prenom;
        private Date date_de_naissance;
        private String sexe;
        private int telephone;
        private long randonnecategorie;
        private String ville;
        private String path;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(int id, String username, String username_canonical, String email, String email_canonical, Boolean enabled, String salt, String password, Date last_login, String confirmation_token, Date password_requested_at, String roles, String nom, String prenom, Date date_de_naissance, String sexe, int telephone, long randonnecategorie, String ville, String path) {
        this.id = id;
        this.username = username;
        this.username_canonical = username_canonical;
        this.email = email;
        this.email_canonical = email_canonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.last_login = last_login;
        this.confirmation_token = confirmation_token;
        this.password_requested_at = password_requested_at;
        this.roles = roles;
        this.nom = nom;
        this.prenom = prenom;
        this.date_de_naissance = date_de_naissance;
        this.sexe = sexe;
        this.telephone = telephone;
        this.randonnecategorie = randonnecategorie;
        this.ville = ville;
        this.path = path;
    }

    public User() {
    }

    public User(String username) 
    {
           this.username=username   ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

    public Date getPassword_requested_at() {
        return password_requested_at;
    }

    public void setPassword_requested_at(Date password_requested_at) {
        this.password_requested_at = password_requested_at;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
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

    public Date getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(Date date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public long getRandonnecategorie() {
        return randonnecategorie;
    }

    public void setRandonnecategorie(long randonnecategorie) {
        this.randonnecategorie = randonnecategorie;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", username_canonical=" + username_canonical + ", email=" + email + ", email_canonical=" + email_canonical + ", enabled=" + enabled + ", salt=" + salt + ", password=" + password + ", last_login=" + last_login + ", confirmation_token=" + confirmation_token + ", password_requested_at=" + password_requested_at + ", roles=" + roles + ", nom=" + nom + ", prenom=" + prenom + ", date_de_naissance=" + date_de_naissance + ", sexe=" + sexe + ", telephone=" + telephone + ", randonnecategorie=" + randonnecategorie + ", ville=" + ville + ", path=" + path + '}';
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

  
        
    
}
