package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 09/01/2017.
 */
public class Board {

    private int nbRows;
    private int nbCols;
    private int nbPawns;
    private List<List<Cell>> cells;

    public Board() {
        //Default board if no size and pawns are given
        new Board(10, 10, 20);
    }

    public Board(int nbRows, int nbCols, int nbPawns) {
        this.nbRows = nbRows;
        this.nbCols = nbCols;
        this.nbPawns = nbPawns;
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

    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

}
