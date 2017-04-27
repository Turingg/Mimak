package au.com.turingg.microlibs.mimak;

import org.apache.tika.Tika;

import java.io.IOException;
import java.nio.file.Path;

/**
 * An adapter for the Apache Tika content analysis toolkit.
 *
 * @author Behrang Saeedzadeh
 * @see <a href="https://en.wikipedia.org/wiki/Adapter_pattern">Adapter pattern</a>
 * @see <a href="https://tika.apache.org/">Apache Tika</a>
 */
public class TikaMimeDetectorAdapter implements MimeDetectorAdapter {

    private final Tika tika;

    public TikaMimeDetectorAdapter(final Tika tika) {
        if (tika == null) {
            throw new IllegalArgumentException("tika should not be null");
        }

        this.tika = tika;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String detect(Path file) throws MimakException {
        try {
            return tika.detect(file);
        } catch (IOException ex) {
            throw new MimakException(ex);
        }
    }
}
