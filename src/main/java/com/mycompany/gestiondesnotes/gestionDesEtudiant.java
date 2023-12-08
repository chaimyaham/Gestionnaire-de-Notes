/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.gestiondesnotes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kawtarmahy
 */
public interface gestionDesEtudiant {
    void afficherLalisteDesEtudiant();
    void ajouterEtudiant(Etudiant etudiant);
    Etudiant rechercheUnEtudiant(String cin);
    void supprimerEtudiant(String cin);
    Double calculerMoyenneGeneral(String cin);
      

}
