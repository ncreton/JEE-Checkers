package Helper;

import Game.GameCheckersImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nicolas on 17/01/2017.
 */
public class GameHelper extends HttpServlet {
    private static GameCheckersImpl gameCheckers;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if (request.getSession().getAttribute("game") == null){
            String player1 = request.getParameter("Player1");
            String player2 = request.getParameter("Player2");
            int xCoordinate = Integer.parseInt(request.getParameter("xCoordinate"));
            int yCoordinate = Integer.parseInt(request.getParameter("yCoordinate"));

            if(!player1.isEmpty() && !player2.isEmpty() && xCoordinate > 0 && yCoordinate > 0){
                gameCheckers = new GameCheckersImpl(yCoordinate,xCoordinate,player1, player2);
            }
            else {
                gameCheckers = new GameCheckersImpl(10,10,"Player1", "Player2");
            }
            request.setAttribute("gameConfiguration", gameCheckers);
        }
        this.getServletContext().getRequestDispatcher( "/views/game.jsp" ).forward( request, response );

    }
}
