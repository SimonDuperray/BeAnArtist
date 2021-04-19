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

	// constructeurs
	@Test
	public void emptyConstructor(){
		assertEquals("emptyConstructorAbs", defaultCoord.getAbscisse(), defaultCarre.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", defaultCoord.getOrdonnee(), defaultCarre.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 100.0, defaultCarre.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 100.0, defaultCarre.getHauteur(), EPSILON);
	}
	@Test
	public void dimConstructor(){
		Carre testCarre = new Carre(30.0);
		assertEquals("emptyConstructorAbs", defaultCoord.getAbscisse(), testCarre.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", defaultCoord.getOrdonnee(), testCarre.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 30.0, testCarre.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 30.0, testCarre.getHauteur(), EPSILON);
	}
	@Test
	public void coordConstructor(){
		Carre testCarre = new Carre(position);
		assertEquals("emptyConstructorAbs", position.getAbscisse(), testCarre.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", position.getOrdonnee(), testCarre.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 100.0, testCarre.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 100.0, testCarre.getLargeur(), EPSILON);
	}
	@Test
	public void fullConstructor(){
		Carre testCarre = new Carre(position, 20.0);
		assertEquals("emptyConstructorAbs", position.getAbscisse(), testCarre.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", position.getOrdonnee(), testCarre.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 20.0, testCarre.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 20.0, testCarre.getHauteur(), EPSILON);
	}

	// getters
	@Test
	public void testRempli(){
		defaultCarre.setRempli(true);
		assertEquals("estRempli", true, defaultCarre.estRempli());
	}

	// setters
	@Test
	public void setHauteur(){
		defaultCarre.setHauteur(100);
		assertEquals("setHauteur", 100, defaultCarre.getHauteur(), EPSILON);
	}
	@Test
	public void setLargeur(){
		defaultCarre.setLargeur(200);
		assertEquals("setHauteur", 200, defaultCarre.getLargeur(), EPSILON);
	}
	@Test
	public void setCouleurT(){
		defaultCarre.setCouleur(Color.RED);
		assertEquals("getCouleur", Color.RED, defaultCarre.getCouleur());
	}

	// methodes
	@Test
	public void perimetret(){
		Carre testCarre = new Carre(1.0);
		double perimetre = 4*testCarre.getLargeur();
		assertEquals(
			"perimetre",
			perimetre,
			testCarre.perimetre(), 
			EPSILON
		);
	}
	@Test
	public void airet(){
		Carre testCarre = new Carre(1.0);
		double aire = Math.pow(testCarre.getLargeur(), 2);
		assertEquals(
			"aire",
			aire,
			testCarre.aire(),
			EPSILON
		);
	}
	@Test
	public void toStringt(){
		String result = "[Carré] : pos (0,0 , 0,0) dim 100,0 x 100,0 "+ "périmètre : 400,0 aire : 10000,0 couleur = R51,V51,B51";
		Locale.setDefault(Locale.FRANCE);
		assertEquals("toString", result, defaultCarre.toString());
	}

}
