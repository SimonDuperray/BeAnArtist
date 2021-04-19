package fr.eseo.poo.projet.artiste.modele;

// external imports
import java.text.DecimalFormat;
import java.util.Objects;

public class Coordonnees {

	// class constants
	public static final double ABSCISSE_PAR_DEFAUT = 0.0;
	public static final double ORDONNEE_PAR_DEFAUT = 0.0;
	
	// attributes
	private double abscisse;
	private double ordonnee;
	
	// constructors
	public Coordonnees() {
		this.abscisse=ABSCISSE_PAR_DEFAUT;
		this.ordonnee=ORDONNEE_PAR_DEFAUT;
	}
	public Coordonnees(double abscisse, double ordonnee) {
		this.abscisse=abscisse;
		this.ordonnee=ordonnee;
	}
	
	// getters
	public double getAbscisse() {
		return this.abscisse;
	}
	public double getOrdonnee() {
		return this.ordonnee;
	}
	
	// setters
	public void setAbscisse(double abscisse) {
		this.abscisse=abscisse;
	}
	public void setOrdonnee(double ordonnee) {
		this.ordonnee=ordonnee;
	}
	
	// methodes
	public void deplacerDe(double deltaX, double deltaY) {
		this.abscisse+=deltaX;
		this.ordonnee+=deltaY;
	}
	public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
		this.abscisse=nouvelleAbscisse;
		this.ordonnee=nouvelleOrdonnee;
	}
	public double distanceVers(Coordonnees coord){
		return Math.sqrt(Math.pow((coord.getAbscisse() - this.getAbscisse()), 2) 
			+ Math.pow((coord.getOrdonnee() - this.getOrdonnee()), 2));
	}
	public double angleVers(Coordonnees coord) {
      return ((
			Math.atan2(coord.getOrdonnee() - this.getOrdonnee(),
			coord.getAbscisse() - this.getAbscisse())
		));
   }
	public String toString(){
		DecimalFormat format = new DecimalFormat("0.0#");
		return "("+format.format(this.getAbscisse())+" , "+format.format(this.getOrdonnee())+")";
	}
	public int hashCode() {
		return Objects.hash(abscisse, ordonnee);
	}
	public boolean equals(Object object) {
		if(this==object) {
			return true;
		}
		if(object==null) {
			return false;
		}
		if(getClass()!=object.getClass()) {
			return false;
		}
		Coordonnees other = (Coordonnees)object;
		return Double.doubleToLongBits(abscisse) == Double.doubleToLongBits(other.abscisse)
				&& Double.doubleToLongBits(ordonnee) == Double.doubleToLongBits(other.ordonnee);
	}
}
