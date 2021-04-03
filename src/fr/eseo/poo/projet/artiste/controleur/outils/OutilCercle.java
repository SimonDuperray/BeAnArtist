package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import java.awt.event.MouseEvent;

public class OutilCercle extends OutilForme {
   // methodes
   protected VueForme creerVueForme(){
      double x1 = this.getDebut().getAbscisse();
      double y1 = this.getDebut().getOrdonnee();
      double x2 = this.getFin().getAbscisse();
      double y2 = this.getFin().getOrdonnee();
      Cercle cercle = new Cercle();
      cercle.setLargeur(
         Math.max(
            Math.abs(x2-x1),
            Math.abs(y2-y1)
         )
      );
      // pattern shapes
      // from TL to BR
      if(x1<x2 && y1<y2){
         cercle.setPosition(
            new Coordonnees(x1, y1)
         );
      // from BR to TL
      } else if(x1>x2 && y1>y2){
         cercle.setPosition(
            new Coordonnees(
               x1-cercle.getLargeur(),
               y1-cercle.getLargeur()
            )
         );
      // from BL to TR
      } else if(x1<x2 && y1>y2){
         cercle.setPosition(
            new Coordonnees(
               x1,
               y1-cercle.getLargeur()
            )
         );
      // from TR to BL
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
            new Coordonnees(

            )
         );
      }
      return new VueCercle(cercle);
   }
   public void mouseClicked(MouseEvent event){
      super.mouseClicked(event);
   }
}
