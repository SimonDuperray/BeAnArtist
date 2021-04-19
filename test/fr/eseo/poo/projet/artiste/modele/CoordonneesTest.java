package fr.eseo.poo.projet.artiste.modele;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordonneesTest {
	
	// class constants
	static final double EPSILON = 0.2;
	
	// instances
	Coordonnees defaultCoordonnees = new Coordonnees();
	
	@Test
	public void testConstructeurVide() {
		assertEquals("EmptyConstructor", "(0,0 , 0,0)", defaultCoordonnees.toString());
	}
	@Test
	public void testConstructeur() {
		Coordonnees firstCoord = new Coordonnees(4.5, 7.2);
		assertEquals("Constructor", "(4,5 , 7,2)", firstCoord.toString());
		assertTrue("constructor", firstCoord.equals(new Coordonnees(4.5, 7.2)));
		Coordonnees secondCoord = new Coordonnees(4.54, 7.42);
		assertEquals("Constructor", "(4,54 , 7,42)", secondCoord.toString());
		assertTrue("constructor", secondCoord.equals(new Coordonnees(4.54, 7.42)));
	}
	
	@Test
	public void testGetDefaultCoord() {
		assertTrue("getDefaultCoord", defaultCoordonnees.equals(new Coordonnees(0, 0)));
		assertEquals("getDefaultAbs", 0, defaultCoordonnees.getAbscisse(), EPSILON);
		assertEquals("getDefaultCoo", 0, defaultCoordonnees.getOrdonnee(), EPSILON);
	}
	@Test
	public void testGetCoord() {
		Coordonnees firstCoord = new Coordonnees(3.43, 7.8);
		assertEquals("getAbs", 3.43, firstCoord.getAbscisse(), EPSILON);
		assertEquals("getOrd", 7.8, firstCoord.getOrdonnee(), EPSILON);
		assertTrue("getConstructor", firstCoord.equals(new Coordonnees(3.43, 7.8)));
	}
	
	@Test
	public void testSetCoord() {
		defaultCoordonnees.setAbscisse(2.34);
		defaultCoordonnees.setOrdonnee(-1.23);
		assertEquals("setAbs", 2.34, defaultCoordonnees.getAbscisse(), EPSILON);
		assertEquals("setOrd", -1.23, defaultCoordonnees.getOrdonnee(), EPSILON);
		assertTrue("getConstructor", defaultCoordonnees.equals(new Coordonnees(2.34, -1.23)));
	}
	
	@Test
	public void testDeplacerDe() {
		Coordonnees firstCoord = new Coordonnees(2.0, 1.5);
		defaultCoordonnees.deplacerDe(3.4, -0.3);
		assertEquals("deplacerDe", "(3,4 , -0,3)", defaultCoordonnees.toString());
		assertTrue("deplacerDe", firstCoord.equals(new Coordonnees(2.0, 1.5)));
		firstCoord.deplacerDe(3.4, -0.3);
		assertEquals("deplacerDe", "(5,4 , 1,2)", firstCoord.toString());
		assertTrue("deplacerDe", firstCoord.equals(new Coordonnees(5.4, 1.2)));
	}
	
	@Test
	public void testDeplacerVers() {
		Coordonnees firstCoord = new Coordonnees(34.5, -10.4);
		defaultCoordonnees.deplacerVers(2.43, -0.21);
		assertEquals("deplacerDe", "(2,43 , -0,21)", defaultCoordonnees.toString());
		assertTrue("deplacerDe", firstCoord.equals(new Coordonnees(34.5, -10.4)));
		firstCoord.deplacerVers(4.67, -3.21);
		assertEquals("deplacerDe", "(4,67 , -3,21)", firstCoord.toString());
		assertTrue("deplacerDe", firstCoord.equals(new Coordonnees(4.67, -3.21)));
	}
	
	@Test
	public void testDistanceVers() {
		Coordonnees firstCoord = new Coordonnees(2, 2);
		assertEquals("DistanceVers", 2.828427, defaultCoordonnees.distanceVers(firstCoord), EPSILON);
	}
	
	@Test
	public void testAngleVers() {
		Coordonnees firstCoord = new Coordonnees(2, 5);
		Coordonnees secondCoord = new Coordonnees(1, 9);
		assertEquals("AngleVers", 1.815774989, firstCoord.angleVers(secondCoord), EPSILON);
	}
	
	@Test
	public void testEqualsNull() {
		assertFalse("object null", defaultCoordonnees.equals(null));
	}
	@Test
	public void testEqualsObject() {
		assertTrue("object", defaultCoordonnees.equals(defaultCoordonnees));
	}
	@Test
	public void testEqualsClass() {
		assertFalse("object class", defaultCoordonnees.equals(Coordonnees.class));
	}
	@Test
	public void equalsReturnTrue() {
		Coordonnees coord = new Coordonnees(3.0, 2.0);
		Coordonnees coord2 = coord;
		assertTrue("equals return true", coord.equals(coord2));
	}
	@Test
	public void equalsReturnFalse() {
		assertFalse("equals return false", defaultCoordonnees.equals(new Coordonnees(3.0, 4.0)));
	}
	@Test
	public void equalsReturnFalse2() {
		assertFalse("equals return false", defaultCoordonnees.equals(new Coordonnees(0.0, 4.0)));
	}
	@Test
	public void equalsReturnFalse3() {
		assertFalse("equals return false", defaultCoordonnees.equals(new Coordonnees(2.0, 0.0)));
	}
	@Test
	public void testHashCode() {
		Coordonnees coord = new Coordonnees(1.0, 2.0);
		Coordonnees coord2 = new Coordonnees(1.0, 2.0);
		assertTrue("hashcode", coord.hashCode()==coord2.hashCode());
	}
}
