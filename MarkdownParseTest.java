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
    public void getLinks() throws IOException {
        Path fileName = Path.of("C:/Users/cowhe/Documents/GitHub/markdown-parse/test-file.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinks1() throws IOException {
        Path fileName = Path.of("C:/Users/cowhe/Documents/GitHub/markdown-parse/test2.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("link.com", ""), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinks2() throws IOException {
        Path fileName = Path.of("C:/Users/cowhe/Documents/GitHub/markdown-parse/test3.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of(""), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinks3() throws IOException {
        Path fileName = Path.of("C:/Users/cowhe/Documents/GitHub/markdown-parse/test4.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

}

// public class MarkdownParseTest {
// @Test
// public void addition() {
// assertEquals(2, 1 + 1);
// }

// @Test
// public void test() throws IOException {
// Path fileName = Path.of("test-file.md");
// String contents = Files.readString(fileName);
// assertEquals(MarkdownParse.getLinks(contents),
// List.of("https://something.com", "some-page.html"));

// Path fileName2 = Path.of("test2.md");
// String contents2 = Files.readString(fileName2);
// assertEquals(MarkdownParse.getLinks(contents2), List.of("link.com"));
// }
// }

// javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar
// MarkdownParseTest.java

// java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar
// org.junit.runner.JUnitCore MarkdownParseTest