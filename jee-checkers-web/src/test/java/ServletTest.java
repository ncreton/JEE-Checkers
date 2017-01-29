/**
 * Created by nicolas on 29/01/2017.
 */

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class ServletTest extends JettyHarness{
    private static final String INDEX_URI = getBaseUri() + "jee-checkers-web";

//    @Test
//    public void itCanGetTheIndexPage() throws Exception {
//        String result = get(INDEX_URI);
//        assertTrue(StringUtils.isNotEmpty(result));
//        assertThat(result).contains("New game");
//    }
}
