import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Word Counter");
        System.out.println("1. Enter text");
        System.out.println("2. Provide a file");

        int option = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        String text = "";
        if (option == 1) {
            System.out.println("Enter text: ");
            text = scanner.nextLine();
        } else if (option == 2) {
            System.out.println("Enter the path to the file: ");
            String filePath = scanner.nextLine();
            text = readTextFromFile(filePath);
        } else {
            System.out.println("Invalid option.");
            return;
        }

        if (text.isEmpty()) {
            System.out.println("Input is empty.");
            return;
        }

        // Split the text into an array of words using spaces and common punctuation as delimiters
        String[] words = text.split("[\\s.,?!;]+");
        int wordCount = words.length;

        // Define common stop words to ignore
        String[] stopWords = {"the", "and", "is", "in", "to", "a", "of", "it"};

        // Count unique words and their frequency
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            if (!Arrays.asList(stopWords).contains(word.toLowerCase())) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        int uniqueWordCount = wordFrequency.size();

        System.out.println("Total words: " + wordCount);
        System.out.println("Unique words: " + uniqueWordCount);

        // Display the frequency of each word
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static String readTextFromFile(String filePath) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line).append(" ");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return text.toString();
    }
}
