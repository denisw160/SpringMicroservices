package de.netpage.springmicroservices.controller;

import de.netpage.springmicroservices.model.Temperature;
import de.netpage.springmicroservices.model.TemperatureResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test-cases for {@link TemperatureController}.
 *
 * @author Denis Wirries
 * @version 1.0
 * @since 17.07.16
 */
public class TemperatureControllerTest {

    @Test
    public void temperature() throws Exception {
        TemperatureController controller = new TemperatureController();
        assertNotNull(controller);

        final TemperatureResponse temperature = controller.temperature();
        assertNotNull(temperature);
        assertNotNull(temperature.getHost());

        Temperature t = temperature.getTemperature();
        assertNotNull(t);

        assertNotNull(t.getValue());
        assertEquals(51.0, t.getValue(), 0);

        assertNotNull(t.getUnit());
        assertEquals("C", t.getUnit());
    }

}