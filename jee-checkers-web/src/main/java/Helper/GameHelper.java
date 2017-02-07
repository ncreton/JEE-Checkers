package Helper;

import Game.GameCheckersImpl;
import Exception.GameException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Created by Nicolas on 17/01/2017.
 */
@WebServlet(name = "GameHelper",urlPatterns = "/GameHelper")
public class GameHelper extends HttpServlet {

    @Inject
    GameCheckersBean checkersBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpServletRequest request = req;
        String token =  req.getParameter("token");
        //resp.sendRedirect(req.getContextPath());
        if (token != null){
            try {
                checkersBean.loadFromToken(token);
                String json = new Gson().toJson(checkersBean.getCheckersAdapter().getGameCheckersCore());
                request.setAttribute("jsonString", json);
                //sendResponse(resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        req.getRequestDispatcher("views/game.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        JsonObject parameters = new Gson().fromJson(request.getReader(), JsonObject.class);
        GameToken gameToken = getTokenFromRequest(parameters);
        String tokenResume = getTokenResume(parameters);

        if (tokenResume != null){
            try {
                checkersBean.loadFromToken(tokenResume);
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }

        switch (gameToken){
            case NEWGAME:
                try {
                    newGame(parameters);
                    sendResponse(response);
                } catch (GameException gameException) {
                    gameException.printStackTrace();
                }
                break;
            case PLAY:
                try {
                    play(parameters);
                    sendResponse(response);
                } catch (GameException e) {
                    e.printStackTrace();
                    sendErrorCode(response, e);
                }
                break;
            case RESUME:
                sendResponse(response);
                break;
            case RESET:
                try{
                    resetGame(tokenResume);
                } catch (GameException e) {
                    e.printStackTrace();
                    sendErrorCode(response, e);
                }
        }
    }

    private GameToken getTokenFromRequest(JsonObject parameters) throws IOException {
        GameToken token = GameToken.valueOf(parameters.get("Token").getAsString());
        return token;
    }

    private String getTokenResume(JsonObject parameters){
        try {
            String tokenResume = parameters.get("GameId").getAsString();
            return tokenResume;
        }catch (NullPointerException n){
            return null;
        }
    }

    private void resetGame(String token) throws GameException {
        //checkersBean.deleteFromToken(token);
    }

    private void newGame(JsonObject parameters) throws IOException, GameException {
        String player1 = "Player1";
        String player2 = "Player2";

        if(parameters.get("Player1") != null &&  parameters.get("Player2") != null){
            player1 = parameters.get("Player1").getAsString();
            player2 = parameters.get("Player2").getAsString();
        }

        int xCoordinate = 10;
        int yCoordinate = 10;

        if(!player1.isEmpty() && !player2.isEmpty() && xCoordinate > 0 && yCoordinate > 0) {
            checkersBean.createNewGame(yCoordinate, xCoordinate, player1, player2);
        }
    }

    private void play(JsonObject parameters) throws IOException, GameException {
        int originRow = parameters.get("originRow").getAsInt();
        int originCol = parameters.get("originCol").getAsInt();
        int destRow = parameters.get("destRow").getAsInt();
        int destCol = parameters.get("destCol").getAsInt();
        checkersBean.play(originRow, originCol, destRow, destCol);
    }

    private void sendResponse(HttpServletResponse response) throws IOException {
        try {
            String json = new Gson().toJson(checkersBean.getCheckersAdapter().getGameCheckersCore());
            response.setContentType("application/json");
            response.getWriter().write(json);
        }catch (NullPointerException n){

        }
    }

    private void sendErrorCode(HttpServletResponse response, GameException e) throws IOException {
        response.sendError(500);
    }
}
