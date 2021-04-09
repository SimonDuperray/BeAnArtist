package fr.eseo.poo.projet.artiste.controleur.actions;

// external imports
import java.awt.event.ActionEvent;

// internal imports
import fr.eseo.poo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEtoile;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilRectangle;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilCarre;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirForme extends javax.swing.AbstractAction {

   private static final long serialVersionUID = 1L;
   
   // class constants
   public static final String NOM_ACTION_LIGNE = "Ligne";
   public static final String NOM_ACTION_ELLIPSE = "Ellipse";
   public static final String NOM_ACTION_CERCLE = "Cercle";
   public static final String NOM_ACTION_ETOILE = "Etoile";
   public static final String NOM_ACTION_RECTANGLE = "Rectangle";
   public static final String NOM_ACTION_CARRE = "Carré";

   // attributes
   private PanneauDessin panneauDessin;
   private PanneauBarreOutils panneauBarreOutils;

   // constructor
   public ActionChoisirForme(PanneauDessin panneauDessin, PanneauBarreOutils panneauBarreOutils, String action){
      super(action);
      this.panneauDessin=panneauDessin;
      this.panneauBarreOutils=panneauBarreOutils;
   }

   // methodes
   public void actionPerformed(ActionEvent event){
      if(event.getActionCommand() == NOM_ACTION_LIGNE){
         this.panneauDessin.associerOutil(new OutilLigne());
      } else if(event.getActionCommand() == NOM_ACTION_ELLIPSE){
         this.panneauDessin.associerOutil(new OutilEllipse());
      } else if(event.getActionCommand() == NOM_ACTION_CERCLE){
         this.panneauDessin.associerOutil(new OutilCercle());
      } else if(event.getActionCommand() == NOM_ACTION_ETOILE){
         this.panneauDessin.associerOutil(new OutilEtoile(this.panneauBarreOutils));
      } else if(event.getActionCommand() == NOM_ACTION_RECTANGLE){
         this.panneauDessin.associerOutil(new OutilRectangle());
      } else if(event.getActionCommand() == NOM_ACTION_CARRE){
         this.panneauDessin.associerOutil(new OutilCarre());
      }
   }
}
