package au.com.turingg.microlibs.mimak;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        final Path aPomFile = Paths.get("/home/veyron/.m2/repository/commons-io/commons-io/2.5/commons-io-2.5.pom");
        final Mimak mimak = Mimaks.getTikaMimak(true);

        System.out.printf("%s\n\t↪ %s\n", aPomFile.toAbsolutePath(), mimak.detect(aPomFile));
    }
}
