import Game.GameCheckersImpl;
import Model.Board;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Exception.*;

import static junit.framework.TestCase.fail;
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
    public void selectedCellIsOnTheBoard() throws Exception {
        try {
            game.movePawn(100,100,100,100);
            Assert.fail("Selected cell should be on the board");
        }catch (GameException g){
        }
    }

    @Test
    public void selectedCellContainsPawn() throws Exception {
        try{
            game.movePawn(3,1,2,4);
            Assert.fail("Selected cell does not contains pawn");
        }catch (GameException g){

        }
    }

    @Test
    public void moveOutsideBoardTest() throws Exception {
    }

}
