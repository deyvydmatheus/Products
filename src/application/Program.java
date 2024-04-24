package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Product> products = new ArrayList<Product>();

        System.out.print("Enter the number of Products: ");
        int num = input.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.println("Product #" + (i + 1) + " data: ");

            System.out.print("Common, Used or Imported? (c/u/i): ");
            char ch = input.next().charAt(0);

            System.out.print("Name: ");
            input.nextLine();
            String nameOfProduct = input.nextLine();

            System.out.print("Price: ");
            double priceOfProduct = input.nextDouble();

            if (ch == 'i') {
                System.out.print("Customs Fee: ");
                double customsFee = input.nextDouble();

                products.add(new ImportedProduct(nameOfProduct, priceOfProduct, customsFee));
            } else if (ch == 'c') {
                products.add(new Product(nameOfProduct, priceOfProduct));
            } else {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                input.nextLine();
                String dateOfManufacture = input.nextLine();
                LocalDate manufactureDate = LocalDate.parse(dateOfManufacture, fmt1);

                products.add(new UsedProduct(nameOfProduct, priceOfProduct, manufactureDate));
            }
        }

        System.out.println("PRICE TAGS: ");
        for (Product product : products) {
            System.out.println(product.priceTag());
        }



        input.close();
    }
}