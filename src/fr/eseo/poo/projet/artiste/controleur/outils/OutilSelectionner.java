package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import java.awt.event.MouseEvent;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import javax.swing.JOptionPane;

public class OutilSelectionner extends fr.eseo.poo.projet.artiste.controleur.outils.Outil {
   // attributs
   private Forme forme;

   // constructeur
   public OutilSelectionner(){}

   // methodes
   public void mouseClicked(MouseEvent event){
      for(int i=1; i<this.getPanneauDessin().getVueFormes().size(); i++){
         if(this.getPanneauDessin().getVueFormes().get(i).getForme().contient(
            new Coordonnees(
               event.getX(), 
               event.getY()
            ))
         ) {
            this.forme = this.getPanneauDessin().getVueFormes().get(i).getForme();
         }
      }
      JOptionPane.showMessageDialog(
         this.getPanneauDessin(),
         this.forme.toString(),
         ActionSelectionner.NOM_ACTION,
         JOptionPane.INFORMATION_MESSAGE
      );
   }
}