package data;

import adding.Tuple2;

public class Ghost implements IGhost {
    /**
     * Retourne la grille de jeu lié au fantôme.
     * @return la grille de jeu.
     */
    @Override
    public Grid getGrid() {
        return null;
    }

    /**
     * Donne la position du fantôme sur la grille de jeu.
     * @return position du fantôme
     */
    @Override
    public Tuple2<Integer, Integer> getPos() {
        return null;
    }

    /**
     * Donne la valeur en points du fantôme.
     * Utilisé quand il est mangé par le pacman.
     * @return points du fantôme
     */
    @Override
    public int getPoints() {
        return 0;
    }

    /**
     * Donne la couleur du fantôme.
     * @return couleur du fantôme
     */
    @Override
    public String getColor() {
        return null;
    }

    /**
     * Retourne la forme du fantôme.
     * @return forme du fantôme
     */
    @Override
    public String getShape() {
        return null;
    }

    /**
     * Retourne le comportement du fantôme.
     * @return comportement du fantôme
     */
    @Override
    public String getBehaviour() {
        return null;
    }
}