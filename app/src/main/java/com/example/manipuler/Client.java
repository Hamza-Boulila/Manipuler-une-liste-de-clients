package com.example.manipuler;

public class Client {
    private String Nom;
    private String Prenom;
    private String Sexe;
    public Client(String nom, String prenom, String sexe) {
        Nom = nom;
        Prenom = prenom;
        Sexe = sexe;
    }
    public Client() {
        Nom = "";
        Prenom = "";
        Sexe = "";
    }
    public String getNom() {
        return Nom;
    }
    public void setNom(String nom) {
        Nom = nom;
    }
    public String getPrenom() {
        return Prenom;
    }
    public void setPrenom(String prenom) {
        Prenom = prenom;
    }
    public String getSexe() {
        return Sexe;
    }
    public void setSexe(String sexe) {
        Sexe = sexe;
    }
    @Override
    public String toString() {
        return(getNom()+" "+ getPrenom()+" "+getSexe());
    }
}
