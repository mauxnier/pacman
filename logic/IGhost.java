package logic;

/**
 * Interface de la classe Ghost de la couche Logic.
 * Couche Logic : donner l’état du jeu en fonction d’une direction.
 */
public interface IGhost {

    moveGhost(int level);

    killPacman();

}