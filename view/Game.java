package view;

/**
 * Classe Game de la couche View.
 * Couche View : affiche le nouvel état du jeu à chaque “pas de jeu”.
 * @author Killian Monnier
 * @version 01/06/2022
 */
public class Game {
    public static void main(String[] args) {
        PacmanPicture picture = new PacmanPicture();
        picture.draw();
        picture.animate();
    }
}