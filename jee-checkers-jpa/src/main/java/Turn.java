/**
 * Created by nicolas on 23/01/2017.
 */

import Model.Color;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Turn {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private int row;
    private int col;
    private Color color;

    @ManyToOne
    private GameCheckersJPA checkersJPA;

    public Turn() {
    }

    public Turn(GameCheckersJPA checkersJPA, int row, int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.checkersJPA = checkersJPA;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Color getColor() {
        return color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
