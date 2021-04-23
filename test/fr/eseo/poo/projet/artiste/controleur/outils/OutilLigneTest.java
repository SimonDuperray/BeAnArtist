package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilLigneTest {

	public OutilLigneTest(){
		testConstucteurOutil();
	}

	public void testConstucteurOutil(){
		PanneauDessin panneau = new PanneauDessin(900, 400);
		OutilLigne outilLigne = new OutilLigne();
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setTitle("Etre un Artiste - OutilLigne");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panneau);
		panneau.associerOutil(outilLigne);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
		frame.repaint();
	}

	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new OutilLigneTest();
			}
		});
	}

}