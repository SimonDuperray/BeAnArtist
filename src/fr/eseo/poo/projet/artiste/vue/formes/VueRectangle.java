package fr.eseo.poo.projet.artiste.vue.formes;

// external imports
import java.awt.Color;
import java.awt.Graphics2D;

// internal imports
import fr.eseo.poo.projet.artiste.modele.formes.Rectangle;

public class VueRectangle extends VueForme{
   
   // constructor
   public VueRectangle(Rectangle rectangle){
      super(rectangle);
   }

   // methodes
   public void affiche(Graphics2D g2d) {
      Color bufferCouleur = g2d.getColor();
      g2d.setColor(this.getForme().getCouleur());
      int x = (int)((Rectangle) this.getForme()).getPosition().getAbscisse();
      int y = (int)((Rectangle) this.getForme()).getPosition().getOrdonnee();
      int larg = (int)((Rectangle) this.getForme()).getLargeur();
      int haut = (int)((Rectangle) this.getForme()).getHauteur();
      if(((Rectangle) this.getForme()).estRempli()){
         g2d.fillRect(x, y, larg, haut);
      }
      g2d.drawRect(x, y, larg, haut);
      g2d.setColor(bufferCouleur);
   }
}
