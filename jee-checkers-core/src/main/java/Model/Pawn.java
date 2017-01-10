package Model;

/**
 * Created by Nicolas on 10/01/2017.
 */
public abstract class Pawn {
    private Color pawnColor;

    private Cell cellOn;

    public Pawn(Color pawnColor, Cell currentCell) {
        this.pawnColor = pawnColor;
        this.cellOn = currentCell;
    }

    public abstract void movePawn(Cell toCell);

    public Color getPawnColor() {
        return pawnColor;
    }

    public void setPawnColor(Color pawnColor) {
        this.pawnColor = pawnColor;
    }

    public Cell getCellOn() {
        return cellOn;
    }

    public void setCellOn(Cell cellOn) {
        this.cellOn = cellOn;
    }
}
