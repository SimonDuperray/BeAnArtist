package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.awt.Color;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class CercleTest {

	public static final double EPSILON = 0.2;

	Cercle defaultCercle = new Cercle();
	Coordonnees defaultCoord = new Coordonnees();

	/*
	*  CONSTRUCTEURS
	*/

	// constructeur vide
	@Test
	public void emptyConstructor(){
		assertEquals("emptyConstructorAbs", defaultCoord.getAbscisse(), defaultCercle.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", defaultCoord.getOrdonnee(), defaultCercle.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 100.0, defaultCercle.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 100.0, defaultCercle.getHauteur(), EPSILON);
	}
	// constructeur taille
	@Test
	public void dimConstructor(){
		Cercle testCercle = new Cercle(30.0);
		assertEquals("emptyConstructorAbs", defaultCoord.getAbscisse(), testCercle.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", defaultCoord.getOrdonnee(), testCercle.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 30.0, testCercle.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 30.0, testCercle.getHauteur(), EPSILON);
	}
	// constructeur position
	@Test
	public void coordConstructor(){
		Coordonnees position = new Coordonnees(2.0, 5.0);
		Cercle testCercle = new Cercle(new Coordonnees(2.0, 5.0));
		assertEquals("emptyConstructorAbs", position.getAbscisse(), testCercle.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", position.getOrdonnee(), testCercle.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 100.0, testCercle.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 100.0, testCercle.getLargeur(), EPSILON);
	}
	// coordonnees position et taille
	@Test
	public void fullConstructor(){
		Coordonnees position = new Coordonnees(2.0, 5.0);
		Cercle testCercle = new Cercle(position, 20.0);
		assertEquals("emptyConstructorAbs", position.getAbscisse(), testCercle.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", position.getOrdonnee(), testCercle.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 20.0, testCercle.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 20.0, testCercle.getHauteur(), EPSILON);
	}

	/*
	*  GETTERS
	*/

	// get rempli
	@Test
	public void testRempli(){
		Cercle testCercle = new Cercle();
		testCercle.setRempli(true);
		assertEquals("estRempli", true, testCercle.estRempli());
	}

	/*
	*  SETTERS
	*/

	// set hauteur
	@Test
	public void setHauteur(){
		defaultCercle.setHauteur(100);
		assertEquals("setHauteur", 100, defaultCercle.getHauteur(), EPSILON);
	}
	// set largeur
	@Test
	public void setLargeur(){
		defaultCercle.setLargeur(200);
		assertEquals("setHauteur", 200, defaultCercle.getLargeur(), EPSILON);
	}
	// set couleur
	@Test
	public void setCouleurT(){
		Cercle cercle = new Cercle();
		cercle.setCouleur(Color.RED);
		assertEquals("getCouleur", Color.RED, cercle.getCouleur());
	}

	/*
	*  EXCEPTIONS
	*/

	// taille negative
	@Test(expected = IllegalArgumentException.class)
	public void testSetLargeurNegative() {
		Cercle cercle = new Cercle(-10);
	}

	/*
	*  METHODES
	*/

	// perimetre
	@Test
	public void testPerimetre(){
		Cercle testCercle = new Cercle(1.0);
		assertEquals(
			"perimetre",
			2*Math.PI*(testCercle.getLargeur()/2),
			testCercle.perimetre(), 
			EPSILON
		);
	}
	// aire
	@Test
	public void testAire(){
		Cercle testCercle = new Cercle(1.0);
		assertEquals(
			"aire",
			Math.PI*(testCercle.getLargeur()/2)*(testCercle.getHauteur()/2),
			testCercle.aire(),
			EPSILON
		);
	}
	// toString fr
	@Test
	public void toStringt(){
		String result = "[Cercle] : pos (0,0 , 0,0) dim 100,0 x 100,0 "+ "périmètre : 314,16 aire : 7853,98 couleur = R51,V51,B51";
		Locale.setDefault(Locale.FRANCE);
		assertEquals("toString", result, defaultCercle.toString());
	}
	// toString en
	@Test
	public void toStringEn() {
		String result = "[Cercle-Rempli] : pos (0.0 , 0.0) dim 100.0 x 100.0 "+ "périmètre : 314.16 aire : 7853.98 couleur = R51,G51,B51";
		Locale.setDefault(Locale.ENGLISH);
		defaultCercle.setRempli(true);
		assertEquals("toStringEn", result, defaultCercle.toString());
		defaultCercle.setRempli(false);
	}
	// toString other - rempli
	@Test
	public void toStringOther() {
		String result = "[Cercle-Rempli] : pos (0.0 , 0.0) dim 100.0 x 100.0 "+ "périmètre : 314.16 aire : 7853.98 couleur = Bad Language";
		Locale.setDefault(Locale.CHINA);
		defaultCercle.setRempli(true);
		assertEquals("toStringEn", result, defaultCercle.toString());
		defaultCercle.setRempli(false);
	}
}
