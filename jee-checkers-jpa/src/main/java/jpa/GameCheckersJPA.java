package jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolas on 23/01/2017.
 */

@Entity(name="Game")
public class GameCheckersJPA {
    private String token;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy="checkersJPA", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @OrderColumn(name="index")
    private List<Turn> turns = new ArrayList<>();

    private String player1Name;

    private String player2Name;
    private int rowSize;

    private int colSize;
    public GameCheckersJPA() {
        this(10,10,"Player 1","Player 2");
    }

    public GameCheckersJPA(int rowSize, int colSize, String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.rowSize = rowSize;
        this.colSize = colSize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public int getRowSize() {
        return rowSize;
    }

    public int getColSize() {
        return colSize;
    }

    public List<Turn> getTurns() {
        return turns;
    }
}
