package Model;

/**
 * Created by Nicolas on 10/01/2017.
 */
public class Cell {

    private int rowIndex;
    private int colIndex;
    private Color cellColor;
    private Pawn pawn;

    public Cell(int row, int col) {
        rowIndex = row;
        colIndex = col;
        //TODO : compute the color based on the position of the cell
        cellColor = Color.BLACK;
    }

    public Color getCellColor() {
        return cellColor;
    }

    public void setCellColor(Color color) {
        this.cellColor = color;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }
}
