package Game;

import Model.Board;
import Model.Cell;
import Model.Color;
import Model.Pawn;
import Exception.*;

import java.util.List;

/**
 * Created by Nicolas on 10/01/2017.
 */
public class GameCheckersImpl implements GameCheckers {

    private Board board;

    public GameCheckersImpl() {
        this.board = new Board();
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

        //Check if the pawn is not outside the board
        if (board.isCoordinateInTheBoard(originRow, originCol) && board.isCoordinateInTheBoard(destRow, destCol)){
            originCell = board.getCell(originRow, originCol);
            destCell = board.getCell(destRow, destCol);
        }else {
            throw new GameException("Coordinate are out of the board");
        }

        //Check if the selected cell contains pawn
        if (originCell.hasPawn() && !destCell.hasPawn()){
            Pawn currentPawn = originCell.getPawn();
            if(isValidMovePawn(currentPawn, originRow, originCol, destRow, destCol) == true){
                originCell.setPawn(null);
                destCell.setPawn(currentPawn);
            }
            else {
                throw new GameException("Not a possible move");
            }
        }else{
            throw new GameException("Cell does not contains pawn");
        }
    }

    public boolean isValidMovePawn(Pawn pawn, int originRow, int originCol, int destRow, int destCol) {
        if(pawn.getPawnColor() == Color.BLACK){
            if(isSimpleMove(Color.BLACK,originRow, originCol, destRow, destCol)){
                return true;
            }
        }
        if(pawn.getPawnColor() == Color.WHITE){
            if(isSimpleMove(Color.WHITE,originRow, originCol, destRow, destCol)){
                return true;
            }
        }
        return false;
    }

    private boolean isSimpleMove(Color color, int originRow, int originCol, int destRow, int destCol) {
        if(color == Color.BLACK && destRow == originRow + 1 && destCol == originCol - 1  || destRow == originRow + 1 && destCol == originCol + 1){
            return true;
        }

        if(color == Color.WHITE && destRow == originRow - 1 && destCol == originCol - 1  || destRow == originRow - 1 && destCol == originCol + 1){
            return true;
        }
        return false;
    }

    private boolean isTakePawnMove(){
        return false;
    }

    private boolean isQueenPosition(Cell cell) {
        if(cell.getRowIndex() == 0 || cell.getRowIndex() == getBoard().getNbRows() -1){
            return true;
        }
        return false;
    }



}
