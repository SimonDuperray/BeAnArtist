package fr.eseo.poo.projet.artiste.modele.formes;

// external imports
import java.util.Locale;
import java.text.DecimalFormat;

// internal imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Rectangle extends Forme implements Remplissable {

   // class constants
   public static final double EPSILON = 0.2;

   // attributes
   public boolean estRempli;

   // constructor
   public Rectangle(){
      super();
      this.estRempli = false;
   }
   public Rectangle(double largeur, double hauteur){
      super(largeur, hauteur);
      this.isNegative();
      this.estRempli = false;
   }
   public Rectangle(Coordonnees coordonnees){
      super(coordonnees);
   }
   public Rectangle(Coordonnees coordonnees, double largeur, double hauteur){
      super(coordonnees, largeur, hauteur);
      this.isNegative();
      this.estRempli = false;
   }

   // getters
   public boolean estRempli(){
      return this.estRempli;
   }

   // setters
   public void setHauteur(double hauteur){
      super.setHauteur(hauteur);
      this.isNegative();
   }
   public void setLargeur(double largeur){
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
         couleur="R"+getCouleur().getRed()+",V"+getCouleur().getGreen()+",B"+getCouleur().getBlue();
      } else {
         couleur="R"+getCouleur().getRed()+",G"+getCouleur().getGreen()+",B"+getCouleur().getBlue();
      }
      return couleur;
   }
   public String toString(){
		Locale locale = Locale.getDefault();
		DecimalFormat decimalFormat = new DecimalFormat("0.0#");
		Coordonnees bufferCoord = super.getPosition();
      String isRempli = this.estRempli() ? "-Rempli" : "";
		return "[Rectangle"+isRempli+ "] : pos ("+decimalFormat.format(bufferCoord.getAbscisse())+" , "
			+decimalFormat.format(bufferCoord.getOrdonnee())
			+") dim "+decimalFormat.format(super.getLargeur())+" x "+decimalFormat.format(super.getHauteur())
			+" périmètre : "+decimalFormat.format(this.perimetre())
			+" aire : "+decimalFormat.format(this.aire())
			+" couleur = "+this.getCorrectColor(locale);
   }
   private void isNegative(){
      if(super.getLargeur()<0){
         throw new IllegalArgumentException("Largeur négative");
      }
      if(super.getHauteur()<0){
         throw new IllegalArgumentException("Hauteur négative");
      }
   }
   public double aire(){
      return (super.getHauteur()*super.getLargeur());
   }
   public double perimetre(){
      return (2*(super.getLargeur()))+(2*super.getHauteur());
   }
   public boolean contient(Coordonnees position){
      double x = position.getAbscisse();
      double y = position.getOrdonnee();
      boolean isInX = x > this.getCadreMinX() && x < this.getCadreMinX()+this.getLargeur();
      boolean isInY = y > this.getCadreMinY() && y < this.getCadreMinY()+this.getHauteur();
      return (isInX && isInY);
   }
}
