package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.*;

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

	constructeurs
	@Test
	public void emptyConstructor(){
		assertEquals("AbsEtoile", defaultCoord.getAbscisse(), defaultEtoile.getPosition().getAbscisse(), EPSILON);
		assertEquals("OrdEtoile", defaultCoord.getOrdonnee(), defaultEtoile.getPosition().getOrdonnee(), EPSILON);
		assertEquals("LargEtoile", 100.0, defaultEtoile.getLargeur(), EPSILON);
		assertEquals("NbBranchesEtoile", 5, defaultEtoile.getNombreBranches());
		assertEquals("AngleEtoile", 0.0, defaultEtoile.getAnglePremiereBranche(), EPSILON);
		assertEquals("LongBranchesEtoile", 0.5, defaultEtoile.getLongueurBranche(), EPSILON);
	}
	@Test
	public void posConstructor(){
		assertEquals("AbsEtoile", coord.getAbscisse(), posEtoile.getPosition().getAbscisse(), EPSILON);
		assertEquals("OrdEtoile", coord.getOrdonnee(), posEtoile.getPosition().getOrdonnee(), EPSILON);
		assertEquals("LargEtoile", 100.0, posEtoile.getLargeur(), EPSILON);
		assertEquals("NbBranchesEtoile", 5, posEtoile.getNombreBranches());
		assertEquals("AngleEtoile", 0.0, posEtoile.getAnglePremiereBranche(), EPSILON);
		assertEquals("LongBranchesEtoile", 0.5, posEtoile.getLongueurBranche(), EPSILON);
	}
	@Test
	public void tailleConstructor(){
		assertEquals("AbsEtoile", defaultCoord.getAbscisse(), tailleEtoile.getPosition().getAbscisse(), EPSILON);
		assertEquals("OrdEtoile", defaultCoord.getOrdonnee(), tailleEtoile.getPosition().getOrdonnee(), EPSILON);
		assertEquals("LargEtoile", 75.0, tailleEtoile.getLargeur(), EPSILON);
		assertEquals("NbBranchesEtoile", 5, tailleEtoile.getNombreBranches());
		assertEquals("AngleEtoile", 0.0, tailleEtoile.getAnglePremiereBranche(), EPSILON);
		assertEquals("LongBranchesEtoile", 0.5, tailleEtoile.getLongueurBranche(), EPSILON);
	}
	@Test
	public void taillePosConstructor(){
		assertEquals("AbsEtoile", coord.getAbscisse(), posTailleEtoile.getPosition().getAbscisse(), EPSILON);
		assertEquals("OrdEtoile", coord.getOrdonnee(), posTailleEtoile.getPosition().getOrdonnee(), EPSILON);
		assertEquals("LargEtoile", 75.0, posTailleEtoile.getLargeur(), EPSILON);
		assertEquals("NbBranchesEtoile", 5, posTailleEtoile.getNombreBranches());
		assertEquals("AngleEtoile", 0.0, posTailleEtoile.getAnglePremiereBranche(), EPSILON);
		assertEquals("LongBranchesEtoile", 0.5, posTailleEtoile.getLongueurBranche(), EPSILON);
	}
	@Test
	public void fullConstructor(){
		assertEquals("AbsEtoile", coord.getAbscisse(), fullEtoile.getPosition().getAbscisse(), EPSILON);
		assertEquals("OrdEtoile", coord.getOrdonnee(), fullEtoile.getPosition().getOrdonnee(), EPSILON);
		assertEquals("LargEtoile", 75.0, fullEtoile.getLargeur(), EPSILON);
		assertEquals("NbBranchesEtoile", 10, fullEtoile.getNombreBranches());
		assertEquals("AngleEtoile", 0.4, fullEtoile.getAnglePremiereBranche(), EPSILON);
		assertEquals("LongBranchesEtoile", 0.8, fullEtoile.getLongueurBranche(), EPSILON);
	}

	// SETTERS
	@Test
	public void setterLargeur(){
		defaultEtoile.setLargeur(123);
		assertEquals("setLargeur", 123.0, defaultEtoile.getLargeur(), EPSILON);
	}
	@Test
	public void setterHauteur(){
		defaultEtoile.setHauteur(123);
		assertEquals("setHauteur", 123.0, defaultEtoile.getHauteur(), EPSILON);
	}
	@Test
	public void setterPosition(){
		defaultEtoile.setPosition(coord);
		assertEquals("setPositionAbs", 30, defaultEtoile.getPosition().getAbscisse(), EPSILON);
		assertEquals("setPositionOrd", 30, defaultEtoile.getPosition().getAbscisse(), EPSILON);
	}
	@Test
	public void setterNbBranches(){
		defaultEtoile.setNombreBranches(12);
		assertEquals("setNbBranches", 12, defaultEtoile.getNombreBranches());
	}
	@Test
	public void setterLongBranches(){
		defaultEtoile.setLongueurBranche(0.76);
		assertEquals("setLongBranches", 0.76, defaultEtoile.getLongueurBranche(), EPSILON);
	}
	@Test
	public void setterAnglePremiBranche(){
		defaultEtoile.setAnglePremiereBranche(0);
		assertEquals("setAnglePremiereBranche", 0, defaultEtoile.getAnglePremiereBranche(), EPSILON);
	}
	@Test
	public void setterCouleur(){
		defaultEtoile.setCouleur(java.awt.Color.BLUE);
		assertEquals("setCouleur", java.awt.Color.BLUE, defaultEtoile.getCouleur());
	}
	@Test
	public void setterEstRempli(){
		defaultEtoile.setRempli(true);
		assertEquals("estRempli", true, defaultEtoile.estRempli());
	}
	@Test
	public void setterCoordonnees(){
		coordonnees.add(coord);
		defaultEtoile.setCoordonnees(coordonnees);
		assertEquals("listeCoordonnees", coordonnees, defaultEtoile.getCoordonnees());
	}
	
	// methodes
	@Test
	public void testAire(){
		coordonnees.add(coord);
		Coordonnees coord1 = new Coordonnees(35, 45);
		Coordonnees coord2 = new Coordonnees(23, 90);
		coordonnees.add(coord1);
		coordonnees.add(coord2);
		posEtoile.setCoordonnees(coordonnees);
		assertEquals("aire", 202.5, posEtoile.aire(), EPSILON);
	}
	@Test
	public void testPerimetre(){
		coordonnees.add(coord);
		Coordonnees coord1 = new Coordonnees(35, 45);
		Coordonnees coord2 = new Coordonnees(23, 90);
		coordonnees.add(coord1);
		coordonnees.add(coord2);
		posEtoile.setCoordonnees(coordonnees);
		assertEquals("perimetre", 122.79, posEtoile.perimetre(), EPSILON);
	}
	@Test
	public void testToString(){
		List<Coordonnees> coords = new ArrayList<Coordonnees>();
		coords.add(new Coordonnees(30, 30));
		Coordonnees c1 = new Coordonnees(35, 45);
		Coordonnees c2 = new Coordonnees(23, 90);
		coords.add(c1);
		coords.add(c2);
		posEtoile.setCoordonnees(coords);
		posEtoile.setRempli(true);
		// Etoile testEtoile = new Etoile();
		String result = "[Etoile-Rempli] : pos (30,0 , 30,0) dim 100,0 x 100,0 périmètre : "
			+ "122,79 aire : 202,5 couleur = R51,V51,B51";
		assertEquals("toString", result, posEtoile.toString());
	}
}