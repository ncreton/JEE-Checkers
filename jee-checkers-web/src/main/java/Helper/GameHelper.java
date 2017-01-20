package Helper;

import Game.GameCheckers;
import Game.GameCheckersImpl;
import Exception.GameException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

import Game.Main;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Created by Nicolas on 17/01/2017.
 */
public class GameHelper extends HttpServlet {
    private static GameCheckersImpl gameCheckers;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        JsonObject parameters = new Gson().fromJson(request.getReader(), JsonObject.class);
        GameCheckersImpl session = (GameCheckersImpl) request.getSession().getAttribute("game");
        GameToken gameToken = getTokenFromRequest(parameters);

        switch (gameToken){
            case NEWGAME:
                gameCheckers = newGame(parameters, session);
                break;
            case PLAY:
                try {
                    gameCheckers = play(parameters, session);
                } catch (GameException e) {
                    e.printStackTrace();
                }
                break;
        }

        String json = new Gson().toJson(gameCheckers);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }

    private GameToken getTokenFromRequest(JsonObject parameters) throws IOException {
        GameToken token = GameToken.valueOf(parameters.get("Token").getAsString());
        return token;
    }

    private GameCheckersImpl newGame(JsonObject parameters, GameCheckersImpl session) throws IOException {
        if (session == null){
            String player1 = parameters.get("Player1").getAsString();
            String player2 = parameters.get("Player2").getAsString();
            int xCoordinate = parameters.get("xCoordinate").getAsInt();
            int yCoordinate = parameters.get("yCoordinate").getAsInt();

            if(!player1.isEmpty() && !player2.isEmpty() && xCoordinate > 0 && yCoordinate > 0){
                return gameCheckers = new GameCheckersImpl(yCoordinate,xCoordinate,player1, player2);
            }
            else {
                return gameCheckers = new GameCheckersImpl(10,10,"Player1", "Player2");
            }
        }else{
            return session;
        }
    }

    private GameCheckersImpl play(JsonObject parameters, GameCheckersImpl session) throws IOException, GameException {
        if (session != null){
            int originRow = parameters.get("originRow").getAsInt();
            int originCol = parameters.get("originCol").getAsInt();
            int destRow = parameters.get("destRow").getAsInt();
            int destCol = parameters.get("destCol").getAsInt();

            gameCheckers.play(originRow, originCol, destRow, destCol);

            return gameCheckers;
        }else{
            return new GameCheckersImpl(10,10,"Player1", "Player2");
        }
    }
}
