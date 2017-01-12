package Game;

import Model.Board;
import Model.Cell;
import Model.Color;
import Model.Pawn;
import Exception.*;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.List;

/**
 * Created by Nicolas on 10/01/2017.
 */
public class GameCheckersImpl implements GameCheckers {

    private Board board;

    public GameCheckersImpl() {
        this.board = new Board();
        System.out.println(this.board);
    }

    public GameCheckersImpl(int rows, int columns) {
        this.board = new Board(rows, columns);
    }

    public Board getBoard() {
        return this.board;
    }

    @Override
    public void play(Pawn pawn, int row, int col){

    }

    public void movePawn(Board board, int originRow, int originCol, int destRow, int destCol) throws GameException {
        Cell originCell = null;
        Cell destCell = null;

        if (board.isCoordinateInTheBoard(originRow, originCol) && board.isCoordinateInTheBoard(destRow, destCol)){
            originCell = board.getCell(originRow, originCol);
            destCell = board.getCell(destRow, destCol);
        }else {
            throw new GameException("Coordinate are out of the board");
        }

        //Check if the selected cell contains pawn
        if (originCell.hasPawn() == true){

        }else{
            throw new GameException("Cell does not contains pawn");
        }
    }

    private boolean isQueenPosition(Cell cell) {
        if(cell.getRowIndex() == 0 || cell.getRowIndex() == getBoard().getNbRows() -1){
            return true;
        }
        return false;
    }



}
