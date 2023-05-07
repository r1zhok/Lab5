package ua.lviv.iot.algo.part1.lab5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextScannerTest {

    private TextScanner textScanner;
    private String expected;
    private String text;
    private String searchWord;

    @BeforeEach
    public void setUp() {
        textScanner = new TextScanner();
        expected = "summer_2022.png\nsummer_2022.gif\n";
        text = "Last summer I make my best photo, it calls summer_2022.png, on this photo I " +
                "was young, haha, also I have gif it names summer_2022.gif" +
                " and I have SUmmer_2022.jpeg and summer2022.png";
        searchWord = "summer_2022";
    }

    @Test
    public void testScanEmptyText() {
        assertEquals(null, textScanner.textScanner("", "summer_2022"));
    }

    @Test
    public void testEmptySearchWord() {
        assertEquals("There is no word to search", textScanner.textScanner(text, ""));
    }

    @Test
    public void testScanEmptyTextAndSearchWord() {
        assertEquals(null, textScanner.textScanner("", ""));
    }

    @Test
    public void testScanText() {
        assertEquals(expected, textScanner.textScanner(text, searchWord));
    }

    @Test
    public void testScanTextWithNoMatches() {
        assertEquals(null, textScanner.textScanner(text, "October"));
    }

}
