package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionEffacer extends javax.swing.AbstractAction {

   private static final long serialVersionUID = 1L;

   // constantes de classe
   public static final String NOM_ACTION = "Tout Effacer";

   // attributs
   private PanneauDessin panneauDessin;

   // constructeur
   public ActionEffacer(PanneauDessin panneauDessin){
      super(NOM_ACTION);
      this.panneauDessin=panneauDessin;
   }

   public void actionPerformed(ActionEvent event) {
      int reponse = JOptionPane.showConfirmDialog(this.panneauDessin, NOM_ACTION+"?",
         NOM_ACTION, JOptionPane.YES_NO_OPTION);
      if(reponse==0){
         this.panneauDessin.getVueFormes().clear();
         this.panneauDessin.repaint();
      }
   }
}
