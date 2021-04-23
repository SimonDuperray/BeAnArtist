package fr.eseo.poo.projet.artiste.vue.ihm;

// external imports
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import java.awt.Dimension;
import javax.swing.ButtonGroup;

// internal imports
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirRemplissage;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

public class PanneauBarreOutils extends javax.swing.JPanel {

   private static final long serialVersionUID = 1L;

   // class constants
   public static final String BRANCHE_SPINNER_NOM = "Nb branches";
   public static final String LONGUEUR_SPINNER_NOM = "Long branches";

   // attributes
   private PanneauDessin panneauDessin;
   private JSpinner spinnerNbBranches = new JSpinner();
   private JSpinner spinnerLongBranches = new JSpinner();

   // constructor
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

   // private methods
   private JToggleButton createToggleEllipse(){
      JToggleButton ellipseBtn = new JToggleButton(
         new ActionChoisirForme(
            this.panneauDessin,
            this,
            ActionChoisirForme.NOM_ACTION_ELLIPSE
         )
      );
      ellipseBtn.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
      return ellipseBtn;
   }
   private JToggleButton createToggleCercle(){
      JToggleButton cercleBtn = new JToggleButton(
         new ActionChoisirForme(
            this.panneauDessin,
            this,
            ActionChoisirForme.NOM_ACTION_CERCLE
         )
      );
      cercleBtn.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
      return cercleBtn;
   }
   private JToggleButton createToggleLigne(){
      JToggleButton ligneBtn = new JToggleButton(
         new ActionChoisirForme(
            this.panneauDessin,
            this,
            ActionChoisirForme.NOM_ACTION_LIGNE
         )
      );
      ligneBtn.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
      return ligneBtn;
   }
   private JToggleButton createToggleEtoile(){
      JToggleButton etoileBtn = new JToggleButton(
         new ActionChoisirForme(
            this.panneauDessin,
            this,
            ActionChoisirForme.NOM_ACTION_ETOILE
         )
      );
      etoileBtn.setName(ActionChoisirForme.NOM_ACTION_ETOILE);
      return etoileBtn;
   }
   private JToggleButton createToggleRectangle(){
      JToggleButton rectangleBtn = new JToggleButton(
         new ActionChoisirForme(
            this.panneauDessin,
            this,
            ActionChoisirForme.NOM_ACTION_RECTANGLE
         )
      );
      rectangleBtn.setName(ActionChoisirForme.NOM_ACTION_RECTANGLE);
      return rectangleBtn;
   }
   private JToggleButton createToggleCarre(){
      JToggleButton carreBtn = new JToggleButton(
         new ActionChoisirForme(
            this.panneauDessin,
            this,
            ActionChoisirForme.NOM_ACTION_CARRE
         )
      );
      carreBtn.setName(ActionChoisirForme.NOM_ACTION_CARRE);
      return carreBtn;
   }

   // methodes
   public void initComponents(){
      ButtonGroup groupBtn = new ButtonGroup();

      JButton effacerBtn = new JButton(new ActionEffacer(this.panneauDessin));
      effacerBtn.setName(ActionEffacer.NOM_ACTION);
      this.add(effacerBtn);

      // toggles buttons

      // bouton ligne
      JToggleButton ligneBtn = this.createToggleLigne();
      groupBtn.add(ligneBtn);
      this.add(ligneBtn);

      // bouton ellipse
      JToggleButton ellipseBtn = this.createToggleEllipse();
      groupBtn.add(ellipseBtn);
      this.add(ellipseBtn);

      // bouton cercle
      JToggleButton cercleBtn = this.createToggleCercle();
      groupBtn.add(cercleBtn);
      this.add(cercleBtn);

      // bouton etoile
      JToggleButton etoileBtn = this.createToggleEtoile();
      groupBtn.add(etoileBtn);
      this.add(etoileBtn);

      // etoile spinner longueur branches
      JLabel labelLongBranches = new JLabel();
      labelLongBranches.setName(LONGUEUR_SPINNER_NOM);
      SpinnerNumberModel modelLongBrancheSpinner = new SpinnerNumberModel(
         Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, 0.00, 1.00, 0.01
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

      // rectangle
      JToggleButton rectangleBtn = this.createToggleRectangle();
      groupBtn.add(rectangleBtn);
      this.add(rectangleBtn);

      // carre
      JToggleButton carreBtn = this.createToggleCarre();
      groupBtn.add(carreBtn);
      this.add(carreBtn);

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