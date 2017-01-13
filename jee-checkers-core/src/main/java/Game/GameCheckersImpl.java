package Game;

import Model.*;
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

    public void movePawn(int originRow, int originCol, int destRow, int destCol) throws GameException {
        Cell originCell = null;
        Cell destCell = null;

        //Check if the pawn is not outside the board
        if (board.isCoordinateInTheBoard(originRow, originCol) && board.isCoordinateInTheBoard(destRow, destCol)){
            originCell = board.getCell(originRow, originCol);
            destCell = board.getCell(destRow, destCol);
        }else {
            throw new GameException("Coordinate are out of the board");
        }

        //Check if the selected cell contains pawn and try to move
        if (originCell.hasPawn()){
            Pawn currentPawn = originCell.getPawn();
            if(!destCell.hasPawn() && !isValidMovePawn(currentPawn, originCell, destCell, originRow, originCol, destRow, destCol)){
                throw new GameException("Not a valid move");
            }
            pawnToQueen(destRow, destCol);
        }
        else{
            throw new GameException("Cell does not contains pawn");
        }
    }

    //Determine if the move for the specific given pawn is correct (normal pawn/queen, destination cell and direction)
    private boolean isValidMovePawn(Pawn currentPawn, Cell originCell, Cell destCell, int originRow, int originCol, int destRow, int destCol) {
        if(isQueenMove(currentPawn, originRow, originCol, destRow, destCol)) {
            originCell.setPawn(null);
            destCell.setPawn(currentPawn);
            return true;
        }

        if(isSimpleMove(currentPawn.getPawnColor(), originRow, originCol, destRow, destCol)){
            originCell.setPawn(null);
            destCell.setPawn(currentPawn);
            return true;
        }

        if(isPawnTakenMove(currentPawn.getPawnColor(), originRow, originCol, destRow, destCol)) {
            originCell.setPawn(null);
            destCell.setPawn(currentPawn);
            return true;
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

    private boolean isPawnTakenMove(Color color, int originRow, int originCol, int destRow, int destCol){
        if(color == Color.BLACK && destRow == originRow + 2 && destCol == originCol - 2) {
            Cell intermediateCell = board.getCell(originRow + 1,originCol - 1);
            if(intermediateCell.getPawn().getPawnColor() == Color.WHITE) {
                intermediateCell.setPawn(null);
                return true;
            }
        }

        if(color == Color.BLACK && destRow == originRow + 2 && destCol == originCol + 2) {
            Cell intermediateCell = board.getCell(originRow + 1,originCol + 1);
            if(intermediateCell.getPawn().getPawnColor() == Color.WHITE) {
                intermediateCell.setPawn(null);
                return true;
            }
        }

        if(color == Color.WHITE && destRow == originRow - 2 && destCol == originCol - 2){
            Cell intermediateCell = board.getCell(originRow - 1,originCol -1);
            //Opponent pawn
            if(intermediateCell.getPawn().getPawnColor() == Color.BLACK) {
                intermediateCell.setPawn(null);
                return true;
            }
        }

        if(color == Color.WHITE && destRow == originRow - 2 && destCol == originCol + 2) {
            Cell intermediateCell = board.getCell(originRow - 1,originCol + 1);
            if(intermediateCell.getPawn().getPawnColor() == Color.BLACK) {
                intermediateCell.setPawn(null);
                return true;
            }
        }
        return false;
    }

    //NOT FINISH (finish isDiagonalMove)!! (Because you can't no only move in diagonal and we have to)
    // Check if it's a queen move
    private boolean isQueenMove(Pawn pawn, int originRow, int originCol, int destRow, int destCol) {
        if(pawn.getPawnType() == PawnType.QUEEN) {
            //Down to Up in diagonal
            if(destRow < originRow && destCol > originCol || destRow > originRow && destCol < originCol){
                if(isOtherTeamPawns(pawn, originRow, destRow, originCol, QueenDirection.RIGHT_DIAGONAL)){
                    //Remove opponents pawns
                    removeRangePawns(originRow, destRow, originCol, QueenDirection.RIGHT_DIAGONAL);
                    return true;
                }
            }

            if(destRow < originRow && destCol < originCol || destRow > originRow && destCol > originCol){
                if(isOtherTeamPawns(pawn, originRow, destRow, originCol, QueenDirection.LEFT_DIAGONAL)){
                    //Remove opponents pawns
                    removeRangePawns(originRow, destRow, originCol, QueenDirection.LEFT_DIAGONAL);
                    return true;
                }
            }
        }
        return false;
    }

    //Check if the move is only in diagonal
    private boolean isDiagonalMove(int originRow, int originCol, int destRow, int destCol){
        //4 cases
        return false;
    }

    //Check if the pawns in the queen's direction are opponent pawns or in my team
    private boolean isOtherTeamPawns(Pawn pawn, int originRow,int destRow, int originCol, QueenDirection queenDirection){
        //Up diagonal right
        if(queenDirection == QueenDirection.RIGHT_DIAGONAL && destRow < originRow){
            for(int row = originRow - 1; row <= destRow; row--){
                if(board.getCell(row, originCol - 1).hasPawn() && board.getCell(row, originCol + 1).getPawn().getPawnColor() == pawn.getPawnColor()) {
                    return false;
                }
            }
        }
        //Down diagonal right
        if(queenDirection == QueenDirection.RIGHT_DIAGONAL && destRow > originRow) {
            for(int row = originRow + 1; row <= destRow; row++){
                if(board.getCell(row, originCol - 1).hasPawn() && board.getCell(row, originCol - 1).getPawn().getPawnColor() == pawn.getPawnColor()) {
                    return false;
                }
            }
        }
        //Up diagonal left
        if(queenDirection == QueenDirection.LEFT_DIAGONAL && destRow < originRow){
            for(int row = originRow - 1; row <= destRow; row--){
                if(board.getCell(row, originCol - 1).hasPawn() && board.getCell(row, originCol - 1).getPawn().getPawnColor() == pawn.getPawnColor()) {
                    return false;
                }
            }
        }
        //Down diagonal left
        if(queenDirection == QueenDirection.LEFT_DIAGONAL && destRow > originRow) {
            for(int row = originRow + 1; row <= destRow; row++){
                if(board.getCell(row, originCol + 1).hasPawn() && board.getCell(row, originCol + 1).getPawn().getPawnColor() == pawn.getPawnColor()) {
                    return false;
                }
            }
        }
        return true;
    }

    //Remove pawns between origin and queen destination so on diagonal(if only opponents pawns)
    private void removeRangePawns(int originRow, int destRow, int originCol, QueenDirection queenDirection){
        int col = originCol;
        //Up diagonal right
        if(queenDirection == QueenDirection.RIGHT_DIAGONAL && destRow < originRow){
            for(int row = originRow - 1; row <= destRow; row--){
                col = col +1;
                if(board.getCell(row, col).hasPawn()){
                    board.getCell(row, col).setPawn(null);
                }
            }
        }
        //Down diagonal right
        if(queenDirection == QueenDirection.RIGHT_DIAGONAL && destRow > originRow) {
            for(int row = originRow + 1; row <= destRow; row++) {
                col = col -1;
                if (board.getCell(row, col).hasPawn()) {
                    board.getCell(row, col).setPawn(null);
                }
            }
        }
        //Up diagonal left
        if(queenDirection == QueenDirection.LEFT_DIAGONAL && destRow < originRow){
            for(int row = originRow - 1; row <= destRow; row--){
                col = col -1;
                if(board.getCell(row, col).hasPawn()){
                    board.getCell(row, col).setPawn(null);
                }
            }
        }
        //Down diagonal left
        if(queenDirection == QueenDirection.LEFT_DIAGONAL && destRow > originRow) {
            for(int row = originRow + 1; row <= destRow; row++){
                col = col +1;
                if(board.getCell(row, col).hasPawn()){
                    board.getCell(row, col).setPawn(null);
                }
            }
        }

    }

    //Transform a pawn in queen
    private void pawnToQueen(int row, int col){
        if(row == 0 || row == board.getNbRows() - 1){
            board.getCell(row, col).getPawn().setPawnType(PawnType.QUEEN);
        }
    }


}
