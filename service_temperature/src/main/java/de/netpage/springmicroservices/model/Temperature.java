package de.netpage.springmicroservices.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Model for a temperature value.
 *
 * @author Denis Wirries
 * @version 1.0
 * @since 17.07.16
 */
public class Temperature implements Serializable {

    private double value;

    private String unit;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("value", value)
                .append("unit", unit)
                .toString();
    }

}
