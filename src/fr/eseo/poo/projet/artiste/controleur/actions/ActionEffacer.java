package fr.eseo.poo.projet.artiste.controleur.actions;

// external imports
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

// internal imports
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionEffacer extends javax.swing.AbstractAction {

   private static final long serialVersionUID = 1L;

   // class constants
   public static final String NOM_ACTION = "Tout Effacer";

   // attributes
   private PanneauDessin panneauDessin;

   // constructor
   public ActionEffacer(PanneauDessin panneauDessin){
      super(NOM_ACTION);
      this.panneauDessin=panneauDessin;
   }

   // methodes
   /**
    * Supprime toutes les VueFormes dans la List des VueFormes
    * du PanneauDessin avec la confirmation de l'utilisateur
    * @author Simon Duperray
    * @param event
    */
   public void actionPerformed(ActionEvent event) {
      int reponse = JOptionPane.showConfirmDialog(this.panneauDessin, NOM_ACTION+"?",
         NOM_ACTION, JOptionPane.YES_NO_OPTION);
      if(reponse==0){
         this.panneauDessin.getVueFormes().clear();
         this.panneauDessin.repaint();
      }
   }
}