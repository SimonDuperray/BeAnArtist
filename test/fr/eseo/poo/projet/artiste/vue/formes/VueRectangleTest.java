package fr.eseo.poo.projet.artiste.vue.formes;

// internal imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueRectangleTest {

	VueRectangle vueRectangle = new VueRectangle
	(
		new Rectangle(
			new Coordonnees(5, 5), 
			100,
			100
		)
	);

	public VueRectangleTest() {
		testConstructeurRectangle();
	}

	private void testConstructeurRectangle(){
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setTitle("Etre un artiste - rectangle");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		PanneauDessin panneau = new PanneauDessin(900, 400);
		frame.setContentPane(panneau);
		frame.setLocationRelativeTo(null);
		vueRectangle.getForme().setCouleur(java.awt.Color.BLUE);
		panneau.ajouterVueForme(vueRectangle);
		frame.setVisible(true);
		frame.pack();
		frame.repaint();
	}

	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new VueRectangleTest();
			}
		});
	}

}
