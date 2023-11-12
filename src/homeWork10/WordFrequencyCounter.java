package homeWork10;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filePath = "words.txt";
        try {
            Map<String, Integer> wordFrequencyMap = countWordFrequency(filePath);
            printSortedWordFrequency(wordFrequencyMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Integer> countWordFrequency(String filePath) throws IOException {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Розділити рядок на слова, використовуючи пробіли як роздільники
                String[] words = line.split("\\s+");

                // Підрахувати частоту кожного слова
                for (String word : words) {
                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        }

        return wordFrequencyMap;
    }

    private static void printSortedWordFrequency(Map<String, Integer> wordFrequencyMap) {
        // Відсортувати мапу за частотою у зростаючому порядку
        Map<String, Integer> sortedWordFrequencyMap = wordFrequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));

        // Вивести відсортовану мапу
        sortedWordFrequencyMap.forEach((word, frequency) -> System.out.println(word + " " + frequency));
    }
}
