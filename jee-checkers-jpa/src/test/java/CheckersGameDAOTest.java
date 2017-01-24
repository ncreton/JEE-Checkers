/**
 * Created by Nicolas on 23/01/2017.
 */
import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;
import javax.jms.Session;
import javax.persistence.EntityManager;

import Model.Color;
import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.GuiceRunner;
import guice.H2DBModule;
import guice.Modules;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GuiceRunner.class)
@Modules({ H2DBModule.class, JPAModule.class })
public class CheckersGameDAOTest {
    @Inject
    EntityManager entityManager;

    @Inject
    GameCheckersDAO checkersDAO;

    @Test
    public void canRetrieveEntityManagerWithGuice() throws Exception {
        Injector injector = Guice.createInjector(new H2DBModule());
        EntityManager em = injector.getInstance(EntityManager.class);
        assertThat(em).isNotNull();
    }

    @Test
    public void isDAOInjected() throws Exception {
        assertThat(checkersDAO).isNotNull();
    }

    @Test
    public void itCanCreateAJPAGame() throws Exception {
        GameCheckersAdapter checkersAdapter = checkersDAO.createNewGame();
        assertThat(checkersAdapter).isNotNull();

        String token = checkersAdapter.getToken();
        assertThat(token).isNotNull();
        entityManager.clear();

        checkersAdapter = checkersDAO.loadFromToken(token);
        assertThat(checkersAdapter).isNotNull();
        entityManager.clear();

    }

    @Test
    public void itCanCreateACustomGame() throws Exception {
        GameCheckersAdapter checkersAdapterCustom = checkersDAO.createNewGame(10,10,"Nicolas", "Baptiste");
        assertThat(checkersAdapterCustom).isNotNull();

        String token = checkersAdapterCustom.getToken();
        assertThat(token).isNotNull();
        entityManager.clear();

        checkersAdapterCustom = checkersDAO.loadFromToken(token);
        assertThat(checkersAdapterCustom).isNotNull();
        entityManager.clear();

    }

    @Test
    public void itCanPlayWithAJPAGame() throws Exception {
        GameCheckersAdapter checkersAdapter = checkersDAO.createNewGame();
        assertThat(checkersAdapter).isNotNull();

        checkersAdapter.play(6,1,5,2);
        String token = checkersAdapter.getToken();

        entityManager.clear();

        checkersAdapter = checkersDAO.loadFromToken(token);

        assertThat(checkersAdapter.getBoard().getCell(5,2).getPawn().getPawnColor()).isEqualTo(Color.WHITE);

        entityManager.clear();
    }
}
