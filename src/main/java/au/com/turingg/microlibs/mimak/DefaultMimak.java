package au.com.turingg.microlibs.mimak;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Default implementation for {@link Mimak}.
 *
 * @author Behrang Saeedzadeh
 */
public class DefaultMimak implements Mimak {

    private final MimeDetectorAdapter mimeTypeEngine;

    private final boolean ignoreSymlinks;

    public DefaultMimak(final MimeDetectorAdapter mimeTypeEngine, final boolean ignoreSymlinks) {
        if (mimeTypeEngine == null) {
            throw new IllegalArgumentException("mimeTypeEngine should not be null");
        }

        this.mimeTypeEngine = mimeTypeEngine;
        this.ignoreSymlinks = ignoreSymlinks;
    }

    @Override
    public String detect(final Path file) throws MimakException {
        if (file == null) {
            throw new IllegalArgumentException("file should not be null");
        }

        final BasicFileAttributes attrs = readAttributes(file);
        if (attrs.isDirectory() || attrs.isOther() || (ignoreSymlinks && attrs.isSymbolicLink())) {
            throw new MimakException(String.format("illegal file type: %s", fileTypeSummary(attrs)));
        }

        try {
            return mimeTypeEngine.detect(file);
        } catch (IOException e) {
            throw new MimakException(e);
        }
    }

    @Override
    public String detect(File file) throws MimakException {
        return detect(file.toPath());
    }

    @Override
    public String detect(String file) throws MimakException {
        return detect(Paths.get(file));
    }

    private BasicFileAttributes readAttributes(final Path file) throws MimakException {
        try {
            return Files.readAttributes(file, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        } catch (IOException e) {
            throw new MimakException(e);
        }
    }

    private String fileTypeSummary(final BasicFileAttributes attrs) {
        final StringBuilder summary = new StringBuilder();

        summary.append("[isRegularFile = ").append(attrs.isRegularFile()).append("],");
        summary.append("[isSymbolicLink = ").append(attrs.isSymbolicLink()).append("],");
        summary.append("[isDirectory = ").append(attrs.isDirectory()).append("],");
        summary.append("[isOther = ").append(attrs.isOther()).append("]");

        return summary.toString();
    }
}
