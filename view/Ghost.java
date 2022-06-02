package view;

import view.src.Circle;
import view.src.CompoundFigure;
import view.src.Figure;

/**
 * Classe Ghost de la couche View.
 * Couche View : affiche le nouvel état du jeu à chaque “pas de jeu”.
 * @author Ikrame Bakkari
 * @version 01/06/2022
 */
public class Ghost extends CompoundFigure {

    /** Tableau des figure composants le fantome */
    private Figure[] figures;

    public Ghost(int size, int x, int y, String color) {

        int diametrehead=(int)(size);
        int heightbody=(int)(size/2.6);
        int sizeleg=size/5;
        int eyesize=(int)(size/3.5);
        int insideeyesize=eyesize/2;

        figures = new Figure[9];

        figures[0] = new ArcCircle(size,x,y,color,0,180); // head
        figures[1] = new Rectangle(diametrehead,heightbody,x,y+diametrehead/2,color); // body

        figures[2] = new ArcCircle(sizeleg,x,y+diametrehead/2+heightbody-sizeleg/2,color,180,180); // leg
        figures[3] = new ArcCircle(sizeleg,x+4*sizeleg,y+diametrehead/2+heightbody-sizeleg/2,color,180,180); // leg
        figures[4] = new ArcCircle(sizeleg,x+2*sizeleg,y+diametrehead/2+heightbody-sizeleg/2,color,180,180);//leg

        figures[5] = new Circle(eyesize,x+eyesize/2,y+diametrehead/2-eyesize,"white");//eye
        figures[6] = new Circle(eyesize,(int)(x+size-1.5*eyesize),y+diametrehead/2-eyesize,"white");//eye
        figures[7] = new Circle(insideeyesize,x+eyesize/2+insideeyesize/2,y+diametrehead/2-eyesize+insideeyesize/2,"black");//eye
        figures[8] = new Circle(insideeyesize,(int)(x+size-1.5*eyesize+insideeyesize/2),y+diametrehead/2-eyesize+insideeyesize/2,"black");//eye
    }


    public Figure[] getFigures () {
        return this.figures;
    }

    /**
     * retourne la position x de l'entite
     * @return la position x de l'entite
     */
    public int getX () {
        return this.figures[0].getX();
    }

    /**
     * retourne la position y de l'entite
     * @return la position y de l'entite
     */
    public int getY () {
        return this.figures[0].getY();
    }

    /**
     * retourne la taille de l'Entite fantome
     * @return la taille de Ghost
     */
    public int getWidth () {
        return this.figures[0].getWidth();
    }

    /**
     * Draw the figure with current specifications on screen.
     */
    public void draw() {
        for (Figure figure : this.figures) {
            figure.draw();
        }
    }

}
