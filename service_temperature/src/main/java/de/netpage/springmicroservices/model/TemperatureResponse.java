package de.netpage.springmicroservices.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * A response for a temperature.
 *
 * @author Denis Wirries
 * @version 1.0
 * @since 17.07.16
 */
public class TemperatureResponse implements Serializable {

    private String host;

    private Temperature temperature;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("host", host)
                .append("temperature", temperature)
                .toString();
    }

}
