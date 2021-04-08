package fr.eseo.poo.projet.artiste.vue.formes;

// external imports
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

// internal imports
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

public class VueEtoile extends VueForme {
   
   // constructor
   public VueEtoile(Etoile etoile){
      super(etoile);
   }

   // methodes
   public void affiche(Graphics2D g2d){
      Color bufferCouleur = g2d.getColor();
      g2d.setColor(this.getForme().getCouleur());
      Polygon p = new Polygon();
      for(int i=0; i<((Etoile)this.getForme()).getCoordonnees().size(); i++){
         p.addPoint(
            Math.toIntExact(Math.round(((Etoile)this.getForme()).getCoordonnees().get(i).getAbscisse())),
            Math.toIntExact(Math.round(((Etoile)this.getForme()).getCoordonnees().get(i).getOrdonnee()))
         );
      }
      if(((Etoile) this.getForme()).estRempli()){
         g2d.fillPolygon(p);
      }
      g2d.drawPolygon(p);
      g2d.setColor(bufferCouleur);
   }
}