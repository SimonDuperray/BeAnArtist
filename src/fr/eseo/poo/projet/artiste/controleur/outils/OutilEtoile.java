package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueEtoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

public class OutilEtoile extends OutilForme {
   
   // attributs
   private Etoile etoile = new Etoile();
   private PanneauBarreOutils panneauBarreOutils;

   // constructeurs
   public OutilEtoile(PanneauBarreOutils panneauBarreOutils){
      this.panneauBarreOutils=panneauBarreOutils;
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

      if(Math.abs(x2-x1)==Forme.LARGEUR_PAR_DEFAUT && Math.abs(y2-y1)==Forme.HAUTEUR_PAR_DEFAUT){
         etoile.setPosition(this.getDebut());
         etoile.setLargeur(Forme.LARGEUR_PAR_DEFAUT);
         etoile.setAnglePremiereBranche(Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT);
      } else {
         double sumCadreX = (etoile.getCadreMaxX()+etoile.getCadreMinX())/2;
         double sumCadreY = (etoile.getCadreMaxY()+etoile.getCadreMinY())/2;
         etoile.setPosition(
            new Coordonnees(x2-sumCadreX, y2-sumCadreY)
         );
         etoile.setLargeur(distance);
         etoile.setAnglePremiereBranche(angle);
      }
      
      etoile.setCouleur(this.getPanneauDessin().getCouleurCourante());
      etoile.setRempli(this.getPanneauDessin().getModeRemplissage());
      etoile.setNombreBranches(this.panneauBarreOutils.getNbBranches());
      etoile.setLongueurBranche(this.panneauBarreOutils.getLongueurBranche());

      return new VueEtoile(etoile);
   }
}
