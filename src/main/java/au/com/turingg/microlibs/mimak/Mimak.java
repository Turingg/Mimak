package au.com.turingg.microlibs.mimak;

import java.io.File;
import java.nio.file.Path;

/**
 * @author Behrang Saeedzadeh
 */
public interface Mimak {

    String detect(Path file) throws MimakException;

    String detect(File file) throws MimakException;

    String detect(String file) throws MimakException;
}
