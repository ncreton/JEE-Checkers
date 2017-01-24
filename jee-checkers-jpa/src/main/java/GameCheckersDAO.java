import org.apache.commons.lang.RandomStringUtils;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import Exception.*;

/**
 * Created by nicolas on 23/01/2017.
 */
public class GameCheckersDAO {

    @Inject
    EntityManager entityManager;

    @Inject
    UserTransaction userTransaction;

    public GameCheckersAdapter createNewGame() throws GameException {
        GameCheckersJPA checkersJPA = new GameCheckersJPA();
        checkersJPA.setToken(RandomStringUtils.randomAlphanumeric(10).toLowerCase());
        saveGame(checkersJPA);

        return new GameCheckersAdapter(this, checkersJPA);
    }

    public GameCheckersAdapter loadFromToken(String token) throws GameException {
        GameCheckersJPA checkersJPA = (GameCheckersJPA) entityManager
                .createQuery("SELECT g FROM Game g WHERE g.token = :token")
                .setParameter("token", token)
                .getSingleResult();

        return new GameCheckersAdapter(this, checkersJPA);
    }

    public void saveGame(GameCheckersJPA checkersJPA){
        try {
            userTransaction.begin();
            entityManager.persist(checkersJPA);
            userTransaction.commit();
        }catch (NotSupportedException | SystemException | SecurityException
                | IllegalStateException | RollbackException
                | HeuristicMixedException | HeuristicRollbackException e){
            e.printStackTrace();
        }
    }
}
