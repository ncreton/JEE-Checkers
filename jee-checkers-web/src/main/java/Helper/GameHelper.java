package Helper;

import Game.GameCheckersImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        if (request.getSession().getAttribute("game") == null){
            JsonObject json = new Gson().fromJson(request.getReader(), JsonObject.class);
//            String player1 = request.getParameter("Player1");
//            String player2 = request.getParameter("Player2");
//            int xCoordinate = Integer.parseInt(request.getParameter("xCoordinate"));
//            int yCoordinate = Integer.parseInt(request.getParameter("yCoordinate"));
            String player1 = json.get("Player1").getAsString();
            String player2 = json.get("Player2").getAsString();
            int xCoordinate = json.get("xCoordinate").getAsInt();
            int yCoordinate = json.get("yCoordinate").getAsInt();

            if(!player1.isEmpty() && !player2.isEmpty() && xCoordinate > 0 && yCoordinate > 0){
                gameCheckers = new GameCheckersImpl(yCoordinate,xCoordinate,player1, player2);
            }
            else {
                gameCheckers = new GameCheckersImpl(10,10,"Player1", "Player2");
            }
            //request.setAttribute("gameConfiguration", gameCheckers);
        }
        //this.getServletContext().getRequestDispatcher( "/views/game.jsp" ).forward( request, response );
        String json = new Gson().toJson(gameCheckers);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}
