/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondesnotes;

import java.util.ArrayList;
import java.util.HashMap;


public class GererlesEtudiants implements gestionDesEtudiant  {
        private ArrayList<Etudiant> listeEtudiant;
    
    public GererlesEtudiants(){
        this.listeEtudiant= new ArrayList<>();
    }
    
    
    @Override
    public void afficherLalisteDesEtudiant() {
        
        if(listeEtudiant.isEmpty()){
            System.out.println("la liste des etudiant est vide");
        }else{
           
            for(Etudiant etudiant : listeEtudiant){
                etudiant.afficherLaListeDesnotes();
            }
        }

    }
    

    @Override
    public void ajouterEtudiant(Etudiant etudiant) {
        
        
        if(listeEtudiant.contains(etudiant)){
             System.out.println("etudiant already exist");
   
        }else{
            listeEtudiant.add(etudiant);
        }   

    }

    @Override
    public Etudiant rechercheUnEtudiant(String cin) {
        for(Etudiant etudiant : listeEtudiant){
            if(etudiant.getCin().equals(cin)){
              return etudiant;
              
                
            }
            
        }
        System.out.println("Etudiant not found");
        return null;
        
        
    }

    @Override
    public void supprimerEtudiant(String cin) {
        
        if(rechercheUnEtudiant(cin)==null){
            System.out.println("cet etudiant n'exist pas");
        }else{
            
            listeEtudiant.remove(rechercheUnEtudiant(cin));
            System.out.println("etudiant supprimer avec success");
        }
       
    }

  

    @Override
    public Double calculerMoyenneGeneral(String cin) {
     Etudiant etudiant;
     double avg = 1;
     etudiant=this.rechercheUnEtudiant(cin);
        ArrayList<Double> listeDesMoyenneDesMatiere = new ArrayList();
       double sum=0;

        for (HashMap.Entry<String, ArrayList<Double>> entry : etudiant.getListeDesNotes().entrySet()) {
            String matiere=entry.getKey();
          Double moyenParMatiere=etudiant.caluclerLaMoyenneParMatiere(matiere);
          listeDesMoyenneDesMatiere.add(moyenParMatiere) ;
          sum+=moyenParMatiere;
        }
        avg=sum/listeDesMoyenneDesMatiere.size();

        System.out.println("la moyenne general est " + avg);
        return avg;
     
    }



  
    
    
    
}
