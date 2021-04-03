package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
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
      ButtonGroup groupBtn = new ButtonGroup();
      JButton effacerBtn = new JButton(new ActionEffacer(this.panneauDessin));
      effacerBtn.setName(ActionEffacer.NOM_ACTION);
      this.add(effacerBtn);

      // toggles buttons
      // ligne
      JToggleButton ligneBtn = new JToggleButton(
         new ActionChoisirForme(
            this.panneauDessin,
            this,
            ActionChoisirForme.NOM_ACTION_LIGNE
         )
      );
      ligneBtn.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
      groupBtn.add(ligneBtn);
      this.add(ligneBtn);

      // ellipse
      JToggleButton ellipseBtn = new JToggleButton(
         new ActionChoisirForme(
            this.panneauDessin,
            this,
            ActionChoisirForme.NOM_ACTION_ELLIPSE
         )
      );
      ligneBtn.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
      groupBtn.add(ellipseBtn);
      this.add(ellipseBtn);

      // cercle
      JToggleButton cercleBtn = new JToggleButton(
         new ActionChoisirForme(
            this.panneauDessin,
            this,
            ActionChoisirForme.NOM_ACTION_CERCLE
         )
      );
      ligneBtn.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
      groupBtn.add(cercleBtn);
      this.add(cercleBtn);
   }
}
