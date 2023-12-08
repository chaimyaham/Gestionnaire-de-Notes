/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondesnotes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kawtarmahy
 */
public class Etudiant {

    private String cin;
    private String nom;
    private HashMap<String, ArrayList<Double>> listeDesNotes;

    public Etudiant(String cin, String nom , HashMap<String, ArrayList<Double>> listeDesNotes) {
        this.cin = cin;
        this.nom = nom;
        this.listeDesNotes = listeDesNotes;
        
    }

    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public HashMap<String, ArrayList<Double>> getListeDesNotes() {

        return this.listeDesNotes;

    }

    public void setListeDesNotes(HashMap<String, ArrayList<Double>> liste) {
        this.listeDesNotes = liste;

    }

    public void ajouternoteParMatiere(String matiere, ArrayList<Double> notes) {
//      check if the matiere existe on the array list

        if (this.listeDesNotes.containsKey(matiere)) {
            ArrayList<Double> listeNotes = listeDesNotes.get(matiere);
            listeNotes.addAll(notes);
        } else {
            ArrayList<Double> nouvelleListe = new ArrayList<>();
            nouvelleListe.addAll(notes);
            listeDesNotes.put(matiere, nouvelleListe);
        }

    }

    public void afficherLaListeDesnotes() {
        System.out.println("Cin  ::" + this.getCin());

        System.out.println("Nom  ::" + this.getNom());
        for (String matiere : this.listeDesNotes.keySet()) {
    
            System.out.print("Nom de la matiere " + matiere + " Notes : ");
            ArrayList<Double> listeNotes = listeDesNotes.get(matiere);

            for (Double note : listeNotes) {
                System.out.print(note + " || ");
            }

            System.out.println();

        }
        System.out.println("===============================");

    }

    public Double caluclerLaMoyenneParMatiere(String matiere) {

        if (this.listeDesNotes.containsKey(matiere)) {
            ArrayList<Double> listeNotes = listeDesNotes.get(matiere);
            if (listeNotes.isEmpty()) {
                System.out.println("il n ya pas de notes inserer pour cette matiere");
                return null;
            } else {
                double sum = 0, avg;
                for (int i = 0; i < listeNotes.size(); i++) {
                    sum += listeNotes.get(i);

                }
                avg = sum / listeNotes.size();
                System.out.println("la moyenne de la matiere " + matiere + " :est: " + avg);
                return avg;
            }

        }
        System.out.println("matiere no inserer");
        return null;

    }
    
  


}
