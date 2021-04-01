package fr.eseo.poo.projet.artiste.modele.formes;

// import component
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import java.text.DecimalFormat;
// external imports
import java.util.Locale;

public class Ligne extends Forme {
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
		Locale locale = new Locale("fr");
		DecimalFormat decimalFormat = new DecimalFormat("0.0#");
		if(locale.getLanguage()=="fr") {
			String angle = this.radToDeg(decimalFormat);
			return "[Ligne] c1 : (" +decimalFormat.format(this.getC1().getAbscisse())
				+ " , " +decimalFormat.format(this.getC1().getOrdonnee())
				+ ") c2 : (" +decimalFormat.format(this.getC2().getAbscisse())
				+ " , " +decimalFormat.format(this.getC2().getOrdonnee())
				+ ") longueur : " +decimalFormat.format(this.perimetre())
				+ " angle : " +angle +"°";
		} else {
			return "Bad Language";
		}
		
	}
		
	@Override
	public double aire() {
		return 0;
	}

	@Override
	public double perimetre() {
		return this.getC1().distanceVers(this.getC2());
	}
	
}
