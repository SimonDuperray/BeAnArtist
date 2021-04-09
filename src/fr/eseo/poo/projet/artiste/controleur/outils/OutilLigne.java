package fr.eseo.poo.projet.artiste.controleur.outils;

// internal imports
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.formes.VueLigne;

public class OutilLigne extends OutilForme {

   // constructor
   public OutilLigne(){}

   // bonus methodes
   private boolean isIn(double c) {
	   return c>=0 && c<200;
   }
   	
   // methodes
   protected VueForme creerVueForme(){
      Ligne ligne = new Ligne();
      ligne.setCouleur(this.getPanneauDessin().getCouleurCourante());
      // test
      double x1, y1, x2, y2;
      x1 = this.getDebut().getAbscisse();
      y1 = this.getDebut().getOrdonnee();
      x2 = this.getFin().getAbscisse();
      y2 = this.getFin().getOrdonnee();
      if(this.isIn(x1) || this.isIn(y1) || this.isIn(x2) || this.isIn(y2)) {
         throw new IllegalArgumentException("c appartient [0;200[");
      }
      ligne.setC1(this.getDebut());
      ligne.setC2(this.getFin());
      return new VueLigne(ligne);
   }

}
