# Mimak

Mimak is a micro-library that makes detection of MIME type for files DRYer.

## Sample code

The following code iterates files inside the `/home/turingg/.m2/repository/commons-io/commons-io/2.5` directory
and prints their MIME types in the console

*Code:*

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        final Mimak mimak = Mimaks.getTikaMimak(true);
        final Path aDir = Paths.get("/home/turingg/.m2/repository/commons-io/commons-io/2.5");
        Files.list(aDir).forEach(f -> {
            try {
                System.out.printf("%s\n    ↪ %s\n", f.toAbsolutePath(), mimak.detect(f));
            } catch (MimakException e) {
                e.printStackTrace();
            }
        });
    }
}
```

*Output:*
```
/home/turingg/.m2/repository/commons-io/commons-io/2.5/_remote.repositories
    ↪ text/plain
/home/turingg/.m2/repository/commons-io/commons-io/2.5/commons-io-2.5-sources.jar.sha1
    ↪ text/plain
/home/turingg/.m2/repository/commons-io/commons-io/2.5/commons-io-2.5.pom
    ↪ application/xml
/home/turingg/.m2/repository/commons-io/commons-io/2.5/commons-io-2.5.jar
    ↪ application/java-archive
/home/turingg/.m2/repository/commons-io/commons-io/2.5/commons-io-2.5.pom.sha1
    ↪ text/plain
/home/turingg/.m2/repository/commons-io/commons-io/2.5/commons-io-2.5.jar.sha1
    ↪ text/plain
/home/turingg/.m2/repository/commons-io/commons-io/2.5/commons-io-2.5-sources.jar
    ↪ application/java-archive
```