package fr.eseo.poo.projet.artiste.controleur.outils;

// internal imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.poo.projet.artiste.vue.formes.VueRectangle;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilRectangle extends OutilForme {
   
   // methode
   protected VueForme creerVueForme(){
      double x1 = this.getDebut().getAbscisse();
      double y1 = this.getDebut().getOrdonnee();
      double x2 = this.getFin().getAbscisse();
      double y2 = this.getFin().getOrdonnee();
      Rectangle rectangle = new Rectangle();
      rectangle.setLargeur(Math.abs(x2 - x1));
      rectangle.setHauteur(Math.abs(y2 - y1));
      rectangle.setCouleur(this.getPanneauDessin().getCouleurCourante());
      // pattern shapes
      // from Top-Left to Bottom-Right
      if(x1<x2 && y1<y2){
         rectangle.setPosition(
            new Coordonnees(x1, y1)
         );
      // from Bottom-Right to Top-Left
      } else if(x1>x2 && y1>y2){
         rectangle.setPosition(
            new Coordonnees(x2, y2)
         );
      // from Bottom-Left to Top-Right
      } else if(x1<x2 && y1>y2){
         rectangle.setPosition(
            new Coordonnees(x1, y2)
         );
      // from Top-Right to Bottom-Left
      } else if(x1>x2 && y1<y2){
         rectangle.setPosition(
            new Coordonnees(x2, y1)
         );
      // default
      } else {
         rectangle.setPosition(
            new Coordonnees(x1, y1)
         );
      }
      rectangle.setRempli(this.getPanneauDessin().getModeRemplissage());
      return new VueRectangle(rectangle);
   }
}
