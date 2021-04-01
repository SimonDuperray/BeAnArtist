package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class LigneTest {
	final double EPSILON = 0.1;

	// instanciations
	Coordonnees defaultCoord = new Coordonnees();
	Ligne defaultLigne = new Ligne();

	// constructeurs
	@Test
	public void emptyConstructor(){
		assertEquals("defaultCoordAbs", defaultCoord.getAbscisse(), defaultLigne.getPosition().getAbscisse(), EPSILON);
		assertEquals("defaultCoordOrd", defaultCoord.getOrdonnee(), defaultLigne.getPosition().getOrdonnee(), EPSILON);
		assertEquals("defaultLargeur", 100.0, defaultLigne.getLargeur(), EPSILON);
		assertEquals("defaultHauteur", 50.0, defaultLigne.getHauteur(), EPSILON);
	}
	@Test
	public void dimConstructor(){
		Ligne ligne1 = new Ligne(25, 45);
		assertEquals("defaultCoordAbs", defaultCoord.getAbscisse(), ligne1.getPosition().getAbscisse(), EPSILON);
		assertEquals("defaultCoordOrd", defaultCoord.getOrdonnee(), ligne1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("defaultLargeur", 25.0, ligne1.getLargeur(), EPSILON);
		assertEquals("defaultHauteur", 45.0, ligne1.getHauteur(), EPSILON);
	}
	@Test
	public void posConstructor(){
		Coordonnees coord1 = new Coordonnees(4, -7);
		Ligne ligne1 = new Ligne(coord1);
		assertEquals("defaultCoordAbs", 4, ligne1.getPosition().getAbscisse(), EPSILON);
		assertEquals("defaultCoordOrd", -7, ligne1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("defaultLargeur", 100.0, ligne1.getLargeur(), EPSILON);
		assertEquals("defaultHauteur", 50.0, ligne1.getHauteur(), EPSILON);
	}
	@Test
	public void fullConstructor(){
		Coordonnees coord1 = new Coordonnees(4, -7);
		Ligne ligne1 = new Ligne(coord1, 20, 90);
		assertEquals("defaultCoordAbs", 4, ligne1.getPosition().getAbscisse(), EPSILON);
		assertEquals("defaultCoordOrd", -7, ligne1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("defaultLargeur", 20.0, ligne1.getLargeur(), EPSILON);
		assertEquals("defaultHauteur", 90.0, ligne1.getHauteur(), EPSILON);
	}

	// setters
	@Test
	public void setC1(){
		Coordonnees coord = new Coordonnees(4, 8);
		defaultLigne.setC1(coord);
		assertEquals("SetC1Abs", coord.getAbscisse(), defaultLigne.getC1().getAbscisse(), EPSILON);
		assertEquals("SetC1Ord", coord.getOrdonnee(), defaultLigne.getC1().getOrdonnee(), EPSILON);
	}
	@Test
	public void setC2(){
		Coordonnees coord = new Coordonnees(4, 8);
		defaultLigne.setC2(coord);
		assertEquals("SetC2Abs", coord.getAbscisse(), defaultLigne.getC2().getAbscisse(), EPSILON);
		assertEquals("SetC2Ord", coord.getOrdonnee(), defaultLigne.getC2().getOrdonnee(), EPSILON);
	}

	// proprietes
	@Test
	public void aire(){
		Ligne testLigne = new Ligne(defaultCoord, 2.0, 2.0);
		assertEquals("Aire", 0.0, testLigne.aire(), EPSILON);
	}
	@Test
	public void perimetre() {
		Ligne testLigne = new Ligne(4.0, 6.0);
		assertEquals("Perimetre", Math.sqrt(Math.pow(4.0, 2)+Math.pow(6.0, 2)), testLigne.perimetre(), EPSILON);
	}

	// cadres
	@Test
	public void cadreMax(){
		Ligne testLigne = new Ligne(3.0, 3.0);
		assertEquals("cadreMaxX", 3.0, testLigne.getCadreMaxX(), EPSILON);
		assertEquals("cadreMaxY", 3.0, testLigne.getCadreMaxY(), EPSILON);
	}
	@Test
	public void cadreMin(){
		Ligne testLigne = new Ligne(3.0, 3.0);
		assertEquals("cadreMinX", 0.0, testLigne.getCadreMinX(), EPSILON);
		assertEquals("cadreMinY", 0.0, testLigne.getCadreMinY(), EPSILON);
	}

	// deplacements
	@Test
	public void deplacerDe(){
		Coordonnees coord = new Coordonnees(3, 3);
		Ligne testLigne = new Ligne(coord, 2.0, 2.0);
		testLigne.deplacerDe(4.0, 3.0);
		assertEquals("c1Abs", 7.0, testLigne.getC1().getAbscisse(), EPSILON);
		assertEquals("c1Ord", 6.0, testLigne.getC1().getOrdonnee(), EPSILON);
		assertEquals("c2Abs", 9.0, testLigne.getC2().getAbscisse(), EPSILON);
		assertEquals("c2Ord", 8.0, testLigne.getC2().getOrdonnee(), EPSILON);
	}
	@Test
	public void deplacerVers(){
		Coordonnees coord = new Coordonnees(2.0, 2.0);
		Ligne testLigne = new Ligne(coord, 1.0, 1.0);
		assertEquals("c1Abs", 2.0, testLigne.getC1().getAbscisse(), EPSILON);
		assertEquals("c1Ord", 2.0, testLigne.getC1().getOrdonnee(), EPSILON);
		assertEquals("c2Abs", 3.0, testLigne.getC2().getAbscisse(), EPSILON);
		assertEquals("c2Ord", 3.0, testLigne.getC2().getOrdonnee(), EPSILON);
	}

	// toString
	@Test
	public void toStringt(){
		Coordonnees coord = new Coordonnees(3.0, 3.0);
		defaultLigne.setC1(coord);
		defaultLigne.setC2(defaultCoord);
		assertEquals(
			"toString",
			"[Ligne] c1 : (3,0 , 3,0) c2 : (0,0 , 0,0) longueur : 4,24 angle : 225,0°",
			defaultLigne.toString()
		);
	}

}
