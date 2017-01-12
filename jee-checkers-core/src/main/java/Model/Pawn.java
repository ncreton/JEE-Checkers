package Model;

/**
 * Created by Nicolas on 10/01/2017.
 */
public class Pawn {
    private Color pawnColor;
    private PawnType pawnType;

    public Pawn(Color pawnColor, PawnType type) {
        this.pawnColor = pawnColor;
        this.pawnType = type;
    }

    public Color getPawnColor() {
        return pawnColor;
    }

    public void setPawnColor(Color pawnColor) {
        this.pawnColor = pawnColor;
    }

    public PawnType getPawnType() {
        return pawnType;
    }

    public void setPawnType(PawnType pawnType) {
        this.pawnType = pawnType;
    }
}
