package fr.eseo.poo.projet.artiste.controleur.actions;

// external imports
import java.awt.event.ActionEvent;
import javax.swing.JColorChooser;
import java.awt.Color;

// internal imports
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirCouleur extends javax.swing.AbstractAction{

	private static final long serialVersionUID = 1L;

   // class constants
   public static final String NOM_ACTION = "Choisir couleur";

   // attributes
   private PanneauDessin panneauDessin;

   // constructor
   /**
    * @author SimonDuperray
    * @param panneauDessin
    */
   public ActionChoisirCouleur(PanneauDessin panneauDessin){
      super(NOM_ACTION);
      this.panneauDessin=panneauDessin;
   }

   /**
    * @author SimonDuperray
    * @param event
    */
   public void actionPerformed(ActionEvent event) {
      Color couleur = JColorChooser.showDialog(
         this.panneauDessin,
         NOM_ACTION,
         this.panneauDessin.getCouleurCourante()
      );
      if(couleur!=null){
         this.panneauDessin.setCouleurCourante(couleur);
      }
   }
}