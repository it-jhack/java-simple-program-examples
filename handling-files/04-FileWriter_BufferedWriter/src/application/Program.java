package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {

        String[] greetings = new String[] {"Good morning", "Good afternoon", "Good night"};

        String outputPath = System.getProperty("user.dir") + "\\handling-files\\\\04-FileWriter_BufferedWriter\\out.txt";
        String outputPath2 = System.getProperty("user.dir") + "\\handling-files\\\\04-FileWriter_BufferedWriter\\out2.txt";


        // Create or append to file:
        // try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath2, true))) { ... }

        // Create or Overwrite File:
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {
            for (String greeting : greetings) {
                bw.write(greeting);
                bw.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
