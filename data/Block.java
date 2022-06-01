package data;

import adding.Pos;

/**
 * Classe Block de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 * @author Killian Monnier
 * @version 01/06/2022
 */
public class Block {

    /** Attributs */
    private String name; // Nom du bloc dans le CSV
    private int x; // Position en x dans le CSV
    private int y; // Position en y dans le CSV

    /**
     * Constructeur de la classe
     * @param name nom du bloc
     * @param x position x
     * @param y position y
     */
    public Block(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    /**
     * Donne le nom du block sur la grille de jeu.
     * @return nom du block
     */
    public String getName() {
        return this.name;
    }

    /**
     * Donne la position du block sur la grille de jeu.
     * @return position du block
     */
    public Pos getPos() {
        return new Pos(this.x, this.y);
    }

    /**
     * Change le nom du bloc.
     * @param name nom du bloc
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Change la position du bloc.
     * @param pos position x et y
     */
    public void setPos(Pos pos) {
        this.x = pos.getX();
        this.y = pos.getY();
    }
}