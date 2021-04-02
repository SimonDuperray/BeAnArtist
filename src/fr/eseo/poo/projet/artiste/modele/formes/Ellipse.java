package fr.eseo.poo.projet.artiste.modele.formes;

// import component
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

// external imports
import java.util.Locale;
import java.text.DecimalFormat;

public class Ellipse extends Forme {

	public static final double EPSILON = 0.2;

	// constructeurs
	public Ellipse(){
		super();
	}
	public Ellipse(double largeur, double hauteur){
		super(largeur, hauteur);
		isNegative();
	}
	public Ellipse(Coordonnees coordonnees){
		super(coordonnees);
	}
	public Ellipse(Coordonnees coordonnees, double largeur, double hauteur){
		super(coordonnees, largeur, hauteur);
		isNegative();
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
	public void isNegative()
	{
		if (super.getLargeur()<0)
			throw new IllegalArgumentException("Largeur negative");
		if (super.getHauteur()<0)
			throw new IllegalArgumentException("Hauteur negative");
	}
	public boolean contient(Coordonnees position){
		return ((Math.pow(position.getAbscisse() - (this.getPosition().getAbscisse()
			+ this.getLargeur() / 2), 2) / (Math.pow(this.getLargeur() / 2, 2))
			+ Math.pow(position.getOrdonnee() - (this.getPosition().getOrdonnee()
			+ this.getHauteur() / 2), 2) / (Math.pow(this.getHauteur() / 2, 2))) <= 1
		);
	}

}
