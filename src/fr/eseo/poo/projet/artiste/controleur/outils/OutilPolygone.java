package fr.eseo.poo.projet.artiste.controleur.outils;

//internal imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Polygone;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VuePolygone;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

public class OutilPolygone extends OutilForme {

	// attributes
	private PanneauBarreOutils panneauBarreOutils;
	
	// constructeurs
	public OutilPolygone(PanneauBarreOutils panneauBarreOutils){
	   this.panneauBarreOutils = panneauBarreOutils;
	}
	
	// methodes
	protected VueForme creerVueForme(){
	   Polygone polygone = new Polygone();
	   double x1 = this.getDebut().getAbscisse();
	   double y1 = this.getDebut().getOrdonnee();
	   double x2 = this.getFin().getAbscisse();
	   double y2 = this.getFin().getOrdonnee();
	   double distance = this.getDebut().distanceVers(this.getFin());
	   double angle = this.getDebut().angleVers(this.getFin());
	   if (Math.abs(x2 - x1) == Forme.LARGEUR_PAR_DEFAUT && Math.abs(y2 - y1) == Forme.HAUTEUR_PAR_DEFAUT){
		   polygone.setPosition(this.getDebut());
		   polygone.setLargeur(Forme.LARGEUR_PAR_DEFAUT);
		   polygone.setAnglePremierCote(Polygone.ANGLE_PREMIER_COTE_PAR_DEFAUT);
			} else {
				polygone.setLargeur(distance*2);
				polygone.setAnglePremierCote(angle);
				polygone.setPosition(
					new Coordonnees(
	            x2 - (polygone.getCadreMaxX() + polygone.getCadreMinX())/2,
	            y2 - (polygone.getCadreMaxY() + polygone.getCadreMinY())/2
	         )
				);
			}
	   polygone.setCouleur(this.getPanneauDessin().getCouleurCourante());
	   polygone.setRempli(this.getPanneauDessin().getModeRemplissage());
	   polygone.setNbCotes(this.panneauBarreOutils.getNbBranches());
	   polygone.setLongueurCotes(this.panneauBarreOutils.getLongueurBranche());
	   return new VuePolygone(polygone);
	}
}