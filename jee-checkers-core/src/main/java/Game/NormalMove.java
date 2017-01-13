package Game;

import Exception.GameException;
import Model.Board;
import Model.Cell;

/**
 * Created by nicolas on 13/01/2017.
 */
public class NormalMove extends Move {

    public NormalMove(Board board) {
        super(board);
    }

    public Board move(Cell originCell, Cell destCell) throws GameException {
        if (isSimpleMove(originCell, destCell)) {
            takePawnDuringMove(originCell, destCell);
            board.swapPawn(originCell, destCell);
            changePawnToQueen(destCell.getRowIndex(), destCell.getColIndex());
            return board;
        } else {
            //TODO check double move
            takePawnDuringMove(originCell, destCell);
            board.swapPawn(originCell, destCell);
            changePawnToQueen(destCell.getRowIndex(), destCell.getColIndex());
            return board;
        }
        //throw new GameException("Problem moving normal pawn");
    }
}
