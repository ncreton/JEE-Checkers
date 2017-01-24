import Model.Color;

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
}
