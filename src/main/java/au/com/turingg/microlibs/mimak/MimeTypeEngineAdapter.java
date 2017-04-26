package au.com.turingg.microlibs.mimak;

import java.nio.file.Path;

/**
 * @author Behrang Saeedzadeh
 */
public interface MimeTypeEngineAdapter {

    String detect(Path path) throws MimakException;

}
