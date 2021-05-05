package fr.eseo.poo.projet.artiste.modele.formes;

//external imports
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.awt.Polygon;

//internal imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public abstract class Polygone extends Forme implements Remplissable {
   
   // class constants
   public static final int NOMBRE_COTES_PAR_DEFAUT = 5;
   public static final double LONGUEUR_COTES_PAR_DEFAUT = 0.5;
   public static final double ANGLE_PREMIER_COTE_PAR_DEFAUT = 0.9;

   // attributes
   private List<Coordonnees> coordonnees;
   private boolean estRempli;
   private int nombreCotes;
   private double longueurCotes;
   private double anglePremierCote;

   // constructors
   public Polygone(){
      super();
      this.longueurCotes = LONGUEUR_COTES_PAR_DEFAUT;
      this.anglePremierCote = ANGLE_PREMIER_COTE_PAR_DEFAUT;
      this.nombreCotes = NOMBRE_COTES_PAR_DEFAUT;
      this.estRempli = false;
      this.coordonnees = new ArrayList<Coordonnees>();
      this.recalculerSommets();
   }
   public Polygone(double taille){
      super(taille, taille);
      this.checkTaille(taille);
      this.longueurCotes = LONGUEUR_COTES_PAR_DEFAUT;
      this.anglePremierCote = ANGLE_PREMIER_COTE_PAR_DEFAUT;
      this.nombreCotes = NOMBRE_COTES_PAR_DEFAUT;
      this.estRempli = false;
      this.coordonnees = new ArrayList<Coordonnees>();
      this.recalculerSommets();
   }
   public Polygone(Coordonnees coordonnees){
      super(coordonnees);
      this.longueurCotes = LONGUEUR_COTES_PAR_DEFAUT;
      this.anglePremierCote = ANGLE_PREMIER_COTE_PAR_DEFAUT;
      this.nombreCotes = NOMBRE_COTES_PAR_DEFAUT;
      this.estRempli = false;
      this.coordonnees = new ArrayList<Coordonnees>();
      this.recalculerSommets();
   }
   public Polygone(Coordonnees coordonnees, double taille){
      super(coordonnees, taille, taille);
      this.checkTaille(taille);
      this.longueurCotes = LONGUEUR_COTES_PAR_DEFAUT;
      this.anglePremierCote = ANGLE_PREMIER_COTE_PAR_DEFAUT;
      this.nombreCotes = NOMBRE_COTES_PAR_DEFAUT;
      this.estRempli = false;
      this.coordonnees = new ArrayList<Coordonnees>();
      this.recalculerSommets();
   }
   public Polygone(Coordonnees coordonnees, double taille, int nbCotes, double angle, double longueur){
      super(coordonnees, taille, taille);
      this.checkTaille(taille);
      this.checkAngle(angle);
      this.checkLongueur(longueur);
      this.checkCotes(nbCotes);
      this.longueurCotes = LONGUEUR_COTES_PAR_DEFAUT;
      this.anglePremierCote = ANGLE_PREMIER_COTE_PAR_DEFAUT;
      this.nombreCotes = NOMBRE_COTES_PAR_DEFAUT;
      this.estRempli = false;
      this.coordonnees = new ArrayList<Coordonnees>();
      this.recalculerSommets();
   }

   // exceptions
   private void checkTaille(double taille) {
      if(taille<0){
         throw new IllegalArgumentException("Taille: [0;100]");
      }
   }
   private void checkAngle(double angle){
      if(angle>Math.PI || angle<-Math.PI)
         throw new IllegalArgumentException("Angle: [-pi;pi]");
   }
   private void checkLongueur(double longueur){
      if(longueur<0 || longueur>1)
         throw new IllegalArgumentException("Longueur: [0;1]");
   }
   private void checkCotes(int cotes){
      if(cotes<3 || cotes>15)
         throw new IllegalArgumentException("Branches: [2;16]");
   }

   // getters
   public int getNbCotes(){
      return this.nombreCotes;
   }
   public double getLongueurCote(){
      return this.longueurCotes;
   }
   public double getAnglePremierCote(){
      return this.anglePremierCote;
   }
   public List<Coordonnees> getCoordonnees(){
      return this.coordonnees;
   }
   public boolean estRempli(){
      return this.estRempli;
   }

   // setters
   public void setPosition(Coordonnees position){
      super.setPosition(position);
      this.recalculerSommets();
   }
   public void setLargeur(double largeur){
      this.checkTaille(largeur);
      super.setLargeur(largeur);
      super.setHauteur(largeur);
      this.recalculerSommets();
   }
   public void setHauteur(double hauteur){
      this.checkTaille(hauteur);
      super.setLargeur(hauteur);
      super.setHauteur(hauteur);
      this.recalculerSommets();
   }
   public void setNbCotes(int nb){
      this.checkCotes(nb);
      this.nombreCotes = nb;
      this.recalculerSommets();
   }
   public void setLongueurCotes(double lg){
      this.checkLongueur(lg);
      this.longueurCotes = lg;
      this.recalculerSommets();
   }
   public void setAnglePremierCote(double angle){
      this.checkAngle(angle);
      this.anglePremierCote = angle;
      this.recalculerSommets();
   }
   public void setRempli(boolean isRempli){
      this.estRempli = isRempli;
   }
   public void setCoordonnees(List<Coordonnees> coordonnees){
      this.coordonnees=coordonnees;
      this.recalculerSommets();
   }
   // methodes
   private void recalculerSommets(){

   }
   public double perimetre(){
      return 2.0;
   }
   public double aire(){
      return 5.0;
   }
   public boolean contient(Coordonnees position){
      Polygon p = new Polygon();
      for(int i=0; i<this.getCoordonnees().size(); i++){
         p.addPoint(
            Math.toIntExact(Math.round(this.getCoordonnees().get(i).getAbscisse())),
            Math.toIntExact(Math.round(this.getCoordonnees().get(i).getOrdonnee()))
         );
      }
      return p.contains(
         position.getAbscisse(),
         position.getOrdonnee()
      );
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
      return "[Polygone"+(this.estRempli() ? "-Rempli" : "")+"] : pos "+bufferCoord.toString()
         +" dim "+decimalFormat.format(super.getLargeur())
         +" x "+decimalFormat.format(super.getHauteur())
         + " périmètre : "+decimalFormat.format(this.perimetre())
         +" aire : "+decimalFormat.format(this.aire())
         +" couleur = "+this.getCorrectColor(locale);
   }
}
