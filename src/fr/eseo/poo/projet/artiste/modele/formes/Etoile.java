package fr.eseo.poo.projet.artiste.modele.formes;

// external imports
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.awt.Polygon;

// internal imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Etoile extends Forme implements Remplissable {
   
   // class constants
   public static final int NOMBRE_BRANCHES_PAR_DEFAUT = 5;
   public static final double LONGUEUR_BRANCHE_PAR_DEFAUT = 0.5;
   public static final double ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT = 0.9;

   // attributes
   private List<Coordonnees> coordonnees;
   private boolean estRempli;
   private int nombreBranches;
   private double longueurBranche;
   private double anglePremiereBranche;

   // constructors
   public Etoile(){
      super();
      this.longueurBranche = LONGUEUR_BRANCHE_PAR_DEFAUT;
      this.anglePremiereBranche = ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT;
      this.nombreBranches = NOMBRE_BRANCHES_PAR_DEFAUT;
      this.estRempli = false;
      this.coordonnees = new ArrayList<Coordonnees>();
      this.recalculerSommets();
	}
	public Etoile(double taille){
      super(taille, taille);
      if(taille<0){
          throw new IllegalArgumentException("Taille négative");
       }
      this.longueurBranche = LONGUEUR_BRANCHE_PAR_DEFAUT;
      this.anglePremiereBranche = ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT;
      this.nombreBranches = NOMBRE_BRANCHES_PAR_DEFAUT;
      this.estRempli = false;
      this.coordonnees = new ArrayList<Coordonnees>();
      this.recalculerSommets();
   }
	public Etoile(Coordonnees coordonnees){
      super(coordonnees);
      this.longueurBranche = LONGUEUR_BRANCHE_PAR_DEFAUT;
      this.anglePremiereBranche = ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT;
      this.nombreBranches = NOMBRE_BRANCHES_PAR_DEFAUT;
      this.estRempli = false;
      this.coordonnees = new ArrayList<Coordonnees>();
      this.recalculerSommets();
	}
	public Etoile(Coordonnees coordonnees, double taille){
      super(coordonnees, taille, taille);
      if(taille<0){
         throw new IllegalArgumentException("Taille négative");
      }
      this.longueurBranche = LONGUEUR_BRANCHE_PAR_DEFAUT;
      this.anglePremiereBranche = ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT;
      this.nombreBranches = NOMBRE_BRANCHES_PAR_DEFAUT;
      this.estRempli = false;
      this.coordonnees = new ArrayList<Coordonnees>();
      this.recalculerSommets();
	}
	public Etoile(Coordonnees coordonnees, double taille, int nombreBranches, double anglePremiereBranche, double longueurBranche){
		super(coordonnees, taille, taille);
		if(taille<0){
			throw new IllegalArgumentException("taille appartient [-1;100]");
	    }
        if(anglePremiereBranche>Math.PI || anglePremiereBranche<-Math.PI){
        	throw new IllegalArgumentException("angle appartient [-pi;pi]");
		}
		if(longueurBranche<0 || longueurBranche>1){
			throw new IllegalArgumentException("longueur appartient [0;1]");
		}
		if(nombreBranches<3 || nombreBranches>15){
			throw new IllegalArgumentException("nb branches appartient [2;16]");
		}
		this.estRempli = false;
		this.nombreBranches = nombreBranches;
		this.longueurBranche = longueurBranche;
		this.anglePremiereBranche = anglePremiereBranche;
		this.coordonnees = new ArrayList<Coordonnees>();
		this.recalculerSommets();
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
      this.recalculerSommets();
   }
   public void setLargeur(double largeur){
      if(largeur<0){
         throw new IllegalArgumentException("Largeur negative");
      }
      super.setLargeur(largeur);
      super.setHauteur(largeur);
      this.recalculerSommets();
   }
   public void setHauteur(double hauteur){
      if(hauteur<0){
         throw new IllegalArgumentException("Hauteur negative");
      }
      super.setLargeur(hauteur);
      super.setHauteur(hauteur);
      this.recalculerSommets();
   }
   public void setNombreBranches(int nbBranches){
      if(nbBranches < 3 || nbBranches > 15){
         throw new IllegalArgumentException("nbBranches appartient [2;16]");
      }
      this.nombreBranches = nbBranches;
      this.recalculerSommets();
   }
   public void setLongueurBranche(double longueurBranche){
      if(longueurBranche < 0 || longueurBranche > 1){
         throw new IllegalArgumentException("longueurBranche appartient [0;1]");
      }
      this.longueurBranche = longueurBranche;
      this.recalculerSommets();
   }
   public void setAnglePremiereBranche(double angle) {
      if(angle>Math.PI || angle<-Math.PI){
         throw new IllegalArgumentException("angle appartient [-pi;pi]");
      } else {
    	  this.anglePremiereBranche = angle;
    	  this.recalculerSommets();
      }
   }
   public void setRempli(boolean isRempli) {
      this.estRempli=isRempli;
   }
   public void setCoordonnees(List<Coordonnees> coordonnees){
      this.coordonnees=coordonnees;
      this.recalculerSommets();
   }

   // methodes
   public double aire() {
      double x = 0;
      double y = 0;
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
		// if(locale.getLanguage()=="fr"){
		// 	couleur="R"+getCouleur().getRed()+",V"+getCouleur().getGreen()+",B"+getCouleur().getBlue();
      // } 
      // else if(locale.getLanguage()=="en"){
      //    couleur="R"+getCouleur().getRed()+",G"+getCouleur().getGreen()+",B"+getCouleur().getBlue();
         
		// } else {
		// 	couleur="Bad Language";
		// }
		String rempli="";
		if(this.estRempli()){
			rempli="-Rempli";
		}
      return "[Etoile"+rempli+"] : pos "+bufferCoord.toString()
         +" dim "+decimalFormat.format(super.getLargeur())
         +" x "+decimalFormat.format(super.getHauteur())
         + " périmètre : "+decimalFormat.format(this.perimetre())
         +" aire : "+decimalFormat.format(this.aire())
         +" couleur = "+this.getCorrectColor(locale);
	}
   private void recalculerSommets(){
      this.coordonnees.clear();
      // centre de l'etoile
      Coordonnees center = new Coordonnees(
         (this.getCadreMinX()+this.getCadreMaxX())/2,
         (this.getCadreMinY()+this.getCadreMaxY())/2
      );
      double angle = this.anglePremiereBranche;
      for (int i=0;i<2*this.getNombreBranches();i++){
         if(i%2==0){
            this.coordonnees.add(
               new Coordonnees(
                  center.getAbscisse()+this.getLargeur()/2*Math.cos(angle),
                  center.getOrdonnee()+this.getHauteur()/2*Math.sin(angle)
               )
            );
         } else {
            this.coordonnees.add(
               new Coordonnees(
                  center.getAbscisse()+(1-this.longueurBranche)*this.getLargeur()/2*Math.cos(angle),
                  center.getOrdonnee()+(1-this.longueurBranche)*this.getHauteur()/2*Math.sin(angle)
               )
            );
         }
         angle += Math.toRadians(180/((double) this.nombreBranches));
        }
   }

	public boolean contient(Coordonnees position) {
      Polygon p = new Polygon();
      for(int i=0; i<this.getCoordonnees().size(); i++) {
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
}
