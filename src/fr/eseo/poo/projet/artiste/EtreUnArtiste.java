package fr.eseo.poo.projet.artiste;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class EtreUnArtiste {

   public EtreUnArtiste(){
      testEtreUnArtiste();
   }

   public void testEtreUnArtiste(){
      javax.swing.JFrame frame = new javax.swing.JFrame();
      frame.setTitle("Etre un Artiste");
      frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
      PanneauDessin panneau = new PanneauDessin(900, 400);
      PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils(panneau);
      frame.add(panneau, java.awt.BorderLayout.CENTER);
      frame.add(panneauBarreOutils, java.awt.BorderLayout.EAST);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      frame.pack();
   }

   public static void main(String[] args){
      javax.swing.SwingUtilities.invokeLater(new Runnable(){
         @Override
         public void run(){
            new EtreUnArtiste();
         }
      });
   }
}
