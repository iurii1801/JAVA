//Лабораторная работа №4. Обработка строк. Коллекции. Регулярные выражения.
//При решении задач использовать: класс String, StringBuffer, коллекции, настраиваемые коллекции, регулярные выражения.
// Избегать, по возможности, “мелкой” работы на уровне отдельных символов.
//
//Перечислить все слова заданного предложения, которые состоят из тех же букв, что и первое слово предложения.
// Между словами может быть произвольное число пробелов и знаков препинания. Вывести предложение и слова.

import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        String sentence = "Тест для проверки работы программы с помощью слов: ттсе тсет сетт";
        System.out.println("Исходное предложение: " + sentence);

        String firstWord = extractFirstWord(sentence);
        if (firstWord.isEmpty()) {
            System.out.println("Первое слово не найдено.");
            return;
        }

        String sortedFirstWord = sortLetters(firstWord.toLowerCase());
        List<String> matchingWords = findWordsWithSameLetters(sentence, sortedFirstWord, firstWord);

        System.out.println("Слова, состоящие из тех же букв, что и первое слово: " + matchingWords);
    }

    private static String extractFirstWord(String text) {
        Matcher matcher = Pattern.compile("\\b[а-яА-Яa-zA-Z]+\\b").matcher(text);
        return matcher.find() ? matcher.group().toLowerCase() : "";
    }

    private static List<String> findWordsWithSameLetters(String sentence, String sortedFirstWord, String firstWord) {
        List<String> matchingWords = new ArrayList<>();
        String[] words = sentence.split("[^а-яА-Яa-zA-Z]+");

        for (String word : words) {
            if (!word.isEmpty()) {
                if (!word.equalsIgnoreCase(firstWord)) {
                    String sortedWord = sortLetters(word.toLowerCase());
                    if (sortedWord.equals(sortedFirstWord)) {
                        matchingWords.add(word);
                    }
                }
            }
        }

        return matchingWords;
    }

    private static String sortLetters(String word) {
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
}
