package au.com.turingg.microlibs.mimak;

import java.nio.file.Path;

/**
 * An adapter for MIME detectors. Allows various MIME type detectors to be used
 * with Mimak.
 *
 * @author Behrang Saeedzadeh
 */
public interface MimeDetectorAdapter {

    /**
     * Returns the MIME type for the given file.
     *
     * @param file A non-null file
     * @return MIME type of the given file
     * @throws MimakException If an error occurs and cannot detect the MIME type for the file
     */
    String detect(Path file) throws MimakException;

}
