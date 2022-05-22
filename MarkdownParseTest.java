import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws IOException{
        List<String> test = 
            List.of("https://something.com", "some-thing.html");
        Path file = Path.of("test-file.md");
        String content = Files.readString(file);
        assertEquals(test, MarkdownParse.getLinks(content));
    }

    @Test
    public void testSnippet1() throws IOException{
        List<String> expected =
            List.of("`google.com", "google.com", "ucsd.edu");
        Path file = Path.of("snippet1.md");
        String content = Files.readString(file);
        assertEquals(expected, MarkdownParse.getLinks(content));
    }

    @Test
    public void testSnippet2() throws IOException{
        List<String> expected =
            List.of("a.com", "a.com(())", "example.com");
        Path file = Path.of("snippet2.md");
        String content = Files.readString(file);
        assertEquals(expected, MarkdownParse.getLinks(content));
    }

    @Test
    public void testSnippet3() throws IOException{
        List<String> expected =
            List.of("https://www.twitter.com", 
            "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule", 
            "https://cse.ucsd.edu/");
        Path file = Path.of("snippet3.md");
        String content = Files.readString(file);
        assertEquals(expected, MarkdownParse.getLinks(content));
    }
}

