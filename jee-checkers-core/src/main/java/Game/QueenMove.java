package Game;

import Exception.GameException;
import Model.Board;
import Model.Cell;
import Model.QueenDirection;

/**
 * Created by nicolas on 13/01/2017.
 */
public class QueenMove extends Move {

    public QueenMove(Board board) {
        super(board);
    }

    //NOT FINISHED (finish isDiagonalMove)!! (Because you can't no only move in diagonal and we have to)
    public void move(Cell originCell, Cell destCell) throws GameException {

        int originRow = originCell.getRowIndex();
        int originCol = originCell.getColIndex();
        int destRow = destCell.getRowIndex();
        int destCol = destCell.getColIndex();

        //Down to Up in diagonal
        if (destRow < originRow && destCol > originCol || destRow > originRow && destCol < originCol) {
            if (isOtherTeamPawns(originCell, destCell, QueenDirection.RIGHT_DIAGONAL)) {
                //Remove opponents pawns
                removeRangePawns(originCell, destCell, QueenDirection.RIGHT_DIAGONAL);
                board.swapPawn(originCell, destCell);
            }
        } else if (destRow < originRow && destCol < originCol || destRow > originRow && destCol > originCol) {
            if (isOtherTeamPawns(originCell, destCell, QueenDirection.LEFT_DIAGONAL)) {
                //Remove opponents pawns
                removeRangePawns(originCell, destCell, QueenDirection.LEFT_DIAGONAL);
                board.swapPawn(originCell, destCell);
            }
        } else {
            throw new GameException("Problem moving the queen");
        }
    }
}
