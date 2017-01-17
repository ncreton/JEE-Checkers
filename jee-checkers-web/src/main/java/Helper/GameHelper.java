package Helper;

import Game.GameCheckersImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nicolas on 17/01/2017.
 */
public class GameHelper {
    private static GameCheckersImpl gameChecker;

    public static GameCheckersImpl getGame(HttpServletRequest request){
        if (request.getSession().getAttribute("game") == null){
            return gameChecker = new GameCheckersImpl(10,10,"Nicolas", "Baptiste");
        }else {
            return gameChecker;
        }
    }

    public static String getDrawingGame(HttpServletRequest request){
        if (gameChecker != null){
            return gameChecker.toString();
        }else{
            return "Pas de jeu en cours";
        }
    }
}
