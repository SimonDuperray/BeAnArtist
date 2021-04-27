package fr.eseo.poo.projet.artiste.controleur.outils;

// internal imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilEllipse extends OutilForme {
   // methodes
   protected VueForme creerVueForme(){
      double x1 = this.getDebut().getAbscisse();
      double y1 = this.getDebut().getOrdonnee();
      double x2 = this.getFin().getAbscisse();
      double y2 = this.getFin().getOrdonnee();
      Ellipse ellipse = new Ellipse();
      ellipse.setLargeur(Math.abs(x2 - x1));
      ellipse.setHauteur(Math.abs(y2 - y1));
      ellipse.setCouleur(this.getPanneauDessin().getCouleurCourante());
      if(x1>x2){
         if(y1<y2){
            x1=x2;
         } else {
            x1=x2;
            y1=y2;
         }
      } else if(y1>y2){
         y1=y2;
      }
      ellipse.setPosition(
         new Coordonnees(
            x1,
            y1
         )
      );
      ellipse.setRempli(this.getPanneauDessin().getModeRemplissage());
      return new VueEllipse(ellipse);
   }
}