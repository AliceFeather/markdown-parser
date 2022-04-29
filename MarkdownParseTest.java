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
            List.of("https://something.com", "some-thing");
        Path file = Path.of("test-file.md");
        String content = Files.readString(file);
        assertEquals(test, MarkdownParse.getLinks(content));
    }
}

