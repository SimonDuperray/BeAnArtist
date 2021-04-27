package fr.eseo.poo.projet.artiste.modele.formes;

// external imports
import java.text.DecimalFormat;
import java.util.Locale;

// internal imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Carre extends Rectangle {

   // class constants
   public static final double EPSILON = 0.2;

   // constructors
   public Carre(){
      super();
      this.estRempli = false;
   }
   public Carre(double taille){
      super(taille, taille);
      this.isNegative();
      this.estRempli=false;
   }
   public Carre(Coordonnees coordonnees){
      super(coordonnees);
      this.estRempli=false;
   }
   public Carre(Coordonnees coordonnees, double taille){
      super(coordonnees, taille, taille);
      this.isNegative();
      this.estRempli=false;
   }

   // getters
   public boolean estRempli(){
      return this.estRempli;
   }

   // setters
   public void setHauteur(double hauteur){
      super.setHauteur(hauteur);
      super.setLargeur(hauteur);
      this.isNegative();
   }
   public void setLargeur(double largeur){
      super.setHauteur(largeur);
      super.setLargeur(largeur);
      this.isNegative();
   }
   public void setRempli(boolean rempli){
      this.estRempli=rempli;
   }

   // methodes
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
      return "[Carré"+(this.estRempli() ? "-Rempli" : "")+"] : pos ("+decimalFormat.format(bufferCoord.getAbscisse())+" , "
         +decimalFormat.format(bufferCoord.getOrdonnee())
         +") dim "+decimalFormat.format(super.getLargeur())+" x "+decimalFormat.format(super.getHauteur())
         +" périmètre : "+decimalFormat.format(this.perimetre())
         +" aire : "+decimalFormat.format(this.aire())
         +" couleur = "+this.getCorrectColor(locale);
   }
   public double aire(){
      return Math.pow(super.getLargeur(), 2);
   }
   public double perimetre(){
      return 4*(super.getLargeur());
   }
   public void isNegative(){
      if(super.getLargeur()<0 || super.getHauteur()<0){
         throw new IllegalArgumentException("Largeur négative");
      }
   }
}
