package Model;

/**
 * Created by Nicolas on 10/01/2017.
 */
public abstract class Pawn {
    private Color pawnColor;

    public Pawn(Color pawnColor) {
        this.pawnColor = pawnColor;
    }

    public abstract void movePawn(Cell toCell);

    public Color getPawnColor() {
        return pawnColor;
    }

    public void setPawnColor(Color pawnColor) {
        this.pawnColor = pawnColor;
    }
}
