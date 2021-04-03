package fr.eseo.poo.projet.artiste.controleur.outils;

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
      // pattern shapes
      // from TL to BR
      if(x1<x2 && y1<y2){
         ellipse.setPosition(
            new Coordonnees(x1, y1)
         );
      // from BR to TL
      } else if(x1>x2 && y1>y2){
         ellipse.setPosition(
            new Coordonnees(x2, y2)
         );
      // from BL to TR
      } else if(x1<x2 && y1>y2){
         ellipse.setPosition(
            new Coordonnees(x1, y2)
         );
      // from TR to BL
      } else if(x1>x2 && y1<y2){
         ellipse.setPosition(
            new Coordonnees(x2, y1)
         );
      // default
      } else {
         ellipse.setPosition(
            new Coordonnees(x1, y1)
         );
      }
      return new VueEllipse(ellipse);
   }
}
