package de.netpage.springmicroservices.exception;

/**
 * Generic Exception.
 *
 * @author Denis Wirries
 * @version 1.0
 * @since 17.07.16
 */
public class ApplicationException extends RuntimeException {

    public ApplicationException(String message) {
        super(message);
    }

}
