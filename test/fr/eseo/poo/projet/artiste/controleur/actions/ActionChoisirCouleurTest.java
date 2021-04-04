package fr.eseo.poo.projet.artiste.controleur.actions;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirCouleurTest {

	public ActionChoisirCouleurTest(){
		testChoisirCouleur();
	}

	public void testChoisirCouleur(){
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setTitle("Etre un Artiste - choix couleur");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		PanneauDessin panneau = new PanneauDessin(900, 400);
		OutilLigne outilLigne = new OutilLigne();
		panneau.associerOutil(outilLigne);
		PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils(panneau);
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
				new ActionChoisirCouleurTest();
			}
		});
	}

}
