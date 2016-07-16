package de.netpage.springmicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * All you need to run a Eureka registration server.
 *
 * @author Denis Wirries
 * @version 1.0
 * @since 16.07.16
 */
@SpringBootApplication
@EnableEurekaServer
public class MainServer {

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     *
     * @param args Program arguments - ignored.
     */
    public static void main(String[] args) {
        SpringApplication.run(MainServer.class, args);
    }

}
