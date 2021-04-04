package fr.eseo.poo.projet.artiste.modele;

import java.text.DecimalFormat;

import java.util.Objects;

public class Coordonnees {
	// constantes de classe
	public static final double ABSCISSE_PAR_DEFAUT = 0.0;
	public static final double ORDONNEE_PAR_DEFAUT = 0.0;
	
	// attributs
	private double abscisse;
	private double ordonnee;
	
	// constructeurs
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
		return Math.sqrt(Math.pow((coord.getAbscisse() - this.getAbscisse()), 2) + Math.pow((coord.getOrdonnee() - this.getOrdonnee()), 2));
	}
	public double angleVers(Coordonnees coord) {
        return ((Math.atan2(coord.getOrdonnee() - this.getOrdonnee(),
        		coord.getAbscisse() - this.getAbscisse())));
   	}
	public String toString(){
		DecimalFormat format = new DecimalFormat("0.0#");
		return "("+format.format(this.getAbscisse())+" , "+format.format(this.getOrdonnee())+")";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(abscisse, ordonnee);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Coordonnees other = (Coordonnees) obj;
		return Double.doubleToLongBits(abscisse) == Double.doubleToLongBits(other.abscisse)
				&& Double.doubleToLongBits(ordonnee) == Double.doubleToLongBits(other.ordonnee);
	}
}
