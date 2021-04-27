package fr.eseo.poo.projet.artiste.controleur.actions;

// external imports
import java.awt.event.ActionEvent;

// internal imports
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirRemplissage extends javax.swing.AbstractAction {

   private static final long serialVersionUID = 1L;

   // class constants
   public static final String NOM_ACTION = "Couleur Remplissage";

   // attributes
   private PanneauDessin panneauDessin;

   // constructor
   public ActionChoisirRemplissage(PanneauDessin panneauDessin){
      super(NOM_ACTION);
      this.panneauDessin = panneauDessin;
   }

   // methodes
   /**
    * Met à jour le mode de remplissage courant du PanneauDessin
    * @author Simon Duperray
    * @param event
    */
   public void actionPerformed(ActionEvent event){
      if(event.getActionCommand()==NOM_ACTION && !this.panneauDessin.getModeRemplissage()){
         this.panneauDessin.setModeRemplissage(true);
      } else if(event.getActionCommand()==NOM_ACTION && this.panneauDessin.getModeRemplissage()){
         this.panneauDessin.setModeRemplissage(false);
      }
   }
}