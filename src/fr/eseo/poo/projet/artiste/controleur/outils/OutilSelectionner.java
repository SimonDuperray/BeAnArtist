package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import java.awt.event.MouseEvent;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import javax.swing.JOptionPane;

public class OutilSelectionner extends fr.eseo.poo.projet.artiste.controleur.outils.Outil {
   // attributs
   private Forme formeSelectionnee;

   // constructeur
   public OutilSelectionner(){}

   // methodes
   public void mouseClicked(MouseEvent event){
      for(int cpt=1; cpt<this.getPanneauDessin().getVueFormes().size(); cpt++){
         if(this.getPanneauDessin().getVueFormes().get(cpt).getForme().contient(
            new Coordonnees(event.getX(), event.getY())
         )) {
            this.formeSelectionnee = this.getPanneauDessin().getVueFormes().get(cpt).getForme();
         }
      }
      JOptionPane.showConfirmDialog(this.getPanneauDessin(), this.formeSelectionnee,
         ActionSelectionner.NOM_ACTION, JOptionPane.INFORMATION_MESSAGE
      );
   }
}