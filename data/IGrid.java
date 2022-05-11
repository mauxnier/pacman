package data;

import adding.Tuple2;

/**
 * Interface de la classe Grid de la couche Data.
 * Couche Data : donner l’état initial du jeu pour un niveau donné.
 */
public interface IGrid {

    /**
     * Retourne le jeu lié à la grille de jeu.
     * @return le jeu
     */
    public Game getGame();

    /**
     * Donne la position des murs sur la grille de jeu.
     * @param level le niveau de jeu
     * @return la position des murs
     */
    public Tuple2<Integer, Integer>[] getWallsPos(int level);

    /**
     * Donne la position initiale des fruits sur la grille de jeu.
     * @param level le niveau de jeu
     * @return position initiale des fruits
     */
    public Tuple2<Integer, Integer>[] getFruitsSpawnPos(int level);

    /**
     * Donne la position initiale des fantômes sur la grille de jeu.
     * @param level le niveau de jeu
     * @return position initiale du fantômes
     */
    public Tuple2<Integer, Integer> getGhostSpawnPos(int level);

    /**
     * Donne la position initiale du pacman sur la grille de jeu.
     * @param level le niveau de jeu
     * @return position initiale du pacman
     */
    public Tuple2<Integer, Integer> getPacmanSpawnPos(int level);

    /**
     * Met en place les murs pour le niveau de jeu.
     */
    public void placeWalls();

    /**
     * Met en place les fruits pour le niveau de jeu.
     */
    public void placeFruits();

    /**
     * Met en place les fantômes pour le niveau de jeu.
     */
    public void placeGhosts();

    /**
     * Met en place pacman pour le niveau de jeu.
     */
    public void placePacman();

    /**
     * Donne si la position donnée en paramètre correspond à un mur.
     * @param coords couple (x, y) correspondant à la position dans la grille de jeu.
     * @return si la position correspond à un mur
     */
    public boolean isPosAWall(Tuple2<Integer, Integer> coords);
}