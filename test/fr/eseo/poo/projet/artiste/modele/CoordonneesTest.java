package fr.eseo.poo.projet.artiste.modele;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CoordonneesTest {
	final double EPSILON = 0.2;
	@Test
	public void ConstructeurVide() {
		Coordonnees coord = new Coordonnees();
		assertEquals("EmptyConstructor", "(0,0 , 0,0)", coord.toString());
	}
	@Test
	public void Constructeur() {
		Coordonnees coord = new Coordonnees(4.5, 7.2);
		assertEquals("Constructor", "(4,5 , 7,2)", coord.toString());
		Coordonnees coord2 = new Coordonnees(4.54, 7.42);
		assertEquals("Constructor", "(4,54 , 7,42)", coord2.toString());
	}
	
	@Test
	public void GetDefaultCoord() {
		Coordonnees coord = new Coordonnees();
		assertEquals("getDefaultAbs", 0, coord.getAbscisse(), EPSILON);
		assertEquals("getDefaultCoo", 0, coord.getOrdonnee(), EPSILON);
	}
	@Test
	public void GetCoord() {
		Coordonnees coord = new Coordonnees(3.43, 7.8);
		assertEquals("getAbs", 3.43, coord.getAbscisse(), EPSILON);
		assertEquals("getOrd", 7.8, coord.getOrdonnee(), EPSILON);
	}
	
	@Test
	public void SetCoord() {
		Coordonnees coord = new Coordonnees();
		coord.setAbscisse(2.34);
		coord.setOrdonnee(-1.23);
		assertEquals("setAbs", 2.34, coord.getAbscisse(), EPSILON);
		assertEquals("setOrd", -1.23, coord.getOrdonnee(), EPSILON);
	}
	
	@Test
	public void DeplacerDe() {
		Coordonnees coord = new Coordonnees();
		coord.deplacerDe(3.4, -0.3);
		assertEquals("deplacerDe", "(3,4 , -0,3)", coord.toString());
		Coordonnees coord1 = new Coordonnees(2.0, 1.5);
		coord1.deplacerDe(3.4, -0.3);
		assertEquals("deplacerDe", "(5,4 , 1,2)", coord1.toString());
	}
	
	@Test
	public void DeplacerVers() {
		Coordonnees coord = new Coordonnees();
		coord.deplacerVers(2.43, -0.21);
		assertEquals("deplacerDe", "(2,43 , -0,21)", coord.toString());
		Coordonnees coord1 = new Coordonnees(34.5, -10.4);
		coord1.deplacerVers(4.67, -3.21);
		assertEquals("deplacerDe", "(4,67 , -3,21)", coord1.toString());
	}
	
	@Test
	public void DistanceVers() {
		Coordonnees coord1 = new Coordonnees();
		Coordonnees coord2 = new Coordonnees(2, 2);
		assertEquals("DistanceVers", 2.828427, coord1.distanceVers(coord2), EPSILON);
	}
	
	@Test
	public void AngleVers() {
		Coordonnees coord1 = new Coordonnees(2, 5);
		Coordonnees coord2 = new Coordonnees(1, 9);
		assertEquals("AngleVers", 1.815774989, coord1.angleVers(coord2), EPSILON);
	}

}
