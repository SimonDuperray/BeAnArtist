package fr.eseo.poo.projet.artiste.controleur.outils;

// external imports
import java.awt.event.MouseEvent;

// internal imports
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public abstract class Outil implements javax.swing.event.MouseInputListener {
   
   // attributes
   private Coordonnees debut, fin;
   private PanneauDessin panneauDessin;

   // getters
   public Coordonnees getDebut(){
      return this.debut;
   }
   public Coordonnees getFin(){
      return this.fin;
   }
   public PanneauDessin getPanneauDessin(){
      return this.panneauDessin;
   }

   // setters
   public void setDebut(Coordonnees debut){
      this.debut=debut;
   }
   public void setFin(Coordonnees fin){
      this.fin=fin;
   }
   public void setPanneauDessin(PanneauDessin panneauDessin){
      this.panneauDessin=panneauDessin;
   }

   // methodes
   public void mouseClicked(MouseEvent event){}
   public void mouseDragged(MouseEvent event){}
   public void mouseEntered(MouseEvent event){}
   public void mouseExited(MouseEvent event){}
   public void mouseMoved(MouseEvent event){}
   /**
    * Affecte la variabla début à cette valeur
    * @param event
    */
   public void mousePressed(MouseEvent event){
      this.setDebut(
         new Coordonnees(
            (double)event.getX(),
            (double)event.getY()
         )
      );
   }
   /**
    * Affecte la variable fin à cette valeur
    * @param event
    */
   public void mouseReleased(MouseEvent event){
      setFin(
         new Coordonnees(
            (double)event.getX(),
            (double)event.getY()
         )
      );
   }
}