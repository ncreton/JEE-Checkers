import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

/**
 * Created by nicolas on 23/01/2017.
 */
public class GameCheckersDAO {
    @Inject
    EntityManager entityManager;

    @Inject
    UserTransaction userTransaction;
}
