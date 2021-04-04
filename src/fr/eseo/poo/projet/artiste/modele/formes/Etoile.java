package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Etoile extends Forme implements fr.eseo.poo.projet.artiste.modele.Remplissable {
   // constantes de classe
   public static final int NOMBRE_BRANCHES_PAR_DEFAUT = 5;
   public static final double LONGUEUR_BRANCHE_PAR_DEFAUT = 0.5;
   public static final double ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT = 0;

   // attributs
   private List<Coordonnees> coordonnees;
   private boolean estRempli;
   private int nombreBranches;
   private double longueurBranche;
   private double anglePremiereBranche;

   // constructeurs
   public Etoile(){
		this(Forme.POSITION_PAR_DEFAUT, LARGEUR_PAR_DEFAUT, NOMBRE_BRANCHES_PAR_DEFAUT,
				ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, LONGUEUR_BRANCHE_PAR_DEFAUT);
	}
	
	public Etoile(double taille){
		this(Forme.POSITION_PAR_DEFAUT, taille, NOMBRE_BRANCHES_PAR_DEFAUT,
				ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, LONGUEUR_BRANCHE_PAR_DEFAUT);
	}
	
	public Etoile(Coordonnees coordonnees){
		this(coordonnees, LARGEUR_PAR_DEFAUT, NOMBRE_BRANCHES_PAR_DEFAUT,
				ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, LONGUEUR_BRANCHE_PAR_DEFAUT);
	}
	
	public Etoile(Coordonnees coordonnees, double taille){
		this(coordonnees, taille, NOMBRE_BRANCHES_PAR_DEFAUT,
				ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, LONGUEUR_BRANCHE_PAR_DEFAUT);
	}
	
	public Etoile(Coordonnees coordonnees, double taille, int nombreBranches, double anglePremiereBranche, double longueurBranche){
		super(coordonnees, taille, taille);
		if(taille<0){
			throw new IllegalArgumentException("Taille negative");
      }
      if(anglePremiereBranche>Math.PI || anglePremiereBranche<-Math.PI){
			throw new IllegalArgumentException("angle appartient [-pi;pi]");
		}
		if(longueurBranche<0 || longueurBranche>1){
			throw new IllegalArgumentException("longueur appartient [0;1]");
		}
		if(nombreBranches<= 2 || nombreBranches>=16){
			throw new IllegalArgumentException("nb branches appartient [2;16]");
		}
		this.estRempli = false;
		this.nombreBranches = nombreBranches;
		this.longueurBranche = longueurBranche;
		this.anglePremiereBranche = anglePremiereBranche;
		this.coordonnees = new ArrayList<Coordonnees>();
   }
   
   // getters
   public int getNombreBranches(){
      return this.nombreBranches;
   }
   public double getLongueurBranche(){
      return this.longueurBranche;
   }
   public double getAnglePremiereBranche(){
      return this.anglePremiereBranche;
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
   }
   public void setLargeur(double largeur){
      if(largeur<0){
         throw new IllegalArgumentException("Largeur negative");
      }
      super.setLargeur(largeur);
      super.setHauteur(largeur);
   }
   public void setHauteur(double hauteur){
      if(hauteur<0){
         throw new IllegalArgumentException("Hauteur negative");
      }
      super.setLargeur(hauteur);
      super.setHauteur(hauteur);
   }
   public void setNombreBranches(int nbBranches){
      if(nbBranches <= 2 || nbBranches >= 16){
         throw new IllegalArgumentException("nbBranches appartient [2;16]");
      }
      this.nombreBranches = nbBranches;
   }
   public void setLongueurBranche(double longueurBranche){
      if(longueurBranche < 0 || longueurBranche > 1){
         throw new IllegalArgumentException("longueurBranche appartient [0;1]");
      }
      this.longueurBranche = longueurBranche;
   }
   public void setAnglePremiereBranche(double angle) {
      if(angle>Math.PI || angle<-Math.PI){
         throw new IllegalArgumentException("angle appartient [-pi;pi]");
      }
      this.anglePremiereBranche = angle;
   }
   public void setRempli(boolean isRempli) {
      this.estRempli=isRempli;
   }

   // methodes
   public double aire() {
      double x = 0, y = 0;
      for(int i=0; i<this.getCoordonnees().size()-1; i++){
         x += this.getCoordonnees().get(i).getAbscisse()*this.getCoordonnees().get(i+1).getOrdonnee();
         y += this.getCoordonnees().get(i).getOrdonnee()*this.getCoordonnees().get(i+1).getAbscisse();
      }
      x += this.getCoordonnees().get(this.getCoordonnees().size()-1).getAbscisse()*this.getCoordonnees().get(0).getOrdonnee();
		y += this.getCoordonnees().get(this.getCoordonnees().size()-1).getOrdonnee()*this.getCoordonnees().get(0).getAbscisse();
      return Math.abs((x-y)/2);
   }
   public double perimetre() {
      double p = 0;
      for(int i=0; i<this.getCoordonnees().size()-1; i++){
         p += this.getCoordonnees().get(i).distanceVers(this.getCoordonnees().get(i+1));
      }
      return p + this.getCoordonnees().get(this.getCoordonnees().size()-1).distanceVers(this.getCoordonnees().get(0));
   }
   public String toString(){
      DecimalFormat df = new DecimalFormat("0.0#");
      Locale locale = Locale.getDefault();
      String couleur="";
      if(locale.getLanguage() == "en"){
		   couleur = "R" +this.getCouleur().getRed() + ",G"+this.getCouleur().getGreen() + ",B" +this.getCouleur().getBlue();
		}
		else if(locale.getLanguage() == "fr"){
			couleur = "R" +this.getCouleur().getRed() + ",V"+this.getCouleur().getGreen() + ",B" +this.getCouleur().getBlue();
      }
      String rempli="";
      if(this.estRempli()){
         rempli="-Rempli";
      }
      return "[Etoile"+rempli+"] : pos "+super.getPosition().toString() + " largeur "
         +df.format(super.getLargeur())+" hauteur "+df.format(super.getHauteur())
         +" perimetre : "+df.format(this.perimetre())
         +" aire : "+df.format(this.aire())
         +" couleur = "+couleur;
   }

	@Override
	public boolean contient(Coordonnees position) {
		// TODO Auto-generated method stub
		return false;
	}
}
