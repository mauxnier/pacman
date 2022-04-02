package logic;

/**
 * Interface de la classe Pacman de la couche Logic.
 * Couche Logic : donner l’état du jeu en fonction d’une direction.
 */
public interface IPacman {

    /**
     * Bouge le pacman.
     */
    public void move();

    /**
     * Mange un fruit.
     * @param eatedFruit le fruit mangé
     */
    public void eatFruit(Fruit eatedFruit);

    /**
     * Mange un fantôme.
     * @param eatedGhost le fantôme mangé
     */
    public void eatGhost(Ghost eatedGhost);

    /**
     * Donne le pouvoir de manger les fantômes.
     */
    public void superpower();

    /**
     * Blesse le pacman en lui retirant une vie.
     */
    public void hurt();

    /**
     * Tue le pacman.
     */
    public void die();

    /**
     * Retourne si le pacman est sur un fantôme.
     * @return pacman sur un fantôme
     */
    public boolean isOnGhost();

    /**
     * Retourne si le pacman est sur un fruit.
     * @return pacman sur un fruit
     */
    public boolean isOnFruit();

}