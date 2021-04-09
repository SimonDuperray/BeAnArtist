package fr.eseo.poo.projet.artiste.vue.formes;

// internal imports
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCarreTest {

	public VueCarreTest() {
		testConstructeurCarre();
	}

	private void testConstructeurCarre(){
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setTitle("Etre un artiste - carre");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		PanneauDessin panneau = new PanneauDessin(900, 400);
		frame.setContentPane(panneau);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new VueCarreTest();
			}
		});
	}
}