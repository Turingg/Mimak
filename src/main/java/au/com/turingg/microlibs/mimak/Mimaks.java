package au.com.turingg.microlibs.mimak;

import au.com.turingg.microlibs.mimak.Mimak.SymlinkOptions;
import org.apache.tika.Tika;

/**
 * Factory methods for {@link Mimak}.
 *
 * @author Behrang Saeedzadeh
 */
public final class Mimaks {

    private Mimaks() {
    }

    /**
     * Creates a new Mimak that uses {@link Tika} for MIME-type detection.
     *
     * @param symlinkOptions Do not detect MIME-type of symlinks.
     * @return A new Tika-based Mimak
     */
    public static Mimak getTikaMimak(final SymlinkOptions symlinkOptions) {
        return new DefaultMimak(new TikaMimeDetectorAdapter(new Tika()), symlinkOptions);
    }

}
