package view;

public class Gomme extends Figure {

    private Figure[] figures;
    private boolean supra;
    private static final String COLOR_WALK = "black";
    private static final String COLOR_GOM = "white";
    public static final int SCORE_GOMME = 10;

    /**
     * constructeur d'une case de jeu Gomme
     * sans gomme
     * @param  int size          la taille de la case
     * @param  int x             la position absolue x
     * @param  int y             la position absolue y
     */
    public Gomme(int size, int x, int y) {
        super(size, size, x, y, "black");
        this.figures = new Figure[2];
        this.figures[0] = new Square(size, x, y, this.COLOR_WALK);
    }

    /**
     * constructeur d'une case de jeu Gomme
     * avec une gomme pouvant etre une supraGomme
     * parametre supra true si est une supragomme
     * @param  int size          la taille de la case
     * @param  int x             la position absolue x
     * @param  int y             la position absolue y
     * @param  boolean supra     determine si l'objet est une superGomme
     */
    public Gomme(int size, int x, int y, boolean supra) {
        this(size, x, y);

        this.supra = supra;
        int sg = size;
        if (this.supra) {
            sg = size/2;
        } else {
            sg = size/5;
        }
        int xg = x+(size/2)-(sg/2);
        int yg = y+(size/2)-(sg/2);
        this.figures[1] = new Circle(sg, xg, yg, this.COLOR_GOM);
    }

    /**
     * place une gomme sur la case
     * @param Circle c objet formant une gomme
     */
    public void setGomme (Circle c) {
        this.figures[1] = c;
    }

    /**
     * retourne la gomme presente ou non sur la case
     * @return l'objet Circle si exist sinon NULL
     */
    public Figure getGomme () {
        return this.figures[1];
    }

    public boolean getSupra() {
        return this.supra;
    }

    /**
     * dessine l'objet case Gomme
     * Square (fond)
     * Circle (gomme si exist)
     */
    public void draw () {
        for (Figure f : this.figures) {
            if (f!=null) {
                f.draw();
            }
        }
    }

}
