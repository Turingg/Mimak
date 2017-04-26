package au.com.turingg.microlibs.mimak;

import java.io.IOException;

/**
 * Root class for all Mimak exceptions.
 *
 * @author Behrang Saeedzadeh
 */
public class MimakException extends IOException {

    public MimakException() {
    }

    public MimakException(String message) {
        super(message);
    }

    public MimakException(String message, Throwable cause) {
        super(message, cause);
    }

    public MimakException(Throwable cause) {
        super(cause);
    }

}
