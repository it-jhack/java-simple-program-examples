package application;

import entities.Product;
import services.CalculationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        String path = System.getProperty("user.dir") + "\\generics-set-map\\02-delimited_generics\\products.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            Product max = CalculationService.max(list);
            System.out.print("Higher price: " + max + "\n");
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
