package Model;

import java.util.ArrayList;
import java.util.List;
import Exception.*;

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
                Cell currentCell = getCell(row, col);
                if (currentCell.getCellColor() == Color.BLACK) {
                    currentCell.setPawn(new NormalPawn(Color.WHITE));
                }
            }
        }
    }

    private void initBlackPawns() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < nbCols; col++) {
                Cell currentCell = getCell(row, col);
                if (currentCell.getCellColor() == Color.BLACK) {
                    currentCell.setPawn(new NormalPawn(Color.BLACK));
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

    public Cell getCell(int row, int col){
        return this.cells.get(row).get(col);
    }

    public boolean isCoordinateInTheBoard(int row, int col){
        if (row < nbRows || col < nbCols){
            return true;
        }
        return false;
    }

    public void movePawn(int originRow, int originCol, int destRow, int destCol) throws GameException {
        Cell originCell = null;
        Cell destCell = null;

        if (isCoordinateInTheBoard(originRow, originCol) && isCoordinateInTheBoard(destRow, destCol)){
            originCell = getCell(originRow, originCol);
            destCell = getCell(destRow, destCol);
        }else {
            throw new GameException("Coordinate are out of the board");
        }

        //Check if the selected cell contains pawn
        if (originCell.hasPawn() == true){

        }else{
            throw new GameException("Cell does not contains pawn");
        }
    }

}
