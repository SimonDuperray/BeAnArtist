package fr.eseo.poo.projet.artiste.vue.ihm;

import static org.junit.Assert.*;

import org.junit.Test;

import java.awt.Color;

public class PanneauDessinTest {

	public PanneauDessinTest(){
		testConstructeurParDefaut();
		testConstructeur();
	}

	private void testConstructeurParDefaut(){
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setTitle("Etre un Artiste");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		java.awt.Color color = new Color(100, 150, 45);
		PanneauDessin panneau = new PanneauDessin(900, 400, color);
		frame.setContentPane(panneau);
		frame.pack();
		frame.setLocationRelativeTo(null);frame.setVisible(true);
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
