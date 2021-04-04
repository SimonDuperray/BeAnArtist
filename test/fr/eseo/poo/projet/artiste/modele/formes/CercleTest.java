package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.*;

import org.junit.Test;

import java.awt.Color;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class CercleTest {

	public static final double EPSILON = 0.2;

	Cercle defaultCercle = new Cercle();
	Coordonnees defaultCoord = new Coordonnees();

	// constructeurs
	@Test
	public void emptyConstructor(){
		assertEquals("emptyConstructorAbs", defaultCoord.getAbscisse(), defaultCercle.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", defaultCoord.getOrdonnee(), defaultCercle.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 100, defaultCercle.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 100.0, defaultCercle.getHauteur(), EPSILON);
	}
	@Test
	public void dimConstructor(){
		Cercle testCercle = new Cercle(30.0);
		assertEquals("emptyConstructorAbs", defaultCoord.getAbscisse(), testCercle.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", defaultCoord.getOrdonnee(), testCercle.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 30.0, testCercle.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 30.0, testCercle.getHauteur(), EPSILON);
	}
	@Test
	public void coordConstructor(){
		Coordonnees position = new Coordonnees(2.0, 5.0);
		Cercle testCercle = new Cercle(position);
		assertEquals("emptyConstructorAbs", position.getAbscisse(), testCercle.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", position.getOrdonnee(), testCercle.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 100.0, testCercle.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 100.0, testCercle.getLargeur(), EPSILON);
	}
	@Test
	public void fullConstructor(){
		Coordonnees position = new Coordonnees(2.0, 5.0);
		Cercle testCercle = new Cercle(position, 20.0);
		assertEquals("emptyConstructorAbs", position.getAbscisse(), testCercle.getPosition().getAbscisse(), EPSILON);
		assertEquals("emptyConstructorOrd", position.getOrdonnee(), testCercle.getPosition().getOrdonnee(), EPSILON);
		assertEquals("emptyConstructorLarg", 20.0, testCercle.getLargeur(), EPSILON);
		assertEquals("emptyConstructorHaut", 20.0, testCercle.getHauteur(), EPSILON);
	}

	// setters
	@Test
	public void setHauteur(){
		defaultCercle.setHauteur(100);
		assertEquals("setHauteur", 100, defaultCercle.getHauteur(), EPSILON);
	}
	@Test
	public void setLargeur(){
		defaultCercle.setLargeur(200);
		assertEquals("setHauteur", 200, defaultCercle.getLargeur(), EPSILON);
	}
	@Test
	public void setCouleurT(){
		Cercle cercle = new Cercle();
		cercle.setCouleur(Color.RED);
		assertEquals("getCouleur", Color.RED, cercle.getCouleur());
	}

	// methodes
	@Test
	public void perimetret(){
		Cercle testCercle = new Cercle(1.0);
		assertEquals(
			"perimetre",
			2*Math.PI*(testCercle.getLargeur()/2),
			testCercle.perimetre(), 
			EPSILON
		);
	}
	@Test
	public void airet(){
		Cercle testCercle = new Cercle(1.0);
		assertEquals(
			"aire",
			Math.PI*(testCercle.getLargeur()/2)*(testCercle.getHauteur()/2),
			testCercle.aire(),
			EPSILON
		);
	}
	@Test
	public void toStringt(){
		String result = "[Cercle] : pos (0,0 , 0,0) dim 100,0 x 100,0 "+ "périmètre : 314,16 aire : 7853,98 couleur = R51,V51,B51";
		assertEquals("toString", result, defaultCercle.toString());
	}

}
