package fr.eseo.poo.projet.artiste.vues.formes;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueLigneTest {

	public VueLigneTest(){
		testConstructeurLigne();
	}

	private void testConstructeurLigne(){
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setTitle("Etre un Artiste");
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
				new VueLigneTest();
			}
		});
	}

}
