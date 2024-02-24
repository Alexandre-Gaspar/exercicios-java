package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import models.entities.ImportedProduct;
import models.entities.Product;
import models.entities.UsedProduct;

public class App {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Product> products = new ArrayList<>();

        System.out.print("\nEnter the nuimber of products: ");
        int numberOfProducts = sc.nextInt();

        int count = 0;
        while (count < numberOfProducts) {
            ++count;
            System.out.println("Product #" + count + " data: ");
            System.out.print("Comom, used or imported (c/u/i)? ");
            char type = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();

            if (type == 'u' || type == 'U') {
                System.out.print("Manufacture date: ");
                sc.nextLine();
                LocalDate manufactureDate = LocalDate.parse(sc.nextLine(), formatDate);
        
                // Add element to the list
                products.add(new UsedProduct(name, price, manufactureDate));
            } else if (type == 'i' || type == 'I') {
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();

                products.add(new ImportedProduct(name, price, customsFee));
            } else {
                products.add(new Product(name, price));
            }
        }

        System.out.println("\nPRICE TAGS:");
        for (Product each : products) {
            System.out.println(each.priceTag());
        }

        sc.close();
    }
}
