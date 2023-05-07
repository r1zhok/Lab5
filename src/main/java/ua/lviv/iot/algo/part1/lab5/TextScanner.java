package ua.lviv.iot.algo.part1.lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextScanner {

    private static final String FILE_FORMAT_REGEX = "\\.[a-z]+";

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Arguments must be 2!");
            return;
        }

        TextScanner scanner = new TextScanner();

        String text = args[0];
        String searchWord = args[1];

        System.out.println(scanner.textScanner(text, searchWord));
    }

    public String textScanner(String text, String searchWord) {


        String matchedWords = "";

        Pattern pattern = Pattern.compile(searchWord + FILE_FORMAT_REGEX);
        Matcher matcher = pattern.matcher(text);

        //StringBuilder textBuilder = new StringBuilder(text);

        if (text.equals("")) {
            return null;
        } else if (searchWord.equals("")) {
            //System.out.println(textBuilder);
            //return null;
            return "There is no word to search";
        }

        while (matcher.find()) {
            matchedWords += text
                    .substring(matcher.start(), matcher.end()) + "\n";
            /*String foundWord = text
                    .substring(matcher.start(), matcher.end());
            textBuilder.replace(matcher.start(), matcher.end(),
                    "***" + foundWord + "***");*/
        }

        if (matchedWords.equals("")) {
            System.out.println("No matches found.");
            return null;
        }

        //System.out.println(matchedWords);
        return matchedWords;
    }
}
