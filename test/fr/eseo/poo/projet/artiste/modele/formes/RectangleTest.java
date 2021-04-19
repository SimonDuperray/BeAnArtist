package fr.eseo.poo.projet.artiste.modele.formes;

// external imports
import static org.junit.Assert.assertEquals;
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

	// TEST
	// constructors
	@Test
	public void emptyConstructor(){
		assertEquals("emptyConstructorAbs", defaultCoord.getAbscisse(), defaultRectangle.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", defaultCoord.getOrdonnee(), defaultRectangle.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 100.0, defaultRectangle.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 100.0, defaultRectangle.getHauteur(), EPSILON);
	}
	@Test
	public void dimConstructor(){
		Rectangle testRectangle = new Rectangle(20.0, 65.0);
		assertEquals("emptyConstructorAbs", defaultCoord.getAbscisse(), testRectangle.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", defaultCoord.getOrdonnee(), testRectangle.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 20.0, testRectangle.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 65.0, testRectangle.getHauteur(), EPSILON);
	}
	@Test
	public void coordConstructor(){
		Rectangle testRectangle = new Rectangle(position);
		assertEquals("emptyConstructorAbs", position.getAbscisse(), testRectangle.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", position.getOrdonnee(), testRectangle.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 100, testRectangle.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 100.0, testRectangle.getHauteur(), EPSILON);
	}
	@Test
	public void fullConstructor(){
		Rectangle testRectangle = new Rectangle(position, 20.0, 45.0);
		assertEquals("emptyConstructorAbs", position.getAbscisse(), testRectangle.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", position.getOrdonnee(), testRectangle.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 20.0, testRectangle.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 45.0, testRectangle.getHauteur(), EPSILON);
	}

	// getters
	@Test
	public void testNonRempli(){
		assertEquals("estNonRempli", false, defaultRectangle.estRempli());
	}
	@Test
	public void testRempli(){
		rectangleRempli.setRempli(true);
		assertEquals("estRempli", true, rectangleRempli.estRempli());
	}

	// setters
	@Test
	public void setHauteur(){
		defaultRectangle.setHauteur(40.0);
		assertEquals("setHauteur", 40.0, defaultRectangle.getHauteur(), EPSILON);
		assertEquals("testGetLargeur", 100.0, defaultRectangle.getLargeur(), EPSILON);
	}
	@Test
	public void setLargeur(){
		defaultRectangle.setLargeur(40.0);
		assertEquals("setHauteur", 100.0, defaultRectangle.getHauteur(), EPSILON);
		assertEquals("testGetLargeur", 40.0, defaultRectangle.getLargeur(), EPSILON);
	}
	@Test
	public void setCouleurT(){
		defaultRectangle.setCouleur(Color.RED);
		assertEquals("getCouleur", Color.RED, defaultRectangle.getCouleur());
	}

	// methodes
	@Test
	public void toStringt(){
		String result = "[Rectangle] : pos (0,0 , 0,0) dim 100,0 x 100,0 "
			+ "périmètre : 400,0 aire : 10000,0 couleur = R51,V51,B51";
		Locale.setDefault(Locale.FRANCE);
		assertEquals("toString", result, defaultRectangle.toString());
	}
	@Test
	public void airet(){
		assertEquals("aire", 10000.0, defaultRectangle.aire(), EPSILON);
	}
	@Test
	public void perimetret(){
		assertEquals("aire", 400.0, defaultRectangle.perimetre(), EPSILON);
	}
	@Test
	public void contientTrue(){
		assertEquals(
			"contientTrue",
			true,
			defaultRectangle.contient(new Coordonnees(50.0, 50.0))
		);
	}
	@Test
	public void contientFalse(){
		assertEquals(
			"contientTrue",
			false,
			defaultRectangle.contient(new Coordonnees(500.0, 120.0))
		);
	}
}
