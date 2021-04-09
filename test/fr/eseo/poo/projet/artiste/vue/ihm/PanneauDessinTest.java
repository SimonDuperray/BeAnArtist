package fr.eseo.poo.projet.artiste.vue.ihm;

public class PanneauDessinTest {

	public PanneauDessinTest(){
		testConstructeurParDefaut();
		testConstructeur();
	}

	private void testConstructeurParDefaut(){
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setTitle("Etre un Artiste");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		PanneauDessin panneau = new PanneauDessin(900, 400);
		frame.setContentPane(panneau);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
	}

	private void testConstructeur(){
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setTitle("Blues du Businessman");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		PanneauDessin panneau = new PanneauDessin(900, 400);
		frame.setContentPane(panneau);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new PanneauDessinTest();
			}
		});
	}
}