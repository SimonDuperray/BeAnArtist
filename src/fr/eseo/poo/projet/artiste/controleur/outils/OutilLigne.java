package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.formes.VueLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilLigne extends OutilForme {

   // constructeur
   public OutilLigne(){

   }

   // methodes
   protected VueForme creerVueForme(){
      Ligne ligne = new Ligne();
      ligne.setCouleur(PanneauDessin.COULEUR_FOND_PAR_DEFAUT);
      ligne.setC1(this.getDebut());
      ligne.setC2(this.getFin());
      return new VueLigne(ligne);
   }

}
