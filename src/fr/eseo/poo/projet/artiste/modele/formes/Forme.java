package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public abstract class Forme {
	// constantes de classe
	public static final double LARGEUR_PAR_DEFAUT = 100.0;
	public static final double HAUTEUR_PAR_DEFAUT = 50.0;
	
	// attributs
	private Coordonnees position;
	private double largeur, hauteur;
	
	// constructeurs
	public Forme() {
		this.position = new Coordonnees();
		this.largeur=LARGEUR_PAR_DEFAUT;
		this.hauteur=HAUTEUR_PAR_DEFAUT;
	}
	public Forme(double largeur, double hauteur) {
		this.position = new Coordonnees();
		this.largeur=largeur;
		this.hauteur=hauteur;
	}
	public Forme(Coordonnees position) {
		this.position = position;
		this.largeur=LARGEUR_PAR_DEFAUT;
		this.hauteur=HAUTEUR_PAR_DEFAUT;
	}
	public Forme(Coordonnees position, double largeur, double hauteur) {
		this.position = position;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	
	// bonus functions
	private double getFX() {
		return this.getPosition().getAbscisse();
	}
	private double getFY() {
		return this.getPosition().getOrdonnee();
	}
	
	// getters
	public Coordonnees getPosition() {
		return this.position;
	}
	public double getLargeur() {
		return this.largeur;
	}
	public double getHauteur() {
		return this.hauteur;
	}
	
	public double getCadreMinX() {
		if(this.getFX()<this.getFX()+this.getLargeur()) {
			return this.getFX();
		} else {
			return this.getFX() + this.getLargeur();
		}
	}
	public double getCadreMinY() {
		if(this.getFY() < this.getFY() + this.getHauteur()) {
			return this.getFY();
		} else {
			return this.getFY() + this.getHauteur();
		}
	}
	
	public double getCadreMaxX() {
		if(this.getFX() > this.getFX() + this.getLargeur()) {
			return this.getFX();
		} else {
			return this.getFX() + this.getLargeur();
		}
	}
	public double getCadreMaxY() {
		if(this.getFY() > this.getFY() + this.getHauteur()) {
			return this.getFY();
		} else {
			return this.getFY() + this.getHauteur();
		}
	}
	
	// setters
	public void setPosition(Coordonnees position) {
		this.position = position;
	}
	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}
	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}
	
	// methodes
	public void deplacerDe(double deltaX, double deltaY) {
		this.position.setAbscisse(this.position.getAbscisse()+deltaX);
		this.position.setOrdonnee(this.position.getOrdonnee()+deltaY);
	}
	public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
		this.position.setAbscisse(nouvelleAbscisse);
		this.position.setOrdonnee(nouvelleOrdonnee);
	}
	public abstract double aire();
	public abstract double perimetre();
}
