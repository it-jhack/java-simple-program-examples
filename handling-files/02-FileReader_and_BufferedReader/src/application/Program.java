package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main (String[] args) {

        // There is a cleaner way to write all this, which we'll see later
        String path = System.getProperty("user.dir") + "\\handling-files\\02-FileReader_and_BufferedReader\\in.txt";

        // Difference between FileReader and BufferedReader:
        // https://stackoverflow.com/questions/9648811/specific-difference-betweenbufferedreader-and-filereader
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            // Could also be:
            // br = new BufferedReader(new FileReader(path));

            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
        }
        finally {
            try { // exception can happen when closing br and fr
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}