package fr.eseo.poo.projet.artiste.controleur.actions;

// external imports
import java.awt.event.ActionEvent;

// internal imports
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirRemplissage extends javax.swing.AbstractAction {

   // class constants
   public static final String NOM_ACTION = "Couleur Remplissage";
   private static final long serialVersionUID = 1L;

   // attributes
   private PanneauDessin panneauDessin;

   // constructor
   public ActionChoisirRemplissage(PanneauDessin panneauDessin){
      super(NOM_ACTION);
      this.panneauDessin = panneauDessin;
   }

   // methodes
   /**
    * @author SimonDuperray
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
