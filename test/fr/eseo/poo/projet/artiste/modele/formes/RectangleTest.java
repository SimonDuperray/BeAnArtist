package fr.eseo.poo.projet.artiste.modele.formes;

// external imports
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.awt.Color;
import java.util.Locale;

// internal imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class RectangleTest {

	// class constants
	public static final double EPSILON = 0.2;

	// instances
	Rectangle defaultRectangle = new Rectangle();
	Rectangle rectangleRempli = new Rectangle();
	Coordonnees defaultCoord = new Coordonnees();
	Coordonnees position = new Coordonnees(2.0, 5.0);

	/*
	*  CONSTRUCTEURS
	*/

	// constructeur vide
	@Test
	public void emptyConstructor(){
		assertEquals("emptyConstructorAbs", defaultCoord.getAbscisse(), defaultRectangle.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", defaultCoord.getOrdonnee(), defaultRectangle.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 100.0, defaultRectangle.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 100.0, defaultRectangle.getHauteur(), EPSILON);
	}
	// constructeur dimensions
	@Test
	public void dimConstructor(){
		Rectangle testRectangle = new Rectangle(20.0, 65.0);
		assertEquals("emptyConstructorAbs", defaultCoord.getAbscisse(), testRectangle.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", defaultCoord.getOrdonnee(), testRectangle.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 20.0, testRectangle.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 65.0, testRectangle.getHauteur(), EPSILON);
	}
	// constructeur position
	@Test
	public void coordConstructor(){
		Rectangle testRectangle = new Rectangle(position);
		assertEquals("emptyConstructorAbs", position.getAbscisse(), testRectangle.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", position.getOrdonnee(), testRectangle.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 100, testRectangle.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 100.0, testRectangle.getHauteur(), EPSILON);
	}
	// constructeur position et dimensions
	@Test
	public void fullConstructor(){
		Rectangle testRectangle = new Rectangle(position, 20.0, 45.0);
		assertEquals("emptyConstructorAbs", position.getAbscisse(), testRectangle.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", position.getOrdonnee(), testRectangle.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 20.0, testRectangle.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 45.0, testRectangle.getHauteur(), EPSILON);
	}

	/*
	*  GETTERS
	*/

	// get rempli false
	@Test
	public void testNonRempli(){
		assertEquals("estNonRempli", false, defaultRectangle.estRempli());
	}
	// get remli true
	@Test
	public void testRempli(){
		rectangleRempli.setRempli(true);
		assertEquals("estRempli", true, rectangleRempli.estRempli());
	}

	/*
	*  SETTERS
	*/

	// set hauteur
	@Test
	public void setHauteur(){
		defaultRectangle.setHauteur(40.0);
		assertEquals("setHauteur", 40.0, defaultRectangle.getHauteur(), EPSILON);
		assertEquals("testGetLargeur", 100.0, defaultRectangle.getLargeur(), EPSILON);
	}
	// set largeur
	@Test
	public void setLargeur(){
		defaultRectangle.setLargeur(40.0);
		assertEquals("setHauteur", 100.0, defaultRectangle.getHauteur(), EPSILON);
		assertEquals("testGetLargeur", 40.0, defaultRectangle.getLargeur(), EPSILON);
	}
	// set couleur
	@Test
	public void setCouleurT(){
		defaultRectangle.setCouleur(Color.RED);
		assertEquals("getCouleur", Color.RED, defaultRectangle.getCouleur());
	}
	
	/*
	*  EXCEPTIONS
	*/

	// largeur negative
	@Test(expected = IllegalArgumentException.class)
	public void testLargeurNegative() {
		defaultRectangle.setLargeur(-10);
	}
	// hauteur negative
	@Test(expected = IllegalArgumentException.class)
	public void testHauteurNegative() {
		defaultRectangle.setHauteur(-10);
	}

	/*
	*  METHODES
	*/

	// toString fr
	@Test
	public void toStringt(){
		String result = "[Rectangle] : pos (0,0 , 0,0) dim 100,0 x 100,0 "
			+ "périmètre : 400,0 aire : 10000,0 couleur = R51,V51,B51";
		Locale.setDefault(Locale.FRANCE);
		assertEquals("toString", result, defaultRectangle.toString());
	}
	// toString en - rempli
	@Test
	public void toStringEn(){
		String result = "[Rectangle] : pos (0.0 , 0.0) dim 100.0 x 100.0 "
			+ "périmètre : 400.0 aire : 10000.0 couleur = R51,G51,B51";
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("toString", result, defaultRectangle.toString());
	}
	// toString other
	@Test
	public void toStringOther(){
		String result = "[Rectangle-Rempli] : pos (0.0 , 0.0) dim 100.0 x 100.0 "
			+ "périmètre : 400.0 aire : 10000.0 couleur = Bad Language";
		Locale.setDefault(Locale.CHINA);
		defaultRectangle.setRempli(true);
		assertEquals("toString", result, defaultRectangle.toString());
		defaultRectangle.setRempli(false);
	}
	// aire
	@Test
	public void testAire(){
		assertEquals("aire", 10000.0, defaultRectangle.aire(), EPSILON);
	}
	// perimetre
	@Test
	public void testPerimetre(){
		assertEquals("aire", 400.0, defaultRectangle.perimetre(), EPSILON);
	}
	// contient true
	@Test
	public void contientTrue(){
		assertEquals(
			"contientTrue",
			true,
			defaultRectangle.contient(new Coordonnees(50.0, 50.0))
		);
	}
	// contient false
	@Test
	public void contientFalse(){
		assertEquals(
			"contientTrue",
			false,
			defaultRectangle.contient(new Coordonnees(500.0, 120.0))
		);
	}
	// contient isInX
	@Test
	public void contientIsInX() {
		Rectangle rect = new Rectangle(new Coordonnees(), 6, 4);
		assertFalse("false isInX1", rect.contient(new Coordonnees(10, 10)));
		assertFalse("false isInX2", rect.contient(new Coordonnees(6, 10)));
		assertFalse("false isInX3", rect.contient(new Coordonnees(0, 10)));
		assertFalse("false isInX4", rect.contient(new Coordonnees(0, 10)));
		assertTrue("false isInY4", rect.contient(new Coordonnees(2, 2)));
	}
	// contient isInY
	@Test
	public void contientIsInY() {
		Rectangle rect = new Rectangle(new Coordonnees(), 6, 4);
		assertFalse("false isInY1", rect.contient(new Coordonnees(10, 10)));
		assertFalse("false isInY2", rect.contient(new Coordonnees(10, 4)));
		assertFalse("false isInY3", rect.contient(new Coordonnees(10, 0)));
		assertFalse("false isInY4", rect.contient(new Coordonnees(10, 0)));
		assertTrue("false isInY4", rect.contient(new Coordonnees(2, 2)));
	}
	// contient final
	@Test
	public void contientFinal() {
		Rectangle rect = new Rectangle(new Coordonnees(), 6, 4);
		assertFalse("false1", rect.contient(new Coordonnees(3, 100)));
		assertFalse("false2", rect.contient(new Coordonnees(100, 3)));
		assertFalse("false3", rect.contient(new Coordonnees(100, 100)));
		assertTrue("true1", rect.contient(new Coordonnees(3, 3)));
	}
}
