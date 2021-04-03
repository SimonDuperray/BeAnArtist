package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public abstract class OutilForme extends Outil {
   // methodes
   public void mouseClicked(MouseEvent event){
      this.setFin(
         new Coordonnees(
            (double)event.getX() + Forme.LARGEUR_PAR_DEFAUT,
            (double)event.getY() + Forme.HAUTEUR_PAR_DEFAUT
         )
      );
      if(event.getClickCount()==2){
         this.getPanneauDessin().ajouterVueForme(this.creerVueForme());
         this.getPanneauDessin().repaint();
      }
   }
   public void mouseReleased(MouseEvent event){
      this.setFin(
         new Coordonnees(
            (double)event.getX(),
            (double)event.getY()
         )
      );
      if(this.getDebut().getAbscisse() != this.getFin().getAbscisse() || this.getDebut().getOrdonnee() != this.getFin().getOrdonnee()){
         this.getPanneauDessin().ajouterVueForme(this.creerVueForme());
         this.getPanneauDessin().repaint();
      }
   }
   protected abstract VueForme creerVueForme();
}
