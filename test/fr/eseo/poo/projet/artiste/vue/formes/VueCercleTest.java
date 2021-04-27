package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCercleTest {

	public VueCercleTest() {
		testConstructeurCercle();
	}

	private void testConstructeurCercle(){
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setTitle("Etre un artiste - cercle");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		PanneauDessin panneau = new PanneauDessin(900, 400);
		frame.setContentPane(panneau);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.repaint();
	}

	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new VueCercleTest();
			}
		});
	}
}
