package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilEllipseTest {

	public OutilEllipseTest() {
		testConstructeurOutil();
	}

	public void testConstructeurOutil(){
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setTitle("Construction Ellipse");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		PanneauDessin panneau = new PanneauDessin(900, 400);
		PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils(panneau);
		OutilEllipse outilEllipse = new OutilEllipse();
		panneau.associerOutil(outilEllipse);
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
				new OutilEllipseTest();
			}
		});
	}

}
