package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Dimension;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class PanneauDessin extends javax.swing.JPanel{

   private static final long serialVersionUID = 1L;
   // constances de classe
   private Outil outilCourant;
   public static final int LARGEUR_PAR_DEFAUT = 300;
   public static final int HAUTEUR_PAR_DEFAUT = 300;
   public static final java.awt.Color COULEUR_FOND_PAR_DEFAUT = new Color(0, 0, 255);
   private final List<VueForme> vueFormes;

   // constructeurs
   public PanneauDessin(){
      super();
      super.setPreferredSize(
         new Dimension(
            LARGEUR_PAR_DEFAUT,
            HAUTEUR_PAR_DEFAUT
         ));
      super.setBackground(COULEUR_FOND_PAR_DEFAUT);
      this.vueFormes = new ArrayList<VueForme>();
   }
   public PanneauDessin(int largeur, int hauteur, java.awt.Color fond){
      super();
      super.setPreferredSize(new Dimension(largeur, hauteur));
      super.setBackground(fond);
      this.vueFormes = new ArrayList<VueForme>();
   }
   public PanneauDessin(int largeur, int hauteur){
      super();
      super.setPreferredSize(new Dimension(largeur, hauteur));
      this.vueFormes = new ArrayList<VueForme>();
   }

   // getters
   public List<VueForme> getVueFormes(){
      return this.vueFormes;
   }
   public Outil getOutilCourant(){
      return this.outilCourant;
   }

   // setters
   private void setOutilCourant(Outil outil){
      this.outilCourant = outil;
   }

   // methodes
   public void ajouterVueForme(VueForme vueForme){
      this.vueFormes.add(vueForme);
   }
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D)g.create();
      for(int i=0; i<this.vueFormes.size(); i++){
         vueFormes.get(i).affiche(g2d);
      }
      g2d.dispose(); // nettoie memoire
   }
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
