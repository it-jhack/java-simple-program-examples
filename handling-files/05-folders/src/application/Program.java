package application;

import java.io.File;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath); // File can receive path to a folder
        File[] directories = path.listFiles(File::isDirectory);
        System.out.println("\nDirectories:");
        for (File dir : directories) {
            System.out.println(dir);
        }
        File[] files = path.listFiles(File::isFile);
        System.out.println("\nFILES:");
        for (File file : files) {
            System.out.println(file);
        }
        // creating subfolder
        boolean success = new File(strPath + "\\subdir").mkdir();
        System.out.println("Directory created successfully: " + success);
        sc.close();
    }
}