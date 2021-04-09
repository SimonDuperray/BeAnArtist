package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilEtoileTest {

	public OutilEtoileTest(){
		testConstructeurEtoile();
	}

	public void testConstructeurEtoile(){
		javax.swing.JFrame frame = new javax.swing.JFrame();
		PanneauDessin panneau = new PanneauDessin(900, 400);
		PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils(panneau);
		OutilEtoile outilEtoile = new OutilEtoile(panneauBarreOutils);
		frame.setTitle("Etre un Artiste - test dessiner etoile");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		panneau.associerOutil(outilEtoile);
		frame.add(panneau, java.awt.BorderLayout.CENTER);
		frame.add(panneauBarreOutils, java.awt.BorderLayout.EAST);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new OutilEtoileTest();
			}
		});
	}
}