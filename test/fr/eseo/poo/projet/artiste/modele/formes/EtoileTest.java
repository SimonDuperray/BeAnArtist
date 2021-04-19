package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class EtoileTest {

	// constantes
	public static final double EPSILON = 0.2;

	// instances
	Coordonnees defaultCoord = new Coordonnees();
	Etoile defaultEtoile = new Etoile();
	Coordonnees coord = new Coordonnees(30, 30);
	Etoile posEtoile = new Etoile(coord);
	Etoile tailleEtoile = new Etoile(75);
	Etoile posTailleEtoile = new Etoile(coord, 75);
	Etoile fullEtoile = new Etoile(coord, 75, 10, 0.4, 0.8);
	List<Coordonnees> coordonnees = new ArrayList<Coordonnees>();

	/*
	*  CONSTRUCTEURS
	*/

	// constructeur vide
	@Test
	public void emptyConstructor(){
		assertEquals("AbsEtoile", defaultCoord.getAbscisse(), defaultEtoile.getPosition().getAbscisse(), EPSILON);
		assertEquals("OrdEtoile", defaultCoord.getOrdonnee(), defaultEtoile.getPosition().getOrdonnee(), EPSILON);
		assertEquals("LargEtoile", 100.0, defaultEtoile.getLargeur(), EPSILON);
		assertEquals("NbBranchesEtoile", 5, defaultEtoile.getNombreBranches());
		assertEquals("AngleEtoile", 0.9, defaultEtoile.getAnglePremiereBranche(), EPSILON);
		assertEquals("LongBranchesEtoile", 0.5, defaultEtoile.getLongueurBranche(), EPSILON);
	}
	// constructeur position
	@Test
	public void posConstructor(){
		assertEquals("AbsEtoile", coord.getAbscisse(), posEtoile.getPosition().getAbscisse(), EPSILON);
		assertEquals("OrdEtoile", coord.getOrdonnee(), posEtoile.getPosition().getOrdonnee(), EPSILON);
		assertEquals("LargEtoile", 100.0, posEtoile.getLargeur(), EPSILON);
		assertEquals("NbBranchesEtoile", 5, posEtoile.getNombreBranches());
		assertEquals("AngleEtoile", 0.9, posEtoile.getAnglePremiereBranche(), EPSILON);
		assertEquals("LongBranchesEtoile", 0.5, posEtoile.getLongueurBranche(), EPSILON);
	}
	// constructeur taille
	@Test
	public void tailleConstructor(){
		assertEquals("AbsEtoile", defaultCoord.getAbscisse(), tailleEtoile.getPosition().getAbscisse(), EPSILON);
		assertEquals("OrdEtoile", defaultCoord.getOrdonnee(), tailleEtoile.getPosition().getOrdonnee(), EPSILON);
		assertEquals("LargEtoile", 75.0, tailleEtoile.getLargeur(), EPSILON);
		assertEquals("NbBranchesEtoile", 5, tailleEtoile.getNombreBranches());
		assertEquals("AngleEtoile", 0.9, tailleEtoile.getAnglePremiereBranche(), EPSILON);
		assertEquals("LongBranchesEtoile", 0.5, tailleEtoile.getLongueurBranche(), EPSILON);
	}
	// constructeur position et taille
	@Test
	public void taillePosConstructor(){
		assertEquals("AbsEtoile", coord.getAbscisse(), posTailleEtoile.getPosition().getAbscisse(), EPSILON);
		assertEquals("OrdEtoile", coord.getOrdonnee(), posTailleEtoile.getPosition().getOrdonnee(), EPSILON);
		assertEquals("LargEtoile", 75.0, posTailleEtoile.getLargeur(), EPSILON);
		assertEquals("NbBranchesEtoile", 5, posTailleEtoile.getNombreBranches());
		assertEquals("AngleEtoile", 0.9, posTailleEtoile.getAnglePremiereBranche(), EPSILON);
		assertEquals("LongBranchesEtoile", 0.5, posTailleEtoile.getLongueurBranche(), EPSILON);
	}
	// constructeur full
	@Test
	public void fullConstructor(){
		assertEquals("AbsEtoile", coord.getAbscisse(), fullEtoile.getPosition().getAbscisse(), EPSILON);
		assertEquals("OrdEtoile", coord.getOrdonnee(), fullEtoile.getPosition().getOrdonnee(), EPSILON);
		assertEquals("LargEtoile", 75.0, fullEtoile.getLargeur(), EPSILON);
		assertEquals("NbBranchesEtoile", 10, fullEtoile.getNombreBranches());
		assertEquals("AngleEtoile", 0.4, fullEtoile.getAnglePremiereBranche(), EPSILON);
		assertEquals("LongBranchesEtoile", 0.8, fullEtoile.getLongueurBranche(), EPSILON);
	}
	
	/*
	*  EXCEPTIONS
	*/

	// taille incorrecte
	@Test(expected = IllegalArgumentException.class)
	public void setBadTaille() {
		defaultEtoile.setLargeur(-10);
	}
	// angle incorrect inf
	@Test(expected = IllegalArgumentException.class)
	public void setBadAngleInf() {
		defaultEtoile.setAnglePremiereBranche(-10);
	}
	// angle incorrect sup
	@Test(expected = IllegalArgumentException.class)
	public void setBadAngleSup() {
		defaultEtoile.setAnglePremiereBranche(10);
	}
	// longueur incorrecte inf
	@Test(expected = IllegalArgumentException.class)
	public void setBadLongueurInf() {
		defaultEtoile.setLongueurBranche(-10);
	}
	// longueur incorrecte max
	@Test(expected = IllegalArgumentException.class)
	public void setBadLongueurSup() {
		defaultEtoile.setLongueurBranche(10);
	}
	// nb branches incorrect inf
	@Test(expected = IllegalArgumentException.class)
	public void setBadNbInf() {
		defaultEtoile.setNombreBranches(-10);
	}
	// nb branches incorrect sup
	@Test(expected = IllegalArgumentException.class)
	public void setBadNbSup() {
		defaultEtoile.setNombreBranches(20);
	}

	/*
	*  SETTERS
	*/

	// largeur
	@Test
	public void setterLargeur(){
		defaultEtoile.setLargeur(99);
		assertEquals("setLargeur", 99.0, defaultEtoile.getLargeur(), EPSILON);
	}
	// hauteur
	@Test
	public void setterHauteur(){
		defaultEtoile.setHauteur(123);
		assertEquals("setHauteur", 123.0, defaultEtoile.getHauteur(), EPSILON);
	}
	// position
	@Test
	public void setterPosition(){
		defaultEtoile.setPosition(coord);
		assertEquals("setPositionAbs", 30, defaultEtoile.getPosition().getAbscisse(), EPSILON);
		assertEquals("setPositionOrd", 30, defaultEtoile.getPosition().getAbscisse(), EPSILON);
	}
	// nb branches
	@Test
	public void setterNbBranches(){
		defaultEtoile.setNombreBranches(12);
		assertEquals("setNbBranches", 12, defaultEtoile.getNombreBranches());
	}
	// longueur branches
	@Test
	public void setterLongBranches(){
		defaultEtoile.setLongueurBranche(0.76);
		assertEquals("setLongBranches", 0.76, defaultEtoile.getLongueurBranche(), EPSILON);
	}
	// angle premiere branche
	@Test
	public void setterAnglePremiBranche(){
		defaultEtoile.setAnglePremiereBranche(0);
		assertEquals("setAnglePremiereBranche", 0, defaultEtoile.getAnglePremiereBranche(), EPSILON);
	}
	// couleur
	@Test
	public void setterCouleur(){
		defaultEtoile.setCouleur(java.awt.Color.BLUE);
		assertEquals("setCouleur", java.awt.Color.BLUE, defaultEtoile.getCouleur());
	}
	// rempli
	@Test
	public void setterEstRempli(){
		defaultEtoile.setRempli(true);
		assertEquals("estRempli", true, defaultEtoile.estRempli());
	}
	// position
	@Test
	public void setterCoordonnees(){
		coordonnees.add(coord);
		defaultEtoile.setCoordonnees(coordonnees);
		assertEquals("listeCoordonnees", coordonnees, defaultEtoile.getCoordonnees());
	}
	
	/*
	*  METHODES
	*/

	// aire
	@Test
	public void testAire(){
		coordonnees.add(coord);
		Coordonnees coord1 = new Coordonnees(35, 45);
		Coordonnees coord2 = new Coordonnees(23, 90);
		coordonnees.add(coord1);
		coordonnees.add(coord2);
		posEtoile.setCoordonnees(coordonnees);
		assertEquals("aire", 3673.657, posEtoile.aire(), EPSILON);
	}
	// perimetre
	@Test
	public void testPerimetre(){
		coordonnees.add(coord);
		Coordonnees coord1 = new Coordonnees(35, 45);
		Coordonnees coord2 = new Coordonnees(23, 90);
		coordonnees.add(coord1);
		coordonnees.add(coord2);
		posEtoile.setCoordonnees(coordonnees);
		assertEquals("perimetre", 332.0327, posEtoile.perimetre(), EPSILON);
	}
	// toString fr
	@Test
	public void testToString(){
		List<Coordonnees> coords = new ArrayList<Coordonnees>();
		coords.add(new Coordonnees(30, 30));
		Coordonnees c1 = new Coordonnees(35, 45);
		Coordonnees c2 = new Coordonnees(23, 90);
		coords.add(c1);
		coords.add(c2);
		posEtoile.setCoordonnees(coords);
		String result = "[Etoile] : pos (30,0 , 30,0) dim 100,0 x 100,0 périmètre : "
			+ "332,03 aire : 3673,66 couleur = R51,V51,B51";
		Locale.setDefault(Locale.FRANCE);
		assertEquals("toString", result, posEtoile.toString());
	}
	// toString en - rempli
	@Test
	public void testToStringEn(){
		List<Coordonnees> coords = new ArrayList<Coordonnees>();
		coords.add(new Coordonnees(30, 30));
		Coordonnees c1 = new Coordonnees(35, 45);
		Coordonnees c2 = new Coordonnees(23, 90);
		coords.add(c1);
		coords.add(c2);
		posEtoile.setCoordonnees(coords);
		posEtoile.setRempli(true);
		String result = "[Etoile-Rempli] : pos (30.0 , 30.0) dim 100.0 x 100.0 périmètre : "
			+ "332.03 aire : 3673.66 couleur = R51,G51,B51";
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("toString", result, posEtoile.toString());
	}
	// toString other
	@Test
	public void testToStringOther(){
		List<Coordonnees> coords = new ArrayList<Coordonnees>();
		coords.add(new Coordonnees(30, 30));
		Coordonnees c1 = new Coordonnees(35, 45);
		Coordonnees c2 = new Coordonnees(23, 90);
		coords.add(c1);
		coords.add(c2);
		posEtoile.setCoordonnees(coords);
		posEtoile.setRempli(true);
		String result = "[Etoile-Rempli] : pos (30.0 , 30.0) dim 100.0 x 100.0 périmètre : "
			+ "332.03 aire : 3673.66 couleur = Bad Language";
		Locale.setDefault(Locale.CHINA);
		assertEquals("toString", result, posEtoile.toString());
	}
	// contient false
	@Test
	public void contientFalse() {
		List<Coordonnees> coords = new ArrayList<Coordonnees>();
		coords.add(new Coordonnees(30, 30));
		Coordonnees c1 = new Coordonnees(35, 45);
		Coordonnees c2 = new Coordonnees(23, 90);
		coords.add(c1);
		coords.add(c2);
		posEtoile.setCoordonnees(coords);
		assertFalse("contient false: ", posEtoile.contient(new Coordonnees(35, 45)));
	}
	// contient true
	@Test
	public void contientTrue() {
		List<Coordonnees> coords = new ArrayList<Coordonnees>();
		coords.add(new Coordonnees(30, 30));
		Coordonnees c1 = new Coordonnees(35, 45);
		Coordonnees c2 = new Coordonnees(23, 90);
		coords.add(c1);
		coords.add(c2);
		posEtoile.setCoordonnees(coords);
		assertTrue("contient true: ", defaultEtoile.contient(new Coordonnees(50, 50)));
	}
}