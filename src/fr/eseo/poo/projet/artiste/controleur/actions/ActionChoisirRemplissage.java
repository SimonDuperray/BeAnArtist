package fr.eseo.poo.projet.artiste.controleur.actions;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import java.awt.event.ActionEvent;

public class ActionChoisirRemplissage extends javax.swing.AbstractAction {

   // constantes de classe
   public static final String NOM_ACTION = "Choisir Couleur Remplissage";
   private static final long serialVersionUID = 1L;

   // attributs
   private PanneauDessin panneauDessin;

   // constructeur
   public ActionChoisirRemplissage(PanneauDessin panneauDessin){
      super(NOM_ACTION);
      this.panneauDessin = panneauDessin;
   }

   // methodes
   public void actionPerformed(ActionEvent event){
      if(event.getActionCommand()==NOM_ACTION && !this.panneauDessin.getModeRemplissage()){
         this.panneauDessin.setModeRemplissage(true);
      } else if(event.getActionCommand()==NOM_ACTION && this.panneauDessin.getModeRemplissage()){
         this.panneauDessin.setModeRemplissage(false);
      }
   }
}
