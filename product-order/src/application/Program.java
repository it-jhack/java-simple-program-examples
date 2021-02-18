package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("ENTER CLIENT DATA");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(clientName, email, birthDate);

        System.out.println();
        System.out.println("ENTER ORDER DATA");
        System.out.println("Enter status: PENDING_PAYMENT, PROCESSING, SHIPPED, or DELIVERED");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), client, status);

        System.out.print("How many items on this order? ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {

            System.out.println("Enter item #" + i + " data");
            sc.nextLine(); // consuming '\n' in the buffer;
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double price = sc.nextDouble();

            Product product = new Product(productName, price);

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem item = new OrderItem(quantity, product);

            order.addItem(item);

        }

        System.out.println();
        System.out.println("ORDER SUMMARY");
        System.out.println(order);

    }
}
