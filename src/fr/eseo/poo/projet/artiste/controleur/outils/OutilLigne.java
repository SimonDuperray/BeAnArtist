package fr.eseo.poo.projet.artiste.controleur.outils;

// internal imports
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.formes.VueLigne;

public class OutilLigne extends OutilForme {

   // constructor
   public OutilLigne(){}

   // methodes
   protected VueForme creerVueForme(){
      Ligne ligne = new Ligne();
      ligne.setCouleur(this.getPanneauDessin().getCouleurCourante());
      ligne.setC1(this.getDebut());
      ligne.setC2(this.getFin());
      return new VueLigne(ligne);
   }

}
