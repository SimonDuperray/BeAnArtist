package fr.eseo.poo.projet.artiste.controleur.actions;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionEffacerTest {

	public ActionEffacerTest(){
		testActionEffacer();
	}

	private void testActionEffacer(){
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setTitle("Test Tout Effacer");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		OutilLigne outilLigne = new OutilLigne();
		PanneauDessin panneau = new PanneauDessin(900, 400);
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
				new ActionEffacerTest();
			}
		});
	}

}
