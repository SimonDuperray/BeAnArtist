package fr.eseo.poo.projet.artiste.controleur.outils;

// internal imports
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilCarreTest {

	public OutilCarreTest() {
		testConstructeurOutil();
	}

	public void testConstructeurOutil(){
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setTitle("Construction Carré");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		PanneauDessin panneau = new PanneauDessin(900, 400);
		PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils(panneau);
		OutilCarre outilCarre = new OutilCarre();
		panneau.associerOutil(outilCarre);
		frame.add(panneau, java.awt.BorderLayout.CENTER);
		// frame.add(panneauBarreOutils, java.awt.BorderLayout.EAST);
		frame.add(panneauBarreOutils);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new OutilCarreTest();
			}
		});
	}
}