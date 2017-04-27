package au.com.turingg.microlibs.mimak;

import org.apache.tika.Tika;

/**
 * Factory methods for {@link Mimak}.
 *
 * @author Behrang Saeedzadeh
 */
public class Mimaks {

    /**
     * Creates a new Mimak that uses {@link Tika} for MIME-type detection.
     *
     * @param ignoreSymlinks Do not detect MIME-type of symlinks.
     * @return A new Tika-based Mimak
     */
    public Mimak getTikaMimak(final boolean ignoreSymlinks) {
        return new DefaultMimak(new TikaMimeDetectorAdapter(new Tika()), ignoreSymlinks);
    }

}
