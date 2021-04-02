package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Graphics2D;
import java.awt.Color;

import fr.eseo.poo.projet.artiste.modele.formes.Ligne;

public class VueLigne extends VueForme {

   // constructeur
   public VueLigne(Ligne ligne){
      super(ligne);
   }

   public void affiche(Graphics2D g2d) {
      Color bufferCouleur = g2d.getColor();
      g2d.setColor(this.getForme().getCouleur());
      int x1 = (int)((Ligne) this.getForme()).getC1().getAbscisse();
      int y1 = (int)((Ligne) this.getForme()).getC1().getOrdonnee();
      int x2 = (int)((Ligne) this.getForme()).getC2().getAbscisse();
      int y2 = (int)((Ligne) this.getForme()).getC2().getOrdonnee();
      g2d.drawLine(x1, y1, x2, y2);
      g2d.setColor(bufferCouleur);
   }
}
