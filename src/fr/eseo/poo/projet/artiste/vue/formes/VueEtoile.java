package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import java.awt.Polygon;

import java.awt.Color;
import java.awt.Graphics2D;

public class VueEtoile extends VueForme {
   // constructeur
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