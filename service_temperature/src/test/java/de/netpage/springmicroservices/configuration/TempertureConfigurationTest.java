package de.netpage.springmicroservices.configuration;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Testcases for TempertureConfiguration.
 *
 * @author Denis Wirries
 * @version 1.0
 * @since 17.07.16
 */
public class TempertureConfigurationTest {

    @Test
    public void testCreate() throws Exception {
        TempertureConfiguration configuration = new TempertureConfiguration();
        assertNotNull(configuration);
    }

}