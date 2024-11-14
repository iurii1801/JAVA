import java.util.Arrays;

public class WordMatcher {
    private final String sortedFirstWord;

    public WordMatcher(String firstWord) {
        this.sortedFirstWord = sortLetters(firstWord);
    }

    private String sortLetters(String word) {
        char[] letters = word.toLowerCase().toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }

    public boolean isMatching(String word) {
        return sortLetters(word).equals(sortedFirstWord);
    }
}
