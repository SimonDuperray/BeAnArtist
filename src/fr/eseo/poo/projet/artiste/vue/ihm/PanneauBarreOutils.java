package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;

import java.awt.Dimension;

import javax.swing.ButtonGroup;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirRemplissage;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

public class PanneauBarreOutils extends javax.swing.JPanel {

   public static final String BRANCHE_SPINNER_NOM = "Nb branches";
   public static final String LONGUEUR_SPINNER_NOM = "Long branches";

   private static final long serialVersionUID = 1L;
   private PanneauDessin panneauDessin;
   private JSpinner spinnerNbBranches = new JSpinner();
   private JSpinner spinnerLongBranches = new JSpinner();

   // constructeur
   public PanneauBarreOutils(PanneauDessin panneauDessin){
      this.panneauDessin = panneauDessin;
      initComponents();
   }

   // getters
   public int getNbBranches(){
      return (int)this.spinnerNbBranches.getModel().getValue();
   }
   
   @SuppressWarnings("deprecation")
   public double getLongueurBranche(){
       return new Double(this.spinnerLongBranches.getModel().getValue().toString());
   }

   // methodes
   public void initComponents(){
      ButtonGroup groupBtn = new ButtonGroup();
      // effacer
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
      ellipseBtn.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
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
      cercleBtn.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
      groupBtn.add(cercleBtn);
      this.add(cercleBtn);

      // etoile
      JToggleButton etoileBtn = new JToggleButton(
         new ActionChoisirForme(
            this.panneauDessin,
            this,
            ActionChoisirForme.NOM_ACTION_ETOILE
         )
      );
      etoileBtn.setName(ActionChoisirForme.NOM_ACTION_ETOILE);
      groupBtn.add(etoileBtn);
      this.add(etoileBtn);

      // etoile spinner longueur branches
      JLabel labelLongBranches = new JLabel();
      labelLongBranches.setName(LONGUEUR_SPINNER_NOM);
      SpinnerNumberModel modelLongBrancheSpinner = new SpinnerNumberModel(
         Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, 
         0.00, 
         1.00, 
         0.01
      );
      this.spinnerLongBranches.setModel(modelLongBrancheSpinner);
      this.spinnerLongBranches.setName(LONGUEUR_SPINNER_NOM);
      this.spinnerLongBranches.setPreferredSize(new Dimension(50, 30));
      this.add(labelLongBranches);
      this.add(spinnerLongBranches);

      // etoile spinner nb branches
      JLabel labelNbBranches = new JLabel();
      labelNbBranches.setName(BRANCHE_SPINNER_NOM);
      SpinnerNumberModel modelNbBrancheSpinner = new SpinnerNumberModel(
         Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 
         3, 
         15, 
         1
      );
      this.spinnerNbBranches.setName(BRANCHE_SPINNER_NOM);
      this.spinnerNbBranches.setModel(modelNbBrancheSpinner);
      this.spinnerNbBranches.setPreferredSize(new Dimension(50, 30));
      this.add(labelNbBranches);
      this.add(spinnerNbBranches);

      // selectionner
      JToggleButton selectionnerBtn = new JToggleButton(
         new ActionSelectionner(
            this.panneauDessin
         )
      );
      selectionnerBtn.setName(ActionSelectionner.NOM_ACTION);
      groupBtn.add(selectionnerBtn);
      this.add(selectionnerBtn);

      // choisir couleur
      JButton boutonCouleur = new JButton(
         new ActionChoisirCouleur(this.panneauDessin)
      );
      boutonCouleur.setName(ActionChoisirCouleur.NOM_ACTION);
      this.add(boutonCouleur);

      // remplissage
      JCheckBox boutonFond = new JCheckBox(
         new ActionChoisirRemplissage(this.panneauDessin)
      );
      boutonFond.setName(ActionChoisirRemplissage.NOM_ACTION);
      this.add(boutonFond);
   }
}
