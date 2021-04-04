package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;

public class VueEllipse extends VueForme{
   // constructeur
   public VueEllipse(Ellipse ellipse){
      super(ellipse);
   }

   // methodes
   public void affiche(Graphics2D g2d) {
      Color bufferCouleur = g2d.getColor();
      g2d.setColor(this.getForme().getCouleur());
      int x = (int)((Ellipse) this.getForme()).getPosition().getAbscisse();
      int y = (int)((Ellipse) this.getForme()).getPosition().getOrdonnee();
      int larg = (int)((Ellipse) this.getForme()).getLargeur();
      int haut = (int)((Ellipse) this.getForme()).getHauteur();
      if(((Ellipse) this.getForme()).estRempli()){
         g2d.fillOval(x, y, larg, haut);
      }
      g2d.drawOval(x, y, larg, haut);
      g2d.setColor(bufferCouleur);
   }
}
