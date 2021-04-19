package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class LigneTest {
	public static final double EPSILON = 0.2;

	// instances
	Coordonnees defaultCoord = new Coordonnees();
	Ligne defaultLigne = new Ligne();

	/*
	*  CONSTRUCTEURS
	*/

	// constructeur vide
	@Test
	public void emptyConstructor(){
		assertEquals("defaultCoordAbs", defaultCoord.getAbscisse(), defaultLigne.getPosition().getAbscisse(), EPSILON);
		assertEquals("defaultCoordOrd", defaultCoord.getOrdonnee(), defaultLigne.getPosition().getOrdonnee(), EPSILON);
		assertEquals("defaultLargeur", 100.0, defaultLigne.getLargeur(), EPSILON);
		assertEquals("defaultHauteur", 100.0, defaultLigne.getHauteur(), EPSILON);
	}
	// constructeur dimensions
	@Test
	public void dimConstructor(){
		Ligne ligne1 = new Ligne(25, 45);
		assertEquals("defaultCoordAbs", defaultCoord.getAbscisse(), ligne1.getPosition().getAbscisse(), EPSILON);
		assertEquals("defaultCoordOrd", defaultCoord.getOrdonnee(), ligne1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("defaultLargeur", 25.0, ligne1.getLargeur(), EPSILON);
		assertEquals("defaultHauteur", 45.0, ligne1.getHauteur(), EPSILON);
	}
	// constructeur position
	@Test
	public void posConstructor(){
		Coordonnees coord1 = new Coordonnees(4, -7);
		Ligne ligne1 = new Ligne(coord1);
		assertEquals("defaultCoordAbs", 4, ligne1.getPosition().getAbscisse(), EPSILON);
		assertEquals("defaultCoordOrd", -7, ligne1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("defaultLargeur", 100.0, ligne1.getLargeur(), EPSILON);
		assertEquals("defaultHauteur", 100.0, ligne1.getHauteur(), EPSILON);
	}
	// constructeur position et dimensions
	@Test
	public void fullConstructor(){
		Coordonnees coord1 = new Coordonnees(4, -7);
		Ligne ligne1 = new Ligne(coord1, 20, 90);
		assertEquals("defaultCoordAbs", 4, ligne1.getPosition().getAbscisse(), EPSILON);
		assertEquals("defaultCoordOrd", -7, ligne1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("defaultLargeur", 20.0, ligne1.getLargeur(), EPSILON);
		assertEquals("defaultHauteur", 90.0, ligne1.getHauteur(), EPSILON);
	}

	/*
	*  SETTERS
	*/

	// set c1
	@Test
	public void setC1(){
		Coordonnees coord = new Coordonnees(4, 8);
		defaultLigne.setC1(coord);
		assertEquals("SetC1Abs", coord.getAbscisse(), defaultLigne.getC1().getAbscisse(), EPSILON);
		assertEquals("SetC1Ord", coord.getOrdonnee(), defaultLigne.getC1().getOrdonnee(), EPSILON);
	}
	// set c2
	@Test
	public void setC2(){
		Coordonnees coord = new Coordonnees(4, 8);
		defaultLigne.setC2(coord);
		assertEquals("SetC2Abs", coord.getAbscisse(), defaultLigne.getC2().getAbscisse(), EPSILON);
		assertEquals("SetC2Ord", coord.getOrdonnee(), defaultLigne.getC2().getOrdonnee(), EPSILON);
	}
	// set couleur
	@Test
	public void setCouleurT(){
		Ligne ligne = new Ligne();
		ligne.setCouleur(Color.RED);
		assertEquals("getCouleur", Color.RED, ligne.getCouleur());
	}

	/*
	*  METHODES
	*/

	// aire
	@Test
	public void testAire(){
		Ligne testLigne = new Ligne(defaultCoord, 2.0, 2.0);
		assertEquals("Aire", 0.0, testLigne.aire(), EPSILON);
	}
	// perimetre
	@Test
	public void testPerimetre() {
		Ligne testLigne = new Ligne(4.0, 6.0);
		assertEquals("Perimetre", Math.sqrt(Math.pow(4.0, 2)+Math.pow(6.0, 2)), testLigne.perimetre(), EPSILON);
	}
	// cadre max
	@Test
	public void cadreMax(){
		Ligne testLigne = new Ligne(3.0, 3.0);
		assertEquals("cadreMaxX", 3.0, testLigne.getCadreMaxX(), EPSILON);
		assertEquals("cadreMaxY", 3.0, testLigne.getCadreMaxY(), EPSILON);
	}
	// cadre min
	@Test
	public void cadreMin(){
		Ligne testLigne = new Ligne(3.0, 3.0);
		assertEquals("cadreMinX", 0.0, testLigne.getCadreMinX(), EPSILON);
		assertEquals("cadreMinY", 0.0, testLigne.getCadreMinY(), EPSILON);
	}
	// cadre min y1
	@Test
	public void testGetCadreMinY() {
		Ligne ligne = new Ligne(new Coordonnees(77, 177), 156, 100);
		assertEquals("cadreminY", 177, ligne.getCadreMinY(), EPSILON);
	}
	// cadre min y2
	@Test
	public void testGetCadreMinY2() {
		Ligne ligne = new Ligne(new Coordonnees(), 5.0, 10.0);
		ligne.setC2(new Coordonnees(-5, -10));
		assertEquals("cadreminY2", -10, ligne.getCadreMinY(), EPSILON);
	}
	// cadre min x1
	@Test
	public void testGetCadreMinX() {
		Ligne ligne = new Ligne(new Coordonnees(77, 177), 156, 100);
		assertEquals("cadreminY", 77, ligne.getCadreMinX(), EPSILON);
	}
	// cadre min x2
	@Test
	public void testGetCadreMinX2() {
		Ligne ligne = new Ligne(new Coordonnees(), 5.0, 10.0);
		ligne.setC2(new Coordonnees(-5, -10));
		assertEquals("cadreminY2", -5, ligne.getCadreMinX(), EPSILON);
	}
	// cadre max y1
	@Test
	public void testGetCadreMaxY() {
		Ligne ligne = new Ligne(new Coordonnees(77, 177), 156, 100);
		assertEquals("cadremaxY", 277, ligne.getCadreMaxY(), EPSILON);
	}
	// cadre max y2
	@Test
	public void testGetCadreMaxY2() {
		Ligne ligne = new Ligne(new Coordonnees(), 5.0, 10.0);
		ligne.setC2(new Coordonnees(-5, -10));
		assertEquals("cadremaxY2", 0, ligne.getCadreMaxY(), EPSILON);
	}
	// cadre max x1
	@Test
	public void testGetCadreMaxX() {
		Ligne ligne = new Ligne(new Coordonnees(77, 177), 156, 100);
		assertEquals("cadremaxY", 233, ligne.getCadreMaxX(), EPSILON);
	}
	// cadre max x2
	@Test
	public void testGetCadreMaxX2() {
		Ligne ligne = new Ligne(new Coordonnees(), 5.0, 10.0);
		ligne.setC2(new Coordonnees(-5, -10));
		assertEquals("cadremaxY2", 0, ligne.getCadreMaxX(), EPSILON);
	}
	// deplacer de
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
	// deplacer vers
	@Test
	public void deplacerVers(){
		Coordonnees coord = new Coordonnees(2.0, 2.0);
		Ligne testLigne = new Ligne(coord, 1.0, 1.0);
		assertEquals("c1Abs", 2.0, testLigne.getC1().getAbscisse(), EPSILON);
		assertEquals("c1Ord", 2.0, testLigne.getC1().getOrdonnee(), EPSILON);
		assertEquals("c2Abs", 3.0, testLigne.getC2().getAbscisse(), EPSILON);
		assertEquals("c2Ord", 3.0, testLigne.getC2().getOrdonnee(), EPSILON);
		testLigne.deplacerVers(4.0, 5.0);
		assertEquals("Newc1Abs", 4.0, testLigne.getC1().getAbscisse(), EPSILON);
		assertEquals("Newc1Ord", 5.0, testLigne.getC1().getOrdonnee(), EPSILON);
		assertEquals("Newc2Abs", 5.0, testLigne.getC2().getAbscisse(), EPSILON);
		assertEquals("Newc2Ord", 6.0, testLigne.getC2().getOrdonnee(), EPSILON);
	}
	// toString fr
	@Test
	public void toStringt(){
		Coordonnees coord = new Coordonnees(3.0, 3.0);
		defaultLigne.setC1(coord);
		defaultLigne.setC2(defaultCoord);
		assertEquals(
			"toString",
			"[Ligne] c1 : (3,0 , 3,0) c2 : (0,0 , 0,0) longueur : 4,24 angle : 225,0° couleur = R51,V51,B51",
			defaultLigne.toString()
		);
	}
	// toString en
	@Test
	public void toStringEn(){
		Coordonnees coord = new Coordonnees(3.0, 3.0);
		Locale.setDefault(Locale.ENGLISH);
		defaultLigne.setC1(coord);
		defaultLigne.setC2(defaultCoord);
		String result = "[Ligne] c1 : (3.0 , 3.0) c2 : (0.0 , 0.0) longueur : 4.24 angle : 225.0° couleur = R51,G51,B51";
		assertEquals(
			"toString",
			result,
			defaultLigne.toString()
		);
	}
	// toString other
	@Test
	public void toStringOther(){
		Coordonnees coord = new Coordonnees(3.0, 3.0);
		Locale.setDefault(Locale.CHINA);
		defaultLigne.setC1(coord);
		defaultLigne.setC2(defaultCoord);
		String result = "[Ligne] c1 : (3.0 , 3.0) c2 : (0.0 , 0.0) longueur : 4.24 angle : 225.0° couleur = Bad Language";
		assertEquals(
			"toString",
			result,
			defaultLigne.toString()
		);
	}
	// radToDeg (methode perso)
	@Test
	public void toStringRadToDeg() {
		Ligne ligne = new Ligne();
		ligne.setC1(new Coordonnees(5, 5));
		ligne.setC2(new Coordonnees(10, 10));
		String result = "[Ligne] c1 : (5,0 , 5,0) c2 : (10,0 , 10,0) longueur : 7,07 angle : 45,0° couleur = R51,V51,B51";
		assertEquals("toString radtodeg: ", result, ligne.toString());
	}
	// contient true
	@Test
	public void contientTrue(){
		Coordonnees testCoord = new Coordonnees(2.0, 2.0);
		Ligne testLigne = new Ligne(testCoord, 1.0, 1.0);
		assertEquals("contientTrue", true, testLigne.contient(testCoord));
	}
	// contient false
	@Test
	public void contientFalse(){
		Coordonnees testCoord = new Coordonnees(2.0, 2.0);
		Coordonnees compare = new Coordonnees(75.0, 75.0);
		Ligne testLigne = new Ligne(testCoord, 1.0, 1.0);
		assertEquals("contientFalse", false, testLigne.contient(compare));
	}
}
