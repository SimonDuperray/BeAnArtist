package fr.eseo.poo.projet.artiste.controleur.outils;

// internal imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueEtoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

public class OutilEtoile extends OutilForme {
   
   // attributes
//   private Etoile etoile;
   private PanneauBarreOutils panneauBarreOutils;

   // constructeurs
   public OutilEtoile(PanneauBarreOutils panneauBarreOutils){
      this.panneauBarreOutils = panneauBarreOutils;
//      this.etoile = new Etoile();
   }

   // methodes
   protected VueForme creerVueForme(){
      Etoile etoile = new Etoile();
      double x1 = this.getDebut().getAbscisse();
      double y1 = this.getDebut().getOrdonnee();
      double x2 = this.getFin().getAbscisse();
      double y2 = this.getFin().getOrdonnee();
      double distance = this.getDebut().distanceVers(this.getFin());
      double angle = this.getDebut().angleVers(this.getFin());
      if (Math.abs(x2 - x1) == Forme.LARGEUR_PAR_DEFAUT && Math.abs(y2 - y1) == Forme.HAUTEUR_PAR_DEFAUT){
			etoile.setPosition(this.getDebut());
			etoile.setLargeur(Forme.LARGEUR_PAR_DEFAUT);
			etoile.setAnglePremiereBranche(Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT);
		} else {
			etoile.setLargeur(distance*2);
			etoile.setAnglePremiereBranche(angle);
			etoile.setPosition(
				new Coordonnees(
               x2 - (etoile.getCadreMaxX() + etoile.getCadreMinX())/2,
               y2 - (etoile.getCadreMaxY() + etoile.getCadreMinY())/2
            )
			);
		}
      etoile.setCouleur(this.getPanneauDessin().getCouleurCourante());
      etoile.setRempli(this.getPanneauDessin().getModeRemplissage());
      etoile.setNombreBranches(this.panneauBarreOutils.getNbBranches());
      etoile.setLongueurBranche(this.panneauBarreOutils.getLongueurBranche());
      return new VueEtoile(etoile);
   }
}