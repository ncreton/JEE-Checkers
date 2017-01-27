package Player;

import Model.Color;

/**
 * Created by nicolas on 13/01/2017.
 */
public class Player {
    private String name;
    private Color colorPlayer;
    private int nbPawns;
    private boolean isWinner;

    public Player(String name, Color colorPlayer, int nbPawns) {
        this.name = name;
        this.colorPlayer = colorPlayer;
        this.nbPawns = nbPawns;
        this.isWinner = false;
    }

    public String getName() {
        return name;
    }

    public Color getColorPlayer() {
        return colorPlayer;
    }

    public int getNbPawns() {
        return nbPawns;
    }

    public void loosePoint() {
        this.nbPawns--;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }
}
