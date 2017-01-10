package Model;

/**
 * Created by Nicolas on 10/01/2017.
 */
public class Cell {

    private int rowIndex;
    private int colIndex;
    private CellColor cellColor;

    public Cell(int row, int col) {
        rowIndex = row;
        colIndex = col;
        //TODO : compute the color based on the position of the cell
        cellColor = CellColor.BLACK;
    }
}
