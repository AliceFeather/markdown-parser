//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            if (openBracket == -1 && closeBracket != -1 ){
                break;
            }
            
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if(openBracket == -1 || closeBracket == -1 || openParen == -1 || closeParen == -1){
                break;
            }
            
            int newLineAfterOB = markdown.indexOf("\n", openBracket);

            if(newLineAfterOB < closeParen && newLineAfterOB > openBracket){
                currentIndex = closeParen + 1;
                continue;
            }

            // check if it is an image
            if (openBracket != markdown.length() && openBracket != 0){
                if (!(markdown.substring(openBracket-1, openBracket).equals("!"))){
                    String link = markdown.substring(openParen + 1, closeParen);
                    link = link.trim();
                    if (!link.isEmpty()){
                        toReturn.add(link);
                    }
                }
            }
            currentIndex = closeParen + 1;
        }
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
        
    }
}
