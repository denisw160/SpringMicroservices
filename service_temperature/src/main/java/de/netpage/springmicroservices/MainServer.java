package de.netpage.springmicroservices;

import de.netpage.springmicroservices.configuration.TempertureConfiguration;
import de.netpage.springmicroservices.exception.ApplicationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * Runs a micro-service for query the current temperature on the host.
 * The micro-service registering with the discovery server (Eureka).
 *
 * @author Denis Wirries
 * @version 1.0
 * @since 17.07.16
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(TempertureConfiguration.class)
public class MainServer {

    /**
     * Run the application using Spring Boot and starts the micro-service.
     *
     * @param args Program arguments - 1. parameter is the hostname for eureka server
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java -jar ... <eureka-server-name>");
            throw new ApplicationException("missing server name");
        }

        String servername = args[0];
        System.setProperty("eureka.client.serviceUrl.defaultZone", "http://" + servername + ":1111/eureka");
        SpringApplication.run(MainServer.class, args);
    }

}
