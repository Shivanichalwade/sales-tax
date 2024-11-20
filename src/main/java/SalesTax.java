import com.salesTax.model.Item;
import com.salesTax.model.ItemCategory;
import com.salesTax.model.Receipt;
import com.salesTax.service.ReceiptGenerator;
import com.salesTax.service.TaxCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesTax {
    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();
        ReceiptGenerator receiptGenerator = new ReceiptGenerator(taxCalculator);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Sales Tax Calculator!");
        System.out.println("Please enter items for your receipt. Type 'done' when finished.");

        List<Item> basket = new ArrayList<>();
        while (true) {
            System.out.println("Enter item name (or 'done' to finish):");
            String name = scanner.nextLine();
            if ("done".equalsIgnoreCase(name)) {
                break;
            }

            System.out.println("Enter price:");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.println("Is the item imported? (yes/no):");
            boolean imported = scanner.nextLine().equalsIgnoreCase("yes");

            System.out.println("Select category (1-Book, 2-Food, 3-Medical, 4-Other):");
            int categoryChoice = Integer.parseInt(scanner.nextLine());
            ItemCategory category;
            switch (categoryChoice) {
                case 1:
                    category = ItemCategory.BOOK;
                    break;
                case 2:
                    category = ItemCategory.FOOD;
                    break;
                case 3:
                    category = ItemCategory.MEDICAL;
                    break;
                case 4:
                default:
                    category = ItemCategory.OTHER;
                    break;
            }

            basket.add(new Item(name, price, imported, category));
            System.out.println("Item added successfully!\n");
        }

        if (basket.isEmpty()) {
            System.out.println("No items added. Exiting.");
        } else {
            Receipt receipt = receiptGenerator.generateReceipt(basket);
            System.out.println("Receipt:");
            System.out.println(receipt);
        }

        scanner.close();
    }
}