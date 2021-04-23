package fr.eseo.poo.projet.artiste.controleur.outils;

// external imports
import java.awt.event.MouseEvent;

// internal imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilCercle extends OutilForme {
   // methodes
   protected VueForme creerVueForme(){
      Cercle cercle = new Cercle();
      double x1 = this.getDebut().getAbscisse();
      double y1 = this.getDebut().getOrdonnee();
      double x2 = this.getFin().getAbscisse();
      double y2 = this.getFin().getOrdonnee();
      cercle.setLargeur(
         Math.max(
            Math.abs(x2-x1),
            Math.abs(y2-y1)
         )
      );
      cercle.setCouleur(this.getPanneauDessin().getCouleurCourante());
      // opti
      if(x1>x2){
         if(y1>y2){
            x1=x1-cercle.getLargeur();
            y1=y1-cercle.getLargeur();
         } else {
            x1=x1-cercle.getLargeur();
         }
      } else if(y1>y2){
         y1=y1-cercle.getLargeur();
      }
      cercle.setPosition(
         new Coordonnees(
            x1,
            y1
         )
      );
      cercle.setRempli(this.getPanneauDessin().getModeRemplissage());
      return new VueCercle(cercle);
   }
   public void mouseClicked(MouseEvent event){
      super.mouseClicked(event);
   }
}
