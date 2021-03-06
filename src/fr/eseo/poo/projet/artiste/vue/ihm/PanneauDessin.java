package fr.eseo.poo.projet.artiste.vue.ihm;

// external imports
import java.awt.Dimension;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

// internal imports
import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class PanneauDessin extends JPanel{

   private static final long serialVersionUID = 1L;

   // class constants
   public static final int LARGEUR_PAR_DEFAUT = 300;
   public static final int HAUTEUR_PAR_DEFAUT = 300;
   public static final java.awt.Color COULEUR_FOND_PAR_DEFAUT = new Color(0, 0, 255);
   
   // attributes
   private final List<VueForme> vueFormes;
   private Color couleurCourante;
   private Outil outilCourant;
   private boolean modeRemplissage;

   // constructors
   public PanneauDessin(){
      super();
      super.setPreferredSize(
         new Dimension(
            LARGEUR_PAR_DEFAUT,
            HAUTEUR_PAR_DEFAUT
         )
      );
      super.setBackground(COULEUR_FOND_PAR_DEFAUT);
      this.vueFormes = new ArrayList<VueForme>();
      this.couleurCourante = Forme.COULEUR_PAR_DEFAUT;
   }
   public PanneauDessin(int largeur, int hauteur, java.awt.Color fond){
      super();
      super.setPreferredSize(new Dimension(largeur, hauteur));
      super.setBackground(fond);
      this.vueFormes = new ArrayList<VueForme>();
      this.couleurCourante = Forme.COULEUR_PAR_DEFAUT;
   }
   public PanneauDessin(int largeur, int hauteur){
      super();
      super.setPreferredSize(new Dimension(largeur, hauteur));
      this.vueFormes = new ArrayList<VueForme>();
      this.couleurCourante = Forme.COULEUR_PAR_DEFAUT;
   }

   // getters
   public List<VueForme> getVueFormes(){
      return this.vueFormes;
   }
   public Outil getOutilCourant(){
      return this.outilCourant;
   }
   public Color getCouleurCourante(){
      return this.couleurCourante;
   }
   public boolean getModeRemplissage(){
      return this.modeRemplissage;
   }

   // setters
   private void setOutilCourant(Outil outil){
      this.outilCourant = outil;
   }
   public void setCouleurCourante(Color couleurCourante){
      this.couleurCourante = couleurCourante;
   }
   public void setModeRemplissage(boolean mode){
      this.modeRemplissage = mode;
   }

   // methodes
   public void ajouterVueForme(VueForme vueForme){
      this.vueFormes.add(vueForme);
   }

   /**
    * Affiche toutes les formes associ??es lorsque la fen??tre est ouverte
    * ou rafra??chie
    * @param g
    */
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D)g.create();
      for(int i=0; i<this.vueFormes.size(); i++){
         vueFormes.get(i).affiche(g2d);
      }
      g2d.dispose(); // nettoie memoire
   }
   /**
    * Associe l'outil donn?? en param??tre en tant qu'OutilCourant
    * Ajoute l'outil en tant que gestionnaire d'??v??nement au panneau d'??dition
    * @param outil
    */
   public void associerOutil(Outil outil){
      if(outil==null){}
      else if(this.getOutilCourant()==null){
         setOutilCourant(outil);
         getOutilCourant().setPanneauDessin(this);
         this.addMouseListener(outil);
         this.addMouseMotionListener(outil);
      } else {
         dissocierOutil();
         setOutilCourant(outil);
         getOutilCourant().setPanneauDessin(this);
         this.addMouseListener(outil);
         this.addMouseMotionListener(outil);
      }
   }
   // /**
   //  * Supprime en tant que gestionnaire d'??v??nements du panneau d'??dition
   //  * l'outil associ?? en tant qu'OutilCourant
   //  */
   private void dissocierOutil(){
      if(this.getOutilCourant() != null){
         if(this.getOutilCourant().getPanneauDessin() != null){
            this.removeMouseListener(this.getOutilCourant());
            this.removeMouseMotionListener(this.getOutilCourant());
            getOutilCourant().setPanneauDessin(null);
            setOutilCourant(null);
         }
      }
   }
}
