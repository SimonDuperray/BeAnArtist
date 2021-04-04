package fr.eseo.poo.projet.artiste.controleur.actions;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilSelectionner;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import java.awt.event.ActionEvent;

public class ActionSelectionner extends javax.swing.AbstractAction {

   private static final long serialVersionUID = 1L;

   // constantes de classe
   public static final String NOM_ACTION = "Selectionner";
   
   // attributs
   private PanneauDessin panneauDessin;

   // constructeur
   public ActionSelectionner(PanneauDessin panneauDessin) {
      super(NOM_ACTION);
      this.panneauDessin=panneauDessin;
   }

   // methodes
   public void actionPerformed(ActionEvent event){
      if(event.getActionCommand()==NOM_ACTION){
         this.panneauDessin.associerOutil(
            new OutilSelectionner()
         );
      }
   }
}
