
// // File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.util.ArrayList;

// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.util.ArrayList;

// // comment z
// public class MarkdownParse {
//     public static ArrayList<String> getLinks(String markdown) {
//         // random comment
//         ArrayList<String> toReturn = new ArrayList<>();
//         // find the next [, then find the ], then find the (, then take up to
//         // the next )
//         int currentIndex = 0;
//         while (currentIndex < markdown.length()) {
//             int nextOpenBracket = markdown.indexOf("[", currentIndex);
//             System.out.println(currentIndex);
//             int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
//             // the second argument is for where to start research, if not provided, search
//             // start from index 0
//             int openParen = markdown.indexOf("(", nextCloseBracket);
//             int closeParen = markdown.indexOf(")", openParen);

//             if (nextCloseBracket + 1 == openParen
//                     && (nextOpenBracket == 0 || markdown.charAt(nextOpenBracket - 1) != '!')) {

//                 toReturn.add(markdown.substring(openParen + 1, closeParen));
//                 int whiteSpace = markdown.indexOf(" ", openParen);
//                 for (int i = openParen; i < closeParen; ++i) {
//                     if (whiteSpace == i) {
//                         toReturn.remove(markdown.substring(openParen + 1, closeParen));

//                     }
//                 }
//                 // github push test
//             }
//             currentIndex = closeParen + 1;
//             System.out.println(currentIndex);
//         }
//         return toReturn;
//     }

//     public static void main(String[] args) throws IOException {
//         Path fileName = Path.of(args[0]);
//         String contents = Files.readString(fileName);
//         ArrayList<String> links = getLinks(contents);
//         System.out.println(links);
//     }
// }

// //
// public class MarkdownParse {
// public static ArrayList<String> getLinks(String markdown) {
// ArrayList<String> toReturn = new ArrayList<>();
// // find the next [, then find the ], then find the (, then take up to
// // the next )
// int currentIndex = 0;
// while (currentIndex < markdown.length()) {
// int nextOpenBracket = markdown.indexOf("[", currentIndex);
// int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
// int openParen = markdown.indexOf("(", nextCloseBracket);
// int closeParen = markdown.indexOf(")", openParen);
// if (closeParen == -1) {
// break;
// }
// if (nextCloseBracket == openParen - 1
// && (nextOpenBracket == 0 || markdown.charAt(nextOpenBracket - 1) != '!')) {
// toReturn.add(markdown.substring(openParen + 1, closeParen));
// }

// currentIndex = closeParen + 1;
// System.out.println(currentIndex);
// }
// return toReturn;
// }

// public static void main(String[] args) throws IOException {
// Path fileName = Path.of(args[0]);
// String contents = Files.readString(fileName);
// ArrayList<String> links = getLinks(contents);
// System.out.println(links);
// }
// }

// 1pm markdown parse
// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while (currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            if (nextOpenBracket == -1) {
                break;
            }
            if (nextOpenBracket > 0 && markdown.charAt(nextOpenBracket - 1) == '!') {
                break;
            }
            int nextCloseBracket = markdown.indexOf("](", nextOpenBracket);
            if (nextCloseBracket == -1) {
                break;
            }
            int closeParen = markdown.indexOf(")", nextCloseBracket);
            toReturn.add(markdown.substring(nextCloseBracket + 2, closeParen));
            currentIndex = closeParen + 1;
            // System.out.format("%d\t%d\t%d\t%d\n", currentIndex, nextOpenBracket,
            // nextCloseBracket, closeParen);
        }
        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}