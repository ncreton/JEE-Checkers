package Game;

import Player.Player;

/**
 * Created by Nicolas on 10/01/2017.
 */
public interface GameCheckers {

    void play(Player player, int originRow, int originCol, int destRow, int destCol);
}
