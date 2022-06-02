package logic;

import adding.Pos;

/**
 * Classe Block de la couche Logic.
 * Couche Logic : calcule le nouvel état du jeu à chaque “pas de jeu” en fonction de la direction choisie par l’utilisateur.
 * @author Abdella Boudaoud
 * @version 02/06/2022
 */
public class Block {

    /** Attributs */
    private String name; // Nom du bloc dans le CSV
    private int x; // Position en x dans la grille
    private int y; // Position en y dans la grille
    private data.Block dataBlock; // Données de la couche data
    private Grid grid; // Grille de jeu de la couche logic

    /**
     * Constructeur de la classe.
     * @param block
     * @param grid
     */
    public Block(data.Block dataBlock, Grid grid) {
        this.dataBlock = dataBlock;
        this.grid = grid;
        this.name = this.dataBlock.getName();
        this.x = this.dataBlock.getPos().getX();
        this.y = this.dataBlock.getPos().getY();
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

    public data.Block getDataBlock() {
        return dataBlock;
    }

    public void setDataBlock(data.Block dataBlock) {
        this.dataBlock = dataBlock;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}