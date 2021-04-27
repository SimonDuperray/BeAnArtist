package fr.eseo.poo.projet.artiste.modele.formes;

// external imports
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.awt.Color;
import java.util.Locale;

// internal imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class CarreTest {

	// class constants
	public static final double EPSILON = 0.2;

	// instances
	Carre defaultCarre = new Carre();
	Coordonnees defaultCoord = new Coordonnees();
	Coordonnees position = new Coordonnees(2.0, 5.0);

	/*
	*  CONSTRUCTEURS
	*/

	// constructeur vide
	@Test
	public void emptyConstructor(){
		assertEquals("emptyConstructorAbs", defaultCoord.getAbscisse(), defaultCarre.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", defaultCoord.getOrdonnee(), defaultCarre.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 100.0, defaultCarre.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 100.0, defaultCarre.getHauteur(), EPSILON);
	}
	// constructeur taille
	@Test
	public void dimConstructor(){
		Carre testCarre = new Carre(30.0);
		assertEquals("emptyConstructorAbs", defaultCoord.getAbscisse(), testCarre.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", defaultCoord.getOrdonnee(), testCarre.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 30.0, testCarre.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 30.0, testCarre.getHauteur(), EPSILON);
	}
	// constructeur position
	@Test
	public void coordConstructor(){
		Carre testCarre = new Carre(position);
		assertEquals("emptyConstructorAbs", position.getAbscisse(), testCarre.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", position.getOrdonnee(), testCarre.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 100.0, testCarre.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 100.0, testCarre.getLargeur(), EPSILON);
	}
	// constructeur position et taille
	@Test
	public void fullConstructor(){
		Carre testCarre = new Carre(position, 20.0);
		assertEquals("emptyConstructorAbs", position.getAbscisse(), testCarre.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", position.getOrdonnee(), testCarre.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 20.0, testCarre.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 20.0, testCarre.getHauteur(), EPSILON);
	}

	/*
	*  GETTERS
	*/
	
	// get rempli
	@Test
	public void testRempli(){
		defaultCarre.setRempli(true);
		assertEquals("estRempli", true, defaultCarre.estRempli());
	}

	/*
	*  SETTERS
	*/

	// set hauteur
	@Test
	public void setHauteur(){
		defaultCarre.setHauteur(100);
		assertEquals("setHauteur", 100, defaultCarre.getHauteur(), EPSILON);
	}
	// set largeur
	@Test
	public void setLargeur(){
		defaultCarre.setLargeur(200);
		assertEquals("setHauteur", 200, defaultCarre.getLargeur(), EPSILON);
	}
	// set couleur
	@Test
	public void setCouleurT(){
		defaultCarre.setCouleur(Color.RED);
		assertEquals("getCouleur", Color.RED, defaultCarre.getCouleur());
	}

	/*
	*  EXCEPTIONS
	*/

	// largeur negative
	@Test(expected = IllegalArgumentException.class)
	public void largeurNegative() {
		defaultCarre.setHauteur(-5);
	}

	/*
	*  METHODES
	*/

	// perimetre
	@Test
	public void testPerimetre(){
		Carre testCarre = new Carre(1.0);
		double perimetre = 4*testCarre.getLargeur();
		assertEquals(
			"perimetre",
			perimetre,
			testCarre.perimetre(), 
			EPSILON
		);
	}
	// aire
	@Test
	public void testAire(){
		Carre testCarre = new Carre(1.0);
		double aire = Math.pow(testCarre.getLargeur(), 2);
		assertEquals(
			"aire",
			aire,
			testCarre.aire(),
			EPSILON
		);
	}
	// toString fr
	@Test
	public void toStringt(){
		String result = "[Carré] : pos (0,0 , 0,0) dim 100,0 x 100,0 "+ "périmètre : 400,0 aire : 10000,0 couleur = R51,V51,B51";
		Locale.setDefault(Locale.FRANCE);
		assertEquals("toString", result, defaultCarre.toString());
	}
	// toString en - rempli
	@Test
	public void toStringtEn(){
		String result = "[Carré-Rempli] : pos (0.0 , 0.0) dim 100.0 x 100.0 "+ "périmètre : 400.0 aire : 10000.0 couleur = R51,G51,B51";
		Locale.setDefault(Locale.ENGLISH);
		defaultCarre.setRempli(true);
		assertEquals("toString", result, defaultCarre.toString());
		defaultCarre.setRempli(false);
	}
	// toString other
	@Test
	public void toStringtOther(){
		String result = "[Carré] : pos (0.0 , 0.0) dim 100.0 x 100.0 "+ "périmètre : 400.0 aire : 10000.0 couleur = Bad Language";
		Locale.setDefault(Locale.CHINA);
		assertEquals("toString", result, defaultCarre.toString());
	}
}
