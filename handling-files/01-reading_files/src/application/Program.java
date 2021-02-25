package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main (String[] args) {

        File file1 = new File("C:\\Users\\Tiago\\Desktop" +
                "\\my_github_repos\\_my_repos\\java-simple-program-examples" +
                "\\handling-files\\01\\in.txt");

        Scanner sc = null;

        // it can generate IOException while trying to open file
        // so we have to use try-catch, and treat the exception
        try {
            sc = new Scanner(file1);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            // if I use 'sc.close()' on this line, and an error occurs,
            // it will jump to catch, and sc will not be closed.
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            // if necessary in case error before sc instantiated
            if (sc != null) {
                sc.close();
            }
        }
    }
}