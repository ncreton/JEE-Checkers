package Model;

/**
 * Created by Nicolas on 10/01/2017.
 */
public class NormalPawn extends Pawn {

    public NormalPawn(Color color) {
        super(color);
    }

    @Override
    public void movePawn(Cell toCell) {
        //Normal pawn can only be moved diagonnaly forward, one row at a a time, only il one of the next diagonal cell is free
        //In our game, black pawn are at the top of the board
        //White pawn are at the bottom
    }
}
