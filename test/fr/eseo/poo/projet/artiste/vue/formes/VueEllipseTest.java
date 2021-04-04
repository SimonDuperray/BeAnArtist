package fr.eseo.poo.projet.artiste.vue.formes;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;


public class VueEllipseTest {

	VueEllipse vueEllipse = new VueEllipse(
		new Ellipse(
			new Coordonnees(5, 5), 
			100,
			100
		)
	);

	public VueEllipseTest() {
		testConstructeurEllipse();
	}

	private void testConstructeurEllipse(){
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setTitle("Etre un artiste - ellipse");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		PanneauDessin panneau = new PanneauDessin(900, 400);
		frame.setContentPane(panneau);
		frame.setLocationRelativeTo(null);
		vueEllipse.getForme().setCouleur(java.awt.Color.BLUE);
		panneau.ajouterVueForme(vueEllipse);
		frame.setVisible(true);
		frame.pack();
		frame.repaint();
	}

	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new VueEllipseTest();
			}
		});
	}
}
