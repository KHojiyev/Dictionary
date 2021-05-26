package module3.lesson5_WriteReadFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DictionaryOxford {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> dictionary = new TreeMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("oxford.txt"))) {
            String word;
            int wordCount = 0;
            while ((word = bufferedReader.readLine()) != null) {
                dictionary.put(wordCount, word);
                wordCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            while (true) {
                System.out.print("\nEnter Word: ");
                scanner = new Scanner(System.in);
                String searchWord = scanner.nextLine();
                boolean notfound = true;
                for (int i = 0; i < dictionary.size(); i++) {
                    if (dictionary.get(i).toLowerCase().trim().startsWith(searchWord.toLowerCase())) {
                        notfound = false;
                        System.out.println(dictionary.get(i));
                    }
                }
                if (notfound) {
                    System.out.println("\nWord not found\n");
                }


            }
        }


    }
}
