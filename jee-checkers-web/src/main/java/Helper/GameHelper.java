package Helper;

import Game.GameCheckersImpl;
import Exception.GameException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Created by Nicolas on 17/01/2017.
 */
public class GameHelper extends HttpServlet {
    private static GameCheckersImpl gameCheckers;
    private static HttpSession session;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        JsonObject parameters = new Gson().fromJson(request.getReader(), JsonObject.class);
        session = request.getSession();
        GameToken gameToken = getTokenFromRequest(parameters);

        switch (gameToken){
            case NEWGAME:
                try {
                    gameCheckers = newGame(parameters);
                    sendResponse(response);
                } catch (GameException e) {
                    e.printStackTrace();
                    sendErrorCode(response, e);
                }
                break;
            case PLAY:
                try {
                    gameCheckers = play(parameters);
                    sendResponse(response);
                } catch (GameException e) {
                    e.printStackTrace();
                    sendErrorCode(response, e);
                }
                break;
            case RESUME:
                try {
                    gameCheckers = resumeGame();
                    sendResponse(response);
                }catch (GameException g){
                    g.printStackTrace();
                    sendErrorCode(response, g);
                }
                break;
        }
    }

    private GameToken getTokenFromRequest(JsonObject parameters) throws IOException {
        GameToken token = GameToken.valueOf(parameters.get("Token").getAsString());
        return token;
    }

    private GameCheckersImpl resumeGame() throws GameException{
        if (getSessionObject() != null) {
            return gameCheckers = getSessionObject();
        }else {
            throw new GameException("Session is empty");
        }
    }

    //TODO : Faire une fonction RESET

    private GameCheckersImpl newGame(JsonObject parameters) throws IOException, GameException {
        String player1 = "Player1";
        String player2 = "Player2";

        if(parameters.get("Player1") != null &&  parameters.get("Player2") != null){
            player1 = parameters.get("Player1").getAsString();
            player2 = parameters.get("Player2").getAsString();
        }

        int xCoordinate = 10;
        int yCoordinate = 10;

        if(!player1.isEmpty() && !player2.isEmpty() && xCoordinate > 0 && yCoordinate > 0) {
            gameCheckers = new GameCheckersImpl(yCoordinate, xCoordinate, player1, player2);
        }
        saveSessionObject();
        return gameCheckers;
    }

    private GameCheckersImpl play(JsonObject parameters) throws IOException, GameException {
        if (getSessionObject() != null){
            gameCheckers = getSessionObject();
            int originRow = parameters.get("originRow").getAsInt();
            int originCol = parameters.get("originCol").getAsInt();
            int destRow = parameters.get("destRow").getAsInt();
            int destCol = parameters.get("destCol").getAsInt();
            gameCheckers.play(originRow, originCol, destRow, destCol);
            saveSessionObject();
            return gameCheckers;
        }else{
            gameCheckers = new GameCheckersImpl(10,10,"Player1", "Player2");
            saveSessionObject();
            return gameCheckers;
        }
    }

    private void saveSessionObject(){
        session.setAttribute("game", gameCheckers);
    }

    private GameCheckersImpl getSessionObject(){
        if (session.getAttribute("game") != null){
            return (GameCheckersImpl) session.getAttribute("game");
        }
        return null;
    }

    private void sendResponse(HttpServletResponse response) throws IOException {
        String json = new Gson().toJson(gameCheckers);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }

    private void sendErrorCode(HttpServletResponse response, GameException e) throws IOException {
        response.sendError(500);
    }
}
