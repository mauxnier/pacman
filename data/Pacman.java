package logic;

import adding.Tuple2;
import data.IPacman;

public class Pacman implements IPacman {

    /**
     * Constructeur de la classe.
     */
    public Pacman() {

    }

    /**
     * Retourne la grille de jeu lié au pacman.
     * @return la grille de jeu.
     */
    @Override
    public Grid getGrid() {
        return null;
    }

    /**
     * Donne la position du pacman sur la grille de jeu.
     * @return position du pacman
     */
    @Override
    public Tuple2<Integer, Integer> getPos() {
        return null;
    }

    /**
     * Donne le nombre de vie restant pour le pacman.
     * @return nombre de vie
     */
    @Override
    public int getLives() {
        return 0;
    }
}