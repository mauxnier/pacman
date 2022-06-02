package logic;

/**
 * Interface de la classe Ghost de la couche Logic.
 * Couche Logic : donner l'état du jeu en fonction d'une direction.
 * @author Abdella Boudaoud
 * @version 02/06/2022
 */
public interface IGhost {

    /**
     * Bouge le fantôme.
     */
    public void move();

    /**
     * Mange un pacman.
     * @param eatedPacman le pacman mangé
     */
    public void eatPacman(Pacman eatedPacman);

    /**
     * Tue le fantôme.
     */
    public void die();

}