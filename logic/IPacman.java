package logic;

/**
 * Interface de la classe Pacman de la couche Logic.
 * Couche Logic : donner l'état du jeu en fonction d'une direction.
 * @author Abdella Boudaoud
 * @version 02/06/2022
 */
public interface IPacman {

    /**
     * Bouge le pacman.
     */
    public void move(String direction);

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

    /**
     * Retourne si le pacman a le pouvoir de manger les fantome.
     * @return pacman avec pouvoir
     */
    public boolean isSuperpowered();

    /**
     * Retourne le nombre de vie restante de pacman.
     * @return le nombre de vie de pacman
     */
    public int getNbLives();

}