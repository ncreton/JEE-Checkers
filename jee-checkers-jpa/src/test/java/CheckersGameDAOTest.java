/**
 * Created by Nicolas on 23/01/2017.
 */
import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;
import javax.persistence.EntityManager;

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
}
