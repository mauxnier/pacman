package adding;

/**
 * Classe permettant d'utiliser les tuples en java.
 * @link https://www.baeldung.com/java-method-return-multiple-values
 * @param <K> Premier type
 * @param <V> Deuxième type
 */
public class Tuple2<K, V> {

    private K x;
    private V y;

    public Tuple2(K x, V y){
        this.x = x;
        this.y = y;
    }

    public K getX() {
        return x;
    }

    public void setX(K first) {
        this.x = x;
    }

    public V getY() {
        return y;
    }

    public void setY(V y) {
        this.y = y;
    }
}