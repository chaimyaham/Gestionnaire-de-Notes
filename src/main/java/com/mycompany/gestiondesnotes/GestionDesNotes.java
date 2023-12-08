/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gestiondesnotes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author kawtarmahy
 */
public class GestionDesNotes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GererlesEtudiants ge = new GererlesEtudiants();

        manage:
        while (true) {

            System.out.println("Choisis :\n 1 - afficher la liste des etudiant. \n 2-ajouter un nouveau etudiant. \n 3-ajouterles notes a un etudiant existant. \n 4-calculer la moyenne d'un etudiant.\n 5- calculer la moyenne par matiere d'un etudiant \n 6-rechercher un etudiant .\n 7-supprimer un etudiant . \n 8-exit ");

            int choix = sc.nextInt();
            String cin;
            Etudiant etudiant;
            switch (choix) {

                case 1:

                    ge.afficherLalisteDesEtudiant();

                    break;
                case 2:
                    System.out.println("Entrer le cin de L'etudiant");
                    cin = sc.next();

                    if (ge.rechercheUnEtudiant(cin) != null) {

                        System.out.println("etudiant already exist");

                    } else {

                        System.out.println("entrer le nom");
                        String nom = sc.next();
                        System.out.println("combien de matiere tu veux inserer");
                        int nb = sc.nextInt();
                        HashMap<String, ArrayList<Double>> listeDesNotes = new HashMap<>();
                        for (int i = 0; i < nb; i++) {

                            System.out.println("inserer le nom de la matiere numero " + (i+1));
                            String nomMatiere = sc.next();
                            System.out.println("Combien de notes tu veux inserer dans cette matiere");
                            int nbNote = sc.nextInt();
                            ArrayList<Double> listeDeNote = new ArrayList();
                            for (int j = 0; j < nbNote; j++) {

                                System.out.println("insere la " + (j+1) + "e note");

                                double note = sc.nextDouble();
                                if (note >= 0 && note <= 20) {
                                    listeDeNote.add(note);
                                } else {
                                    System.out.println("Please entrer une note valid entre 0 et 20");
                                    j -= 1;
                                }

                            }
                            listeDesNotes.put(nomMatiere, listeDeNote);

                        }

                        etudiant = new Etudiant(cin, nom, listeDesNotes);
                        ge.ajouterEtudiant(etudiant);
                        System.out.println("l etudiant est ajouter avec succes");

                    }

                    break;
                case 3:

                    System.out.println("Entrer  le cin de l 'etudiant ");
                    cin = sc.next();
                    if (ge.rechercheUnEtudiant(cin) == null) {

                        System.out.println("etudiant does not exist");

                    } else {
                        etudiant = ge.rechercheUnEtudiant(cin);

                        System.out.println("combien de matiere tu veux ajouter");
                        int nbn = sc.nextInt();

                        for (int i = 0; i < nbn; i++) {
                            System.out.println("inserer le nom de la matiere numero " + (i+1));
                            String nomMatiere = sc.next();
                                System.out.println("saisis le nombre de note que tu veux ajouter");
                                ArrayList<Double> newlisteDeNote = new ArrayList();
                                int nbm = sc.nextInt();

                                for (int j = 0; j < nbm; j++) {

                                    System.out.println("inserer la " + (j+1) + " e note");

                                    double note = sc.nextDouble();
                                    if (note >= 0 && note <= 20) {
                                        newlisteDeNote.add(note);
                                    } else {
                                        System.out.println("Please entrer une note valid entre 0 et 20");
                                        j -= 1;
                                    }

                                }
                                etudiant.ajouternoteParMatiere(nomMatiere, newlisteDeNote);

                            

                        }

                    }

                    break;
                case 4:
                    
                    System.out.println("saisis le cin de l etudiant que tu veux calculer sa moyenne");
                    cin=sc.next();
                    ge.calculerMoyenneGeneral(cin);
                    
                    
                    
                    break;
                case 5:
                    
                    System.out.println("Entrer le cin de l 'etudiant que tu veux calculer sa moyenne");
                    cin=sc.next();
                    etudiant=ge.rechercheUnEtudiant(cin);
                    System.out.println("Entrer le nom de la matiere que tu veux calculer sa moyenne");
                    String matiere=sc.next();
                    etudiant.caluclerLaMoyenneParMatiere(matiere);
                    
                    
                    break;
                case 6:
                    
                    System.out.println("Entrer le cin de l'etudiant");
                    cin=sc.next();
                    etudiant=ge.rechercheUnEtudiant(cin);
                    etudiant.afficherLaListeDesnotes();
                    break;
                    
                 case 7:
                      System.out.println("Entrer le cin de l'etudiant  que  tu veux supprimer");
                      cin=sc.next();
                      ge.supprimerEtudiant(cin);
                    break;
                case 8:
                    break manage;
            }

        }

    }
}
