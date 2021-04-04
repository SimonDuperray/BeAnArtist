package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse {

   public static final double EPSILON = 0.2;

   // constructeurs
   public Cercle(){
      super();
      this.estRempli=false;
   }
   public Cercle(double taille) throws IllegalArgumentException{
      super(taille, taille);
      isNegative();
      this.estRempli=false;
   }
   public Cercle(Coordonnees coordonnees){
      super(coordonnees);
      this.estRempli=false;
   }
   public Cercle(Coordonnees coordonnees, double taille) throws IllegalArgumentException{
      super(coordonnees, taille, taille);
      isNegative();
      this.estRempli=false;
   }

   // getters
   public boolean estRempli(){
      return this.estRempli;
   }

   // setters
   public void setHauteur(double hauteur) throws IllegalArgumentException {
      super.setHauteur(hauteur);
      super.setLargeur(hauteur);
      isNegative();
   }
   public void setLargeur(double largeur) throws IllegalArgumentException{
      super.setLargeur(largeur);
      super.setHauteur(largeur);
      isNegative();
   }
   public void setRempli(boolean rempli){
      this.estRempli=rempli;
   }

   // methodes
   public double perimetre(){
      return 2*Math.PI*super.getLargeur()/2;
   }
   public String toString(){
      String couleur="";
		Locale locale = Locale.getDefault();
		DecimalFormat decimalFormat = new DecimalFormat("0.0#");
      Coordonnees bufferCoord = super.getPosition();
      if(locale.getLanguage()=="fr"){
			couleur="R"+getCouleur().getRed()+",V"+getCouleur().getGreen()+",B"+getCouleur().getBlue();
		} else if(locale.getLanguage()=="en"){
			couleur="R"+getCouleur().getRed()+",G"+getCouleur().getGreen()+",B"+getCouleur().getBlue();
		} else {
			couleur="Bad Language";
      }
      String rempli="";
		if(this.estRempli()){
			rempli="-Rempli";
		}
      return "[Cercle"+rempli+"] : pos ("+decimalFormat.format(bufferCoord.getAbscisse())+" , "
         +decimalFormat.format(bufferCoord.getOrdonnee())
         +") dim "+decimalFormat.format(super.getLargeur())+" x "+decimalFormat.format(super.getHauteur())
         +" périmètre : "+decimalFormat.format(this.perimetre())
         +" aire : "+decimalFormat.format(this.aire())
         +" couleur = "+couleur;
	}
   public void isNegative(){
      if(super.getLargeur()<0){
         throw new IllegalArgumentException("Largeur negative");
      }
   }
}
