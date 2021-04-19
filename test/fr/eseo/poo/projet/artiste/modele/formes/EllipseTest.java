package fr.eseo.poo.projet.artiste.modele.formes;

// external imports
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import java.awt.Color;
import java.util.Locale;

// internal imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class EllipseTest {

	public static final double EPSILON = 0.2;

	Coordonnees defaultCoord = new Coordonnees();
	Coordonnees coord = new Coordonnees(2.0, 2.0);
	Ellipse defaultEllipse = new Ellipse();
	Ellipse ellipseRemplie = new Ellipse();

	// constructeurs
	@Test
	public void emptyConstructor(){
		assertEquals("emptyConstructorAbs", defaultCoord.getAbscisse(), defaultEllipse.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", defaultCoord.getOrdonnee(), defaultEllipse.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 100.0, defaultEllipse.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 100.0, defaultEllipse.getHauteur(), EPSILON);
	}
	@Test
	public void dimConstructor(){
		Ellipse testEllipse = new Ellipse(20.0, 65.0);
		assertEquals("emptyConstructorAbs", defaultCoord.getAbscisse(), testEllipse.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", defaultCoord.getOrdonnee(), testEllipse.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 20.0, testEllipse.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 65.0, testEllipse.getHauteur(), EPSILON);
	}
	@Test
	public void coordConstructor(){
		Coordonnees position = new Coordonnees(2.0, 5.0);
		Ellipse testEllipse = new Ellipse(position);
		assertEquals("emptyConstructorAbs", position.getAbscisse(), testEllipse.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", position.getOrdonnee(), testEllipse.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 100, testEllipse.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 100.0, testEllipse.getHauteur(), EPSILON);
	}
	@Test
	public void fullConstructor(){
		Coordonnees position = new Coordonnees(2.0, 5.0);
		Ellipse testEllipse = new Ellipse(position, 20.0, 45.0);
		assertEquals("emptyConstructorAbs", position.getAbscisse(), testEllipse.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", position.getOrdonnee(), testEllipse.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 20.0, testEllipse.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 45.0, testEllipse.getHauteur(), EPSILON);
	}

	@Test
	public void testNonRempli(){
		assertEquals("estNonRempli", false, defaultEllipse.estRempli());
	}
	@Test
	public void testRempli(){
		ellipseRemplie.setRempli(true);
		assertEquals("estRempli", true, ellipseRemplie.estRempli());
	}

	// setters
	@Test
	public void setHauteur(){
		defaultEllipse.setHauteur(40.0);
		assertEquals("setHauteur", 40.0, defaultEllipse.getHauteur(), EPSILON);
		assertEquals("testGetLargeur", 100.0, defaultEllipse.getLargeur(), EPSILON);
	}
	@Test
	public void setLargeur(){
		defaultEllipse.setLargeur(40.0);
		assertEquals("setHauteur", 100.0, defaultEllipse.getHauteur(), EPSILON);
		assertEquals("testGetLargeur", 40.0, defaultEllipse.getLargeur(), EPSILON);
	}
	@Test
	public void setCouleurT(){
		defaultEllipse.setCouleur(Color.RED);
		assertEquals("getCouleur", Color.RED, defaultEllipse.getCouleur());
	}
	@Test(expected = IllegalArgumentException.class)
	public void whenExceptionThrownThenExpectationSatisfiedLargeurNegative() {
		defaultEllipse.setLargeur(-10);
	}
	@Test(expected = IllegalArgumentException.class)
	public void whenExceptionThrownThenExpectationSatisfiedHauteurNegative() {
		defaultEllipse.setHauteur(-10);
	}

	// methodes
	@Test
	public void toStringt(){
		String result = "[Ellipse] : pos (0,0 , 0,0) dim 100,0 x 100,0 "+ "périmètre : 314,16 aire : 7853,98 couleur = R51,V51,B51";
		Locale.setDefault(Locale.FRANCE);
		assertEquals("toString", result, defaultEllipse.toString());
	}
	@Test
	public void toStringEn() {
		String result = "[Ellipse-Rempli] : pos (0.0 , 0.0) dim 100.0 x 100.0 "+ "périmètre : 314.16 aire : 7853.98 couleur = R51,G51,B51";
		Locale.setDefault(Locale.ENGLISH);
		defaultEllipse.setRempli(true);
		assertEquals("toStringEn", result, defaultEllipse.toString());
		defaultEllipse.setRempli(false);
	}
	@Test
	public void toStringOther() {
		String result = "[Ellipse-Rempli] : pos (0.0 , 0.0) dim 100.0 x 100.0 "+ "périmètre : 314.16 aire : 7853.98 couleur = Bad Language";
		Locale.setDefault(Locale.CHINA);
		defaultEllipse.setRempli(true);
		assertEquals("toStringEn", result, defaultEllipse.toString());
		defaultEllipse.setRempli(false);
	}
	@Test
	public void airet(){
		Ellipse testEllipse = new Ellipse(34.0, 12.0);
		assertEquals("aire", 320.442, testEllipse.aire(), EPSILON);
	}
	@Test
	public void perimetret(){
		Ellipse testEllipse = new Ellipse(34.0, 12.0);
		assertEquals("aire", 76.45067, testEllipse.perimetre(), EPSILON);
	}

	// contient
	@Test
	public void contientTrue(){
		assertEquals(
			"contientTrue",
			true,
			defaultEllipse.contient(new Coordonnees(50.0, 50.0))
		);
	}
	@Test
	public void contientTrue2(){
		assertEquals(
			"contientIn",
			true,
			defaultEllipse.contient(new Coordonnees(0.0, 50.0))
		);
	}
	@Test
	public void contientFalse(){
		assertEquals(
			"contientTrue",
			false,
			defaultEllipse.contient(new Coordonnees(0.0, 0.0))
		);
	}

}
