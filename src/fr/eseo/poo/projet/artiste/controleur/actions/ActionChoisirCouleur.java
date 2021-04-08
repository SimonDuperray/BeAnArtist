package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.JColorChooser;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;
import java.awt.Color;

public class ActionChoisirCouleur extends javax.swing.AbstractAction{

	private static final long serialVersionUID = 1L;

// constantes de classe
   public static final String NOM_ACTION = "Choisir couleur";

   // attributs
   private PanneauDessin panneauDessin;

   // constructeur
   public ActionChoisirCouleur(PanneauDessin panneauDessin){
      super(NOM_ACTION);
      this.panneauDessin=panneauDessin;
   }

   public void actionPerformed(ActionEvent e) {
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