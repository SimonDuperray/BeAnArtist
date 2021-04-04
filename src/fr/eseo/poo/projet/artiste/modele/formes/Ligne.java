package fr.eseo.poo.projet.artiste.modele.formes;

// import component
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import java.text.DecimalFormat;
// external imports
import java.util.Locale;
import java.awt.Color;

public class Ligne extends Forme {

	public static final double EPSILON = 0.2;

	// constructeurs
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
	public Ligne(Coordonnees coordonnees, double largeur, double hauteur, Color couleur){
		super(coordonnees, largeur, hauteur, couleur);
	}
	
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
	
	// methodes
	private String radToDeg(DecimalFormat format) {
		String angle;
		if(this.getC1().angleVers(this.getC2())*180/Math.PI>=0) {
			angle = "" + format.format(this.getC1().angleVers(this.getC2())*180/Math.PI);
		} else {
			angle = "" + format.format(this.getC1().angleVers(this.getC2())*180/Math.PI + 360);
		}
		return angle;
	}
	public String toString() {
		String couleur="";
		Locale locale = Locale.getDefault();
		DecimalFormat decimalFormat = new DecimalFormat("0.0#");
		if(locale.getLanguage()=="fr"){
			couleur="R"+getCouleur().getRed()+",V"+getCouleur().getGreen()+",B"+getCouleur().getBlue();
		} else if(locale.getLanguage()=="en"){
			couleur="R"+getCouleur().getRed()+",G"+getCouleur().getGreen()+",B"+getCouleur().getBlue();
		} else {
			couleur="Bad Language";
		}
		String angle = this.radToDeg(decimalFormat);
		return "[Ligne] c1 : (" +decimalFormat.format(this.getC1().getAbscisse())
			+ " , " +decimalFormat.format(this.getC1().getOrdonnee())
			+ ") c2 : (" +decimalFormat.format(this.getC2().getAbscisse())
			+ " , " +decimalFormat.format(this.getC2().getOrdonnee())
			+ ") longueur : " +decimalFormat.format(this.perimetre())
			+ " angle : " +angle +"°"
			+ " couleur = "+couleur;		
	}
		
	@Override
	public double aire() {
		return 0;
	}

	@Override
	public double perimetre() {
		return this.getC1().distanceVers(this.getC2());
	}
	public boolean contient(Coordonnees position) {
		double distanceC1 = Math.abs(this.getC1().distanceVers(position));
		double distanceC2 = Math.abs(this.getC2().distanceVers(position));
		double distanceC1C2 = Math.abs(this.getC1().distanceVers(this.getC2()));
		double distance = distanceC1 + distanceC2 - distanceC1C2;
		if(distance<=EPSILON){
			return true;
		} else {
			return false;
		}
	}
	
}
