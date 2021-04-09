package fr.eseo.poo.projet.artiste.vue.ihm;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilSelectionner;

public class PanneauBarreOutilsTest {

	public PanneauBarreOutilsTest() {
		testConstructeurSelection();
	}

	public void testConstructeurSelection(){
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setTitle("Etre un Artiste - Selection");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		OutilSelectionner outilSelectionner = new OutilSelectionner();
		PanneauDessin panneau = new PanneauDessin(900, 400);
		panneau.associerOutil(outilSelectionner);
		frame.add(panneau, java.awt.BorderLayout.CENTER);
		PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils(panneau);
		frame.add(panneauBarreOutils, java.awt.BorderLayout.EAST);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
		frame.repaint();
	}

	public static void main(String [] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new PanneauBarreOutilsTest();
			}
		});
	}

}
