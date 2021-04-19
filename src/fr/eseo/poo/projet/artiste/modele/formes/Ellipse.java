package fr.eseo.poo.projet.artiste.modele.formes;

// external imports
import java.util.Locale;
import java.text.DecimalFormat;

// internal imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Ellipse extends Forme implements Remplissable {

	// class constants
	public static final double EPSILON = 0.2;

	// attributes
	public boolean estRempli;

	// constructors
	public Ellipse(){
		super();
		this.estRempli = false;
	}
	public Ellipse(double largeur, double hauteur){
		super(largeur, hauteur);
		isNegative();
		this.estRempli = false;
	}
	public Ellipse(Coordonnees coordonnees){
		super(coordonnees);
	}
	public Ellipse(Coordonnees coordonnees, double largeur, double hauteur){
		super(coordonnees, largeur, hauteur);
		isNegative();
		this.estRempli = false;
	}
	
	// getters
	public boolean estRempli(){
		return this.estRempli;
	}
	
	// setters
	public void setHauteur(double hauteur){
		super.setHauteur(hauteur);
		isNegative();
	}
	public void setLargeur(double largeur){
		super.setLargeur(largeur);
		isNegative();
	}
	public void setRempli(boolean rempli){
		this.estRempli = rempli;
	}

	// methodes
	public String toString(){
		String couleur = "";
		Locale locale = Locale.getDefault();
		DecimalFormat decimalFormat = new DecimalFormat("0.0#");
		Coordonnees bufferCoord = super.getPosition();
		if(locale.getLanguage().equals("fr")){
			couleur="R"+getCouleur().getRed()+",V"+getCouleur().getGreen()+",B"+getCouleur().getBlue();
		} else if(locale.getLanguage().equals("en")){
			couleur="R"+getCouleur().getRed()+",G"+getCouleur().getGreen()+",B"+getCouleur().getBlue();
		} else {
			couleur="Bad Language";
		}
		String rempli="";
		if(this.estRempli()){
			rempli="-Rempli";
		}
		return "[Ellipse"+rempli+ "] : pos ("+decimalFormat.format(bufferCoord.getAbscisse())+" , "
			+decimalFormat.format(bufferCoord.getOrdonnee())
			+") dim "+decimalFormat.format(super.getLargeur())+" x "+decimalFormat.format(super.getHauteur())
			+" périmètre : "+decimalFormat.format(this.perimetre())
			+" aire : "+decimalFormat.format(this.aire())
			+" couleur = "+couleur;
	}
	public double aire() {
		return Math.PI*(super.getLargeur()/2)*(super.getHauteur()/2);
	}
	public double perimetre() {
		double a = super.getLargeur()/2;
		double b = super.getHauteur()/2;
		double h = Math.pow(
			(a-b)/(a+b),
			2
		);
		return Math.PI*(a+b)*(1+((3*h)/(10+Math.sqrt(4-3*h))));
	}
	public void isNegative(){
		if(super.getLargeur()<0){
			throw new IllegalArgumentException("Largeur negative");
		}
		if(super.getHauteur()<0){
			throw new IllegalArgumentException("Hauteur negative");
		}
	}
	public boolean contient(Coordonnees position){
		return ((Math.pow(position.getAbscisse() - (this.getPosition().getAbscisse()
			+ this.getLargeur() / 2), 2) / (Math.pow(this.getLargeur() / 2, 2))
			+ Math.pow(position.getOrdonnee() - (this.getPosition().getOrdonnee()
			+ this.getHauteur() / 2), 2) / (Math.pow(this.getHauteur() / 2, 2))) <= 1
		);
	}
}
