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
      // pattern shapes
      // from Top-Left to Bottom-Right
      if(x1<x2 && y1<y2){
         cercle.setPosition(
            new Coordonnees(x1, y1)
         );
      // from Bottom-Right to Top-Left
      } else if(x1>x2 && y1>y2){
         cercle.setPosition(
            new Coordonnees(
               x1-cercle.getLargeur(),
               y1-cercle.getLargeur()
            )
         );
      // from Bottom-Left to Top-Right
      } else if(x1<x2 && y1>y2){
         cercle.setPosition(
            new Coordonnees(
               x1,
               y1-cercle.getLargeur()
            )
         );
      // from Top-Right to Bottom-Left
      } else if(x1>x2 && y1<y2){
         cercle.setPosition(
            new Coordonnees(
               x1-cercle.getLargeur(),
               y1
            )
         );
      // default
      } else {
         cercle.setPosition(
            new Coordonnees()
         );
      }
      cercle.setRempli(this.getPanneauDessin().getModeRemplissage());
      return new VueCercle(cercle);
   }
   public void mouseClicked(MouseEvent event){
      super.mouseClicked(event);
   }
}
