package Game;

import Model.Cell;
import Model.Color;
import Model.Pawn;

/**
 * Created by Nicolas on 10/01/2017.
 */
public interface GameCheckers {

    void play(Pawn pawn, int row, int column);
}
