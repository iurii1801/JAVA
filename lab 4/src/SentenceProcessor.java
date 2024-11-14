import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceProcessor {
    private final String sentence;
    private final WordMatcher wordMatcher;

    public SentenceProcessor(String sentence) {
        this.sentence = sentence;
        String firstWord = extractFirstWord(sentence);
        this.wordMatcher = new WordMatcher(firstWord);
    }

    private String extractFirstWord(String sentence) {
        // Используем регулярное выражение для нахождения первого слова, состоящего из букв
        Matcher matcher = Pattern.compile("\\b[\\p{L}]+\\b").matcher(sentence);  // \\p{L} обозначает любые буквы
        return matcher.find() ? matcher.group() : "";
    }

    public List<String> findMatchingWords() {
        List<String> matchingWords = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b[\\p{L}]+\\b").matcher(sentence);

        while (matcher.find()) {
            String word = matcher.group();
            if (wordMatcher.isMatching(word)) {
                matchingWords.add(word);
            }
        }

        return matchingWords;
    }
}
