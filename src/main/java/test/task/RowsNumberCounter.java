package test.task;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class RowsNumberCounter {

    public long count(String p) {
        long lineCount = 0;
        try (Stream<String> stream = Files.lines(Path.of(p), StandardCharsets.ISO_8859_1)) {
            lineCount = stream.count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
    }
}
