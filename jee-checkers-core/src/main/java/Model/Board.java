package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 09/01/2017.
 */
public class Board {

    private int nbRows;
    private int nbCols;
    private List<List<Cell>> cells;

    public Board() {
        //Default board if no size and pawns are given
        new Board(10, 10);
    }

    public Board(int nbRows, int nbCols) {
        this.nbRows = nbRows;
        this.nbCols = nbCols;
        this.cells = initCells();
        initPawns();
    }

    private List<List<Cell>> initCells() {
        List<List<Cell>> cells = new ArrayList<>(nbRows);
        for (int row = 0; row < nbRows; row++) {
            List<Cell> colsCells = new ArrayList<Cell>(nbCols);
            for (int col = 0; col < nbCols; col++) {
                colsCells.add(new Cell(row, col));
            }
            cells.add(colsCells);
        }
        return cells;
    }

    private void initPawns() {
        //Put black pawns on white cells on the fourth first line
        initBlackPawns();
        //Put white pawns on black cells on the fourth last lines
        initWhitePawns();
    }

    private void initWhitePawns() {
        for (int row = nbRows - 1; row < nbRows - 4; row--) {
            for (int col = 0; col < nbCols; col++) {
                Cell currentCell = cells.get(row).get(col);
                if (currentCell.getCellColor() == CellColor.BLACK) {
                    currentCell.setPawn(new NormalPawn());
                }
            }
        }
    }

    private void initBlackPawns() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < nbCols; col++) {
                Cell currentCell = cells.get(row).get(col);
                if (currentCell.getCellColor() == CellColor.WHITE) {
                    currentCell.setPawn(new NormalPawn());
                }
            }
        }
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

}
