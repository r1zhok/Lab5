package ua.lviv.iot.algo.part1.lab5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextScanner {
    public static void main(String ... strings) {
        TextScanner scanner = new TextScanner();
        System.out.println("Print text with your images: ");
        Scanner textFromConsole = new Scanner(System.in);
        Scanner searchWordFromConsole = new Scanner(System.in);
        String text = textFromConsole.nextLine();
        /*String text = "Last summer I make my best photo, it calls summer_2022.png, on this photo I " +
                "was young, haha, also I have gif it names summer_2022.gif and I have SUmmer_2022.jpeg and summer2022.png";*/
        /*String searchWord = "summer_2022";*/
        System.out.println("Print name of photo witch you want to find: ");
        String searchWord  = searchWordFromConsole.next();

        scanner.textScanner(text, searchWord);
    }

    public String textScanner(String text, String searchWord) {
        Pattern pattern = Pattern.compile(searchWord + "(\\.\\w+)");
        Matcher matcher = pattern.matcher(text);
        String  findSearchWord = "";
        StringBuilder textBuilder = new StringBuilder(text);

        if (text.equals("")) {
            System.out.println("No matches in text.");
            return null;
        }

        while (matcher.find()) {
            findSearchWord += text
                    .substring(matcher.start(), matcher.end()) + "\n";
            String ex = text
                    .substring(matcher.start(), matcher.end());
            /*System.out.println(text
                    .substring(matcher.start(), matcher.end()) + "*");*/
            textBuilder.replace(matcher.start(), matcher.end(), "***" + ex + "***");
        }

        System.out.println(textBuilder);

        return findSearchWord;
    }
}
