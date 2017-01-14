import Exception.GameException;
import Game.GameCheckersImpl;
import Model.Color;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by nicolas on 12/01/2017.
 */
public class GameCheckersTest {

    private GameCheckersImpl game;

    @Before
    public void setUp() throws Exception {
        this.game = new GameCheckersImpl();
    }

    @Test
    /**
     * Test if the selected is on the board
     */
    public void selectedCellIsOnTheBoard() throws GameException {
        try {
            game.play(100, 100, 100, 100);
            Assert.fail("Selected cell should be on the board");
        }catch (GameException g){
        }
    }

    @Test
    /**
     * Test if the selected cell contains a pawn
     */
    public void selectedCellContainsPawn() throws GameException {
        try{
            game.play(3, 1, 2, 4);
            Assert.fail("Selected cell does not contains pawn");
        }catch (GameException g){

        }
    }

    @Test
    /**
     * Test if the played move is outside the board
     */
    public void moveOutsideBoardTest() throws Exception {
        try {
            game.movePawn(3, 0, -1, 4);
            Assert.fail("Pawn can not be moved outside the board");
        } catch (ArrayIndexOutOfBoundsException g) {
        } catch (GameException e) {
        }
    }

    @Test
    public void normalMoveTest() throws Exception {
        //Normal move black pawn down
        game.movePawn(3, 0, 4, 1);
        assertThat(game.getBoard().getCell(4, 1).hasPawn());
        assertThat(game.getBoard().getCell(4, 1).getPawn().getPawnColor()).isEqualTo(Color.BLACK);

        //Normal move white pawn up
        game.movePawn(6, 1, 5, 2);
        assertThat(game.getBoard().getCell(5, 2).hasPawn());
        assertThat(game.getBoard().getCell(5, 2).getPawn().getPawnColor()).isEqualTo(Color.WHITE);
    }
}
