package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Forme;

import java.awt.Graphics2D;

public abstract class VueForme {
   // attributs
   protected final Forme forme;

   // constructeur
   public VueForme(Forme forme){
      this.forme=forme;
   }

   // getter
   public Forme getForme(){
      return this.forme;
   }

   // methodes
   public abstract void affiche(Graphics2D g2d);
}
