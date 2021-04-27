package fr.eseo.poo.projet.artiste.modele.formes;

// internal imports
import java.util.Locale;
import java.awt.Color;
import java.text.DecimalFormat;

// external imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Ligne extends Forme {

	// class constants
	public static final double EPSILON = 0.2;

	// constructors
	public Ligne() {
		super();
	}
	public Ligne(double largeur, double hauteur) {
		super(largeur, hauteur);
	}
	public Ligne(Coordonnees coordonnees) {
		super(coordonnees);
	}
	public Ligne(Coordonnees coordonnees, double largeur, double hauteur) {
		super(coordonnees, largeur, hauteur);
	}
	// public Ligne(Coordonnees coordonnees, double largeur, double hauteur, Color couleur){
	// 	super(coordonnees, largeur, hauteur, couleur);
	// }
	
	// getters
	public Coordonnees getC1() {
		return super.getPosition();
	}
	public Coordonnees getC2() {
		double abs, ord;
		abs = this.getC1().getAbscisse() + super.getLargeur();
		ord = this.getC1().getOrdonnee() + super.getHauteur();
		return new Coordonnees(abs, ord);
	}
	
	// setters
	public void setC1(Coordonnees coord) {
		super.setLargeur(this.getC2().getAbscisse() - coord.getAbscisse());
		super.setHauteur(this.getC2().getOrdonnee() - coord.getOrdonnee());
		super.setPosition(coord);
	}
	public void setC2(Coordonnees coord) {
		super.setLargeur(coord.getAbscisse() - this.getC1().getAbscisse());
		super.setHauteur(coord.getOrdonnee() - this.getC1().getOrdonnee());
	}
	
	// personal methodes
	private String radToDeg(DecimalFormat format) {
		String angle;
		if(this.getC1().angleVers(this.getC2())*180/Math.PI>=0) {
			angle = "" + format.format(this.getC1().angleVers(this.getC2())*180/Math.PI);
		} else {
			angle = "" + format.format(this.getC1().angleVers(this.getC2())*180/Math.PI + 360);
		}
		return angle;
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
	public String toString() {
		Locale locale = Locale.getDefault();
		DecimalFormat decimalFormat = new DecimalFormat("0.0#");
		String angle = this.radToDeg(decimalFormat);
		return "[Ligne] c1 : (" +decimalFormat.format(this.getC1().getAbscisse())
			+ " , " +decimalFormat.format(this.getC1().getOrdonnee())
			+ ") c2 : (" +decimalFormat.format(this.getC2().getAbscisse())
			+ " , " +decimalFormat.format(this.getC2().getOrdonnee())
			+ ") longueur : " +decimalFormat.format(this.perimetre())
			+ " angle : " +angle +"°"
			+ " couleur = "+this.getCorrectColor(locale);		
	}
	public double aire() {
		return 0;
	}
	public double perimetre() {
		return this.getC1().distanceVers(this.getC2());
	}
	public boolean contient(Coordonnees position) {
		double distanceC1 = Math.abs(this.getC1().distanceVers(position));
		double distanceC2 = Math.abs(this.getC2().distanceVers(position));
		double distanceC1C2 = Math.abs(this.getC1().distanceVers(this.getC2()));
		double distance = distanceC1 + distanceC2 - distanceC1C2;
		return(distance<=EPSILON);
	}
}
