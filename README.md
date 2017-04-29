# Mimak

Mimak is a micro-library that makes detection of MIME type for files DRYer.

I made Mimak while working on a disk scanning tool. I have re-written the code for that tool multiple
times so far and each time I rewrote the MIME type detection logic from scratch. This put me into a
"programmer's block" mood as I didn't want to repeat this mundane and boring task over and over again.

By extracting this logic into Mimak, now I can write/throw-away/rewrite my disk scanning tool prototypes
without the displeasure of spending time on rewriting its non-essential parts.

## Sample code

*Code:*
```java
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        final Path aPomFile = Paths.get("/home/turingg/.m2/repository/commons-io/commons-io/2.5/commons-io-2.5.pom");
        final Mimak mimak = Mimaks.getTikaMimak(Mimak.SymlinkOptions.IGNORE_SYMLINKS);

        System.out.printf("%s\n\t↪ %s\n", aPomFile.toAbsolutePath(), mimak.detect(aPomFile));
    }
}
```

*Output:*
```
/home/turingg/.m2/repository/commons-io/commons-io/2.5/commons-io-2.5.pom
 	↪ application/xml
```