package au.com.turingg.microlibs.mimak;

import java.io.File;
import java.nio.file.Path;

/**
 * Minimalistic interface for file MIME type detectors.
 *
 * @author Behrang Saeedzadeh
 */
public interface Mimak {

    /**
     * Returns the MIME type for the given file.
     *
     * @param file A non-null file
     * @return MIME type of the given file
     * @throws MimakException If an error occurs and cannot detect the MIME type for the file
     */
    String detect(Path file) throws MimakException;

    /**
     * Returns the MIME type for the given file.
     *
     * @param file A non-null file
     * @return MIME type of the given file
     * @throws MimakException If an error occurs and cannot detect the MIME type for the file
     */
    String detect(File file) throws MimakException;

    /**
     * Returns the MIME type for the given file.
     *
     * @param file A non-null file
     * @return MIME type of the given file
     * @throws MimakException If an error occurs and cannot detect the MIME type for the file
     */
    String detect(String file) throws MimakException;
}
