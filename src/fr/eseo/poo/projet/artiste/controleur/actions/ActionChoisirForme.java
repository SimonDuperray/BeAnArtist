package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirForme extends javax.swing.AbstractAction {

   // constantes de classe
   public static final String NOM_ACTION_LIGNE = "Ligne";
   public static final String NOM_ACTION_ELLIPSE = "Ellipse";
   public static final String NOM_ACTION_CERCLE = "Cercle";

   // attributs
   private PanneauDessin panneauDessin;
   private PanneauBarreOutils panneauBarreOutils;

   // constructeur
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
      }
   }

}
