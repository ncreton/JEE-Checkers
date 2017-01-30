package jpa; /**
 * Created by nicolas on 23/01/2017.
 */

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

    @ManyToOne
    private GameCheckersJPA checkersJPA;

    private int originRow;
    private int originCol;
    private int destRow;
    private int destCol;

    public Turn() {
    }

    public Turn(GameCheckersJPA checkersJPA, int originRow, int originCol, int destRow, int destCol) {
        this.checkersJPA = checkersJPA;
        this.originRow = originRow;
        this.originCol = originCol;
        this.destRow = destRow;
        this.destCol = destCol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOriginRow() {
        return originRow;
    }

    public int getOriginCol() {
        return originCol;
    }

    public int getDestRow() {
        return destRow;
    }

    public int getDestCol() {
        return destCol;
    }
}
