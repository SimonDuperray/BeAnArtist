package fr.eseo.poo.projet.artiste.controleur.outils;

// external imports
import java.awt.event.MouseEvent;

// internal imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Carre;
import fr.eseo.poo.projet.artiste.vue.formes.VueCarre;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilCarre extends OutilForme {
   // methodes
   protected VueForme creerVueForme(){
      Carre carre = new Carre();
      double x1 = this.getDebut().getAbscisse();
      double y1 = this.getDebut().getOrdonnee();
      double x2 = this.getFin().getAbscisse();
      double y2 = this.getFin().getOrdonnee();
      carre.setLargeur(
         Math.max(
            Math.abs(x2-x1),
            Math.abs(y2-y1)
         )
      );
      carre.setCouleur(this.getPanneauDessin().getCouleurCourante());
      if(x1>x2){
         if(y1>y2){
            x1=x1-carre.getLargeur();
            y1=y1-carre.getLargeur();
         } else {
            x1=x1-carre.getLargeur();
         }
      } else if(y1>y2){
         y1=y1-carre.getLargeur();
      }
      carre.setPosition(
         new Coordonnees(
            x1,
            y1
         )
      );
      carre.setRempli(this.getPanneauDessin().getModeRemplissage());
      return new VueCarre(carre);
   }
   public void mouseClicked(MouseEvent event){
      super.mouseClicked(event);
   }
}