package fr.eseo.poo.projet.artiste.modele.formes;

// external imports
import java.awt.Color;
import javax.swing.UIManager;

// internal imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Coloriable;
public abstract class Forme implements Coloriable {
	
	// class constants
	public static final double LARGEUR_PAR_DEFAUT = 100.0;
	public static final double HAUTEUR_PAR_DEFAUT = 100.0;
	public static final double EPSILON = 0.2;
	public static final Color COULEUR_PAR_DEFAUT = UIManager.getColor("Panel.foreground");
	public static final Coordonnees POSITION_PAR_DEFAUT = new Coordonnees();

	// attributes
	private Coordonnees position;
	private double largeur, hauteur;
	private Color couleur;
	
	// constructors
	public Forme() {
		this.position = POSITION_PAR_DEFAUT;
		this.largeur=LARGEUR_PAR_DEFAUT;
		this.hauteur=HAUTEUR_PAR_DEFAUT;
		this.couleur=COULEUR_PAR_DEFAUT;
	}
	public Forme(double largeur, double hauteur) {
		this.position = POSITION_PAR_DEFAUT;
		this.largeur=largeur;
		this.hauteur=hauteur;
		this.couleur=COULEUR_PAR_DEFAUT;
	}
	public Forme(Coordonnees position) {
		this.position = position;
		this.largeur = LARGEUR_PAR_DEFAUT;
		this.hauteur = HAUTEUR_PAR_DEFAUT;
		this.couleur = COULEUR_PAR_DEFAUT;
	}
	public Forme(Coordonnees position, double largeur, double hauteur) {
		this.position = position;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.couleur = COULEUR_PAR_DEFAUT;
	}
//	public Forme(Coordonnees position, double largeur, double hauteur, Color couleur){
//		this.position = position;
//		this.largeur = largeur;
//		this.hauteur = hauteur;
//		this.couleur = couleur;
//	}
	
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

	// personal methodes
	private double getFX() {
		return this.getPosition().getAbscisse();
	}
	private double getFY() {
		return this.getPosition().getOrdonnee();
	}
	
	public double getCadreMinX() {
		double cadreMinX;
		cadreMinX = this.getFX();
		if(this.getFX()>=this.getFX()+this.getLargeur()) {
			cadreMinX+=this.getLargeur();
		}
		return cadreMinX;
	}
	public double getCadreMinY() {
		double cadreMinY;
		cadreMinY = this.getFY();
		if(this.getFY()>=this.getFY()+this.getHauteur()) {
			cadreMinY+=this.getHauteur();
		}
		return cadreMinY;
	}
	
	public double getCadreMaxX() {
		double cadreMaxX;
		cadreMaxX = this.getFX();
		if(this.getFX()<=this.getFX()+this.getLargeur()){
			cadreMaxX+=this.getLargeur();
		}
		return cadreMaxX;
	}
	public double getCadreMaxY() {
		double cadreMaxY;
		cadreMaxY = this.getFY();
		if(this.getFY()<=this.getFY()+this.getHauteur()){
			cadreMaxY+=this.getHauteur();
		}
		return cadreMaxY;
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
	public void deplacerDe(double dx, double dy) {
		this.position.setAbscisse(this.position.getAbscisse()+dx);
		this.position.setOrdonnee(this.position.getOrdonnee()+dy);
	}
	public void deplacerVers(double nx, double ny) {
		this.position.setAbscisse(nx);
		this.position.setOrdonnee(ny);
	}

	// abtract methodes
	public abstract double aire();
	public abstract double perimetre();
	public abstract boolean contient(Coordonnees coord);
}
