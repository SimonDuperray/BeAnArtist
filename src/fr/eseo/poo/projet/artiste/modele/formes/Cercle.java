package fr.eseo.poo.projet.artiste.modele.formes;

// external imports
import java.text.DecimalFormat;
import java.util.Locale;

// internal imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse {

   // class constants
   public static final double EPSILON = 0.2;

   // constructors
   public Cercle(){
      super();
      this.estRempli=false;
   }
   public Cercle(double taille){
      super(taille, taille);
      isNegative();
      this.estRempli=false;
   }
   public Cercle(Coordonnees coordonnees){
      super(coordonnees);
      this.estRempli=false;
   }
   public Cercle(Coordonnees coordonnees, double taille){
      super(coordonnees, taille, taille);
      isNegative();
      this.estRempli=false;
   }

   // getters
   public boolean estRempli(){
      return this.estRempli;
   }

   // setters
   public void setHauteur(double hauteur) {
      super.setHauteur(hauteur);
      super.setLargeur(hauteur);
      isNegative();
   }
   public void setLargeur(double largeur){
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
   private String getCorrectColor(Locale locale){  
      String couleur;
      if(locale.getLanguage().equals("fr")){
         couleur = "R"+getCouleur().getRed()+",V"+getCouleur().getGreen()+",B"+getCouleur().getBlue();
      } else if(locale.getLanguage().equals("en")){
         couleur = "R"+getCouleur().getRed()+",G"+getCouleur().getGreen()+",B"+getCouleur().getBlue();
      } else {
         couleur = "Bad Language";
      }
      return couleur;
   }
   public String toString(){
		Locale locale = Locale.getDefault();
		DecimalFormat decimalFormat = new DecimalFormat("0.0#");
      Coordonnees bufferCoord = super.getPosition();
      return "[Cercle"+(this.estRempli() ? "-Rempli" : "")+"] : pos ("+decimalFormat.format(bufferCoord.getAbscisse())+" , "
         +decimalFormat.format(bufferCoord.getOrdonnee())
         +") dim "+decimalFormat.format(super.getLargeur())+" x "+decimalFormat.format(super.getHauteur())
         +" périmètre : "+decimalFormat.format(this.perimetre())
         +" aire : "+decimalFormat.format(this.aire())
         +" couleur = "+this.getCorrectColor(locale);
	}
   public void isNegative(){
      if(super.getLargeur()<0){
         throw new IllegalArgumentException("Largeur negative");
      }
   }
}
