import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void test() throws IOException {
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        assertEquals(MarkdownParse.getLinks(contents), List.of("https://something.com", "some-page.html"));
    }
}

// javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar
// MarkdownParseTest.java

// java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar
// org.junit.runner.JUnitCore MarkdownParseTest