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

    /**
     * Method to move the queen
     *
     * @param originCell
     * @param destCell
     * @throws GameException
     */
    public void move(Cell originCell, Cell destCell) throws GameException {

        int originRow = originCell.getRowIndex();
        int originCol = originCell.getColIndex();
        int destRow = destCell.getRowIndex();
        int destCol = destCell.getColIndex();

        if (isMoveAuthorized(originCell, destCell)) {
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

    @Override
    public boolean isMoveAuthorized(Cell originCell, Cell destCell) throws GameException {
        //TODO place the code to check if the queen go only in diagonal
        return true;
    }
}
