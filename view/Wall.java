package view;

/**
 * Class pour la creation d'un mur pour le jeu pacman
 * devant empecher toutes Entite de la traverser
 */
public class Wall extends Square {

    /**
     * constructeur de mur
     * @param  int    size          la taille du mur
     * @param  int    x             position absolue x
     * @param  int    y             position absolue y
     * @param  String color         couleur du mur
     */
    public Wall(int size, int x, int y, String color) {
        super(size, x, y, color);
    }

}
