package adding;

/**
 * Classe permettant d'utiliser des coordonnées.
 */
public class Pos extends Tuple2<Integer, Integer> {

    public Pos(int x, int y) {
        super(x, y);
    }

    /**
     * Retourne x.
     * @return x
     */
    public int getX() {
        return getFirst();
    }

    /**
     * Retourne y.
     * @return y
     */
    public int getY() {
        return getSecond();
    }

    /**
     * Change la valeur de x.
     * @param x
     */
    public void setX(int x) {
        setFirst(x);
    }

    /**
     * Change la valeur de y.
     * @param y
     */
    public void setY(int y) {
        setSecond(y);
    }
}