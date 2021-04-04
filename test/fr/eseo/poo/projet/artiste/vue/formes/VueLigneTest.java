package fr.eseo.poo.projet.artiste.vue.formes;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueLigneTest {

	VueLigne vueLigne = new VueLigne(
		new Ligne(
			new Coordonnees(5, 5),
			100,
			100
		)
	);

	public VueLigneTest(){
		testConstructeurLigne();
	}

	private void testConstructeurLigne(){
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setTitle("Etre un Artiste - ligne");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		PanneauDessin panneau = new PanneauDessin(900, 400);
		frame.setContentPane(panneau);
		frame.setLocationRelativeTo(null);
		vueLigne.getForme().setCouleur(java.awt.Color.RED);
		panneau.ajouterVueForme(vueLigne);
		frame.setVisible(true);
		frame.pack();
		frame.repaint();
	}

	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new VueLigneTest();
			}
		});
	}

}
