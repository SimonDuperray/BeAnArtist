package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEtoileTest {

	VueEtoile vueEtoile1 = new VueEtoile(
		new Etoile(
			new Coordonnees(20, 20), 
			75, 
			4, 
			0.3, 
			0.7
		)
	);
	
	VueEtoile vueEtoile2 = new VueEtoile(
		new Etoile(
			new Coordonnees(500, 200), 
			100, 
			11,
			0.78,
			0.9
		)
	);

	public VueEtoileTest(){
		testConstructeurEtoile();
	}

	private void testConstructeurEtoile(){
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setTitle("Etre un Artiste - Etoile");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		Etoile e = new Etoile(new Coordonnees(10,10),200,5,0,0.75);
		System.out.println("size: "+e.getCoordonnees().size());
		PanneauDessin panneau = new PanneauDessin(900, 400);
		frame.setContentPane(panneau);
		frame.setLocationRelativeTo(null);
		vueEtoile1.getForme().setCouleur(java.awt.Color.RED);
		vueEtoile2.getForme().setCouleur(java.awt.Color.BLUE);
		((Etoile) vueEtoile1.getForme()).setRempli(true);
		panneau.ajouterVueForme(vueEtoile1);
		panneau.ajouterVueForme(vueEtoile2);
		frame.setVisible(true);
		frame.repaint();
	}
	
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new VueEtoileTest();
			}
		});
	}
}
