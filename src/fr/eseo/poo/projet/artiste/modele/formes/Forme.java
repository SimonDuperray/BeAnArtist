package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import java.awt.Color;
import javax.swing.UIManager;

public abstract class Forme implements fr.eseo.poo.projet.artiste.modele.Coloriable {
	// constantes de classe
	public static final double LARGEUR_PAR_DEFAUT = 100.0;
	public static final double HAUTEUR_PAR_DEFAUT = 100.0;
	public static final double EPSILON = 0.2;
	public static final Color COULEUR_PAR_DEFAUT = UIManager.getColor("Panel.foreground");

	// attributs
	private Coordonnees position;
	private double largeur, hauteur;
	private Color couleur;
	
	// constructeurs
	public Forme() {
		this.position = new Coordonnees();
		this.largeur=LARGEUR_PAR_DEFAUT;
		this.hauteur=HAUTEUR_PAR_DEFAUT;
		this.couleur=COULEUR_PAR_DEFAUT;
	}
	public Forme(double largeur, double hauteur) {
		this.position = new Coordonnees();
		this.largeur=largeur;
		this.hauteur=hauteur;
		this.couleur=COULEUR_PAR_DEFAUT;
	}
	public Forme(Coordonnees position) {
		this.position = position;
		this.largeur=LARGEUR_PAR_DEFAUT;
		this.hauteur=HAUTEUR_PAR_DEFAUT;
		this.couleur=COULEUR_PAR_DEFAUT;
	}
	public Forme(Coordonnees position, double largeur, double hauteur) {
		this.position = position;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.couleur=COULEUR_PAR_DEFAUT;
	}
	public Forme(Coordonnees position, double largeur, double hauteur, Color couleur){
		this.position = position;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.couleur = couleur;
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
	public Color getCouleur(){
		return this.couleur;
	}

	// bonus functions
	private double getFX() {
		return this.getPosition().getAbscisse();
	}
	private double getFY() {
		return this.getPosition().getOrdonnee();
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
	public void setCouleur(Color couleur){
		this.couleur=couleur;
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
	public abstract boolean contient(Coordonnees position);
}
