package data;

import adding.Tuple2;

public class Grid implements IGrid {
    /**
     * Retourne le jeu lié à la grille de jeu.
     * @return le jeu
     */
    @Override
    public Game getGame() {
        return null;
    }

    /**
     * Donne la position des murs sur la grille de jeu.
     * @param level le niveau de jeu
     * @return la position des murs
     */
    @Override
    public Tuple2<Integer, Integer>[] getWallsPos(int level) {
        return new Tuple2[0];
    }

    /**
     * Donne la position initiale des fruits sur la grille de jeu.
     * @param level le niveau de jeu
     * @return position initiale des fruits
     */
    @Override
    public Tuple2<Integer, Integer>[] getFruitsSpawnPos(int level) {
        return new Tuple2[0];
    }

    /**
     * Donne la position initiale des fantômes sur la grille de jeu.
     * @param level le niveau de jeu
     * @return position initiale du fantômes
     */
    @Override
    public Tuple2<Integer, Integer> getGhostSpawnPos(int level) {
        return null;
    }

    /**
     * Donne la position initiale du pacman sur la grille de jeu.
     * @param level le niveau de jeu
     * @return position initiale du pacman
     */
    @Override
    public Tuple2<Integer, Integer> getPacmanSpawnPos(int level) {
        return null;
    }

    /**
     * Met en place les murs pour le niveau de jeu.
     */
    @Override
    public void placeWalls() {

    }

    /**
     * Met en place les fruits pour le niveau de jeu.
     */
    @Override
    public void placeFruits() {

    }

    /**
     * Met en place les fantômes pour le niveau de jeu.
     */
    @Override
    public void placeGhosts() {

    }

    /**
     * Met en place pacman pour le niveau de jeu.
     */
    @Override
    public void placePacman() {

    }

    /**
     * Donne si la position donnée en paramètre correspond à un mur.
     * @param coords couple (x, y) correspondant à la position dans la grille de jeu.
     * @return si la position correspond à un mur
     */
    @Override
    public boolean isPosAWall(Tuple2<Integer, Integer> coords) {
        return false;
    }
}