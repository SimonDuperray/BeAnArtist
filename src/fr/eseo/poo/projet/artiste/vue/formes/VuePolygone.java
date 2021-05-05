package fr.eseo.poo.projet.artiste.vue.formes;

//external imports
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

//internal imports
import fr.eseo.poo.projet.artiste.modele.formes.Polygone;

public class VuePolygone extends VueForme {

// constructor
public VuePolygone(Polygone polygone){
   super(polygone);
}

// methodes
public void affiche(Graphics2D g2d){
   Color bufferCouleur = g2d.getColor();
   g2d.setColor(this.getForme().getCouleur());
   Polygon p = new Polygon();
   for(int i=0; i<((Polygone)this.getForme()).getCoordonnees().size(); i++){
      p.addPoint(
         Math.toIntExact(Math.round(((Polygone)this.getForme()).getCoordonnees().get(i).getAbscisse())),
         Math.toIntExact(Math.round(((Polygone)this.getForme()).getCoordonnees().get(i).getOrdonnee()))
      );
   }
   if(((Polygone) this.getForme()).estRempli()){
      g2d.fillPolygon(p);
   }
   g2d.drawPolygon(p);
   g2d.setColor(bufferCouleur);
}
}