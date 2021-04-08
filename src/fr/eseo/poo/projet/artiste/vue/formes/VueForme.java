package fr.eseo.poo.projet.artiste.vue.formes;

// external imports
import java.awt.Graphics2D;

// internal imports
import fr.eseo.poo.projet.artiste.modele.formes.Forme;

public abstract class VueForme {

   // attributes
   protected final Forme forme;

   // constructor
   public VueForme(Forme forme){
      this.forme=forme;
   }

   // getters
   public Forme getForme(){
      return this.forme;
   }

   // methodes
   public abstract void affiche(Graphics2D g2d);
}
