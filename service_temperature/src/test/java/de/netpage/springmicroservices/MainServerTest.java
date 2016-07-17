package de.netpage.springmicroservices;

import de.netpage.springmicroservices.exception.ApplicationException;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Testcases for MainServer.
 *
 * @author Denis Wirries
 * @version 1.0
 * @since 17.07.16
 */
public class MainServerTest {

    @Test
    @Ignore
    public void main() throws Exception {
        MainServer.main(new String[]{"localhost"});
    }

    @Test(expected = ApplicationException.class)
    public void mainMissing() throws Exception {
        MainServer.main(new String[]{});
    }

}