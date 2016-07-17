package de.netpage.springmicroservices.controller;

import de.netpage.springmicroservices.model.Temperature;
import de.netpage.springmicroservices.model.TemperatureResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

/**
 * A RESTFul controller for query current temperature.
 *
 * @author Denis Wirries
 * @version 1.0
 * @since 17.07.16
 */
@RestController
public class TemperatureController {

    private static final Logger LOG = Logger.getLogger(TemperatureController.class.getName());

    private static final String COMMAND = "/usr/bin/vcgencmd";

    /**
     * Returns the temperature on the current host.
     *
     * @return Temperature
     */
    @RequestMapping("/temperature")
    public TemperatureResponse temperature() {
        LOG.info("Reading temperature");
        TemperatureResponse response = new TemperatureResponse();
        response.setHost(getHostname());
        response.setTemperature(getTemperature());
        return response;
    }

    private String getHostname() {
        String hostname = "Unknown";
        try {
            InetAddress address = InetAddress.getLocalHost();
            hostname = address.getHostName();
        } catch (UnknownHostException ex) {
            LOG.warning("Error while resolving hostname: " + ex.getMessage());
        }
        return hostname;
    }

    private Temperature getTemperature() {
        Temperature t = new Temperature();

        if (!existsCommand()) {
            parseTemperature(t, "51.0'C"); // Sample Value, if command not exists
        } else {
            try {
                readTemperatureFromCommand(t);
            } catch (Exception ex) {
                LOG.warning("Error while reading temperature: " + ex.getMessage());
            }
        }

        return t;
    }

    private void readTemperatureFromCommand(Temperature t) throws Exception {
        String temp = null;
        Runtime rt = Runtime.getRuntime();
        String[] command = {COMMAND, "measure_temp"};
        Process process = rt.exec(command);

        BufferedReader stdOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        LOG.info("Standard-Output is");
        String s;
        while ((s = stdOutput.readLine()) != null) {
            temp = s;
            LOG.info(s);
        }

        LOG.info("Error-Output is");
        while ((s = stdError.readLine()) != null) {
            LOG.warning(s);
        }

        parseTemperature(t, temp);
    }

    private void parseTemperature(Temperature t, String temp) {
        final String[] split = StringUtils.split(temp, "'");
        t.setValue(Double.valueOf(split[0]));
        t.setUnit(split[1]);
    }

    private boolean existsCommand() {
        File f = new File(COMMAND);
        return f.exists();
    }

}
