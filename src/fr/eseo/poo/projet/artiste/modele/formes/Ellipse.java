package fr.eseo.poo.projet.artiste.modele.formes;

// import component
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

// external imports
import java.util.Locale;
import java.text.DecimalFormat;

public class Ellipse extends Forme {

	// constructeurs
	public Ellipse(){
		super();
	}
	public Ellipse(double largeur, double hauteur){
		super(largeur, hauteur);
	}
	public Ellipse(Coordonnees coordonnees){
		super(coordonnees);
	}
	public Ellipse(Coordonnees coordonnees, double largeur, double hauteur){
		super(coordonnees, largeur, hauteur);
	}

	// setters
	public void setHauteur(double hauteur){
		super.setHauteur(hauteur);
	}
	public void setLargeur(double largeur){
		super.setLargeur(largeur);
	}

	// methodes
	public String toString(){
		Locale locale = new Locale("fr");
		DecimalFormat decimalFormat = new DecimalFormat("0.0#");
		if(locale.getLanguage()=="fr"){
			Coordonnees bufferCoord = super.getPosition();
			return "[Ellipse] : pos ("+decimalFormat.format(bufferCoord.getAbscisse())+" , "
				+decimalFormat.format(bufferCoord.getOrdonnee())
				+") dim "+decimalFormat.format(super.getLargeur())+" x "+decimalFormat.format(super.getHauteur())
				+" périmètre : "+decimalFormat.format(this.perimetre())
				+" aire : "+decimalFormat.format(this.aire());
		} else {
			return "Bad language";
		}
	}
	@Override
	public double aire() {
		return Math.PI*(super.getLargeur()/2)*(super.getHauteur()/2);
	}

	@Override
	public double perimetre() {
		double a = super.getLargeur()/2;
		double b = super.getHauteur()/2;
		double h = Math.pow(
			(a-b)/(a+b),
			2
		);
		return Math.PI*(a+b)*(1+((3*h)/(10+Math.sqrt(4-3*h))));
	}

}
