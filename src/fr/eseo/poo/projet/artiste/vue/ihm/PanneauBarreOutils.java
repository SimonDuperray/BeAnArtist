package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.JButton;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;

public class PanneauBarreOutils extends javax.swing.JPanel {

   private static final long serialVersionUID = 1L;
   private PanneauDessin panneauDessin;

   // constructeur
   public PanneauBarreOutils(PanneauDessin panneauDessin){
      this.panneauDessin = panneauDessin;
      initComponents();
   }

   // methodes
   public void initComponents(){
      JButton effacerBtn = new JButton(new ActionEffacer(this.panneauDessin));
      effacerBtn.setName(ActionEffacer.NOM_ACTION);
      this.add(effacerBtn);
   }
}
