package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse {
   // constructeurs
   public Cercle(){
      super();
   }
   public Cercle(double taille){
      super(taille, taille);
   }
   public Cercle(Coordonnees coordonnees) {
      super(coordonnees);
   }
   public Cercle(Coordonnees coordonnees, double taille) {
      super(coordonnees, taille, taille);
   }

   // setters
   public void setHauteur(double hauteur) {
      super.setHauteur(hauteur);
   }
   public void setLargeur(double largeur){
      super.setLargeur(largeur);
   }

   // methodes
   public double perimetre(){
      return 2*Math.PI*super.getLargeur();
   }
}
