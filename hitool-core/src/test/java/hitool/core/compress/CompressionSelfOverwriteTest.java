package hitool.core.compress;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

public class CompressionSelfOverwriteTest {
    @Test
    public void gzipRejectsExtensionlessInputAndSameFileAlias() throws Exception {
        byte[] compressed = GZipUtils.compress("payload".getBytes(StandardCharsets.UTF_8));
        Path dir = Files.createTempDirectory("hitool-gzip-safety-");
        try {
            Path source = dir.resolve("payload");
            Files.write(source, compressed);
            expectIOException(() -> GZipUtils.decompress(source.toFile(), false));
            assertArrayEquals(compressed, Files.readAllBytes(source));
            expectIOException(() -> GZipUtils.decompress(source.toFile(), dir.toFile()));
            assertArrayEquals(compressed, Files.readAllBytes(source));

            Path named = dir.resolve("named.gz");
            Files.write(named, compressed);
            Path alias = dir.resolve("named");
            Files.createSymbolicLink(alias, named.getFileName());
            expectIOException(() -> GZipUtils.decompress(named.toFile(), dir.toFile()));
            assertArrayEquals(compressed, Files.readAllBytes(named));
        } finally {
            Files.deleteIfExists(dir.resolve("named"));
            Files.deleteIfExists(dir.resolve("named.gz"));
            Files.deleteIfExists(dir.resolve("payload"));
            Files.deleteIfExists(dir);
        }
    }

    @Test
    public void bzip2RejectsExtensionlessInputAndSameFileAlias() throws Exception {
        byte[] compressed = BZip2Utils.compress("payload".getBytes(StandardCharsets.UTF_8));
        Path dir = Files.createTempDirectory("hitool-bzip2-safety-");
        try {
            Path source = dir.resolve("payload");
            Files.write(source, compressed);
            expectIOException(() -> BZip2Utils.decompress(source.toFile(), false));
            assertArrayEquals(compressed, Files.readAllBytes(source));
            expectIOException(() -> BZip2Utils.decompress(source.toFile(), dir.toFile()));
            assertArrayEquals(compressed, Files.readAllBytes(source));

            Path named = dir.resolve("named.bz2");
            Files.write(named, compressed);
            Path alias = dir.resolve("named");
            Files.createSymbolicLink(alias, named.getFileName());
            expectIOException(() -> BZip2Utils.decompress(named.toFile(), dir.toFile()));
            assertArrayEquals(compressed, Files.readAllBytes(named));
        } finally {
            Files.deleteIfExists(dir.resolve("named"));
            Files.deleteIfExists(dir.resolve("named.bz2"));
            Files.deleteIfExists(dir.resolve("payload"));
            Files.deleteIfExists(dir);
        }
    }

    private void expectIOException(ThrowingAction action) throws Exception {
        try {
            action.run();
            fail("Expected IOException before opening the output file");
        } catch (IOException expected) {
            // The compressed source must remain intact.
        }
    }

    private interface ThrowingAction {
        void run() throws Exception;
    }
}
