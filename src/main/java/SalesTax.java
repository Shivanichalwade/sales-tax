import com.salesTax.model.Item;
import com.salesTax.model.ItemCategory;
import com.salesTax.service.ReceiptGenerator;
import com.salesTax.service.TaxCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesTax {
    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();
        ReceiptGenerator receiptGenerator = new ReceiptGenerator(taxCalculator);

        List<Item> items = parseInput();
        if (items.isEmpty()) {
            System.out.println("No valid items provided.");
            return;
        }

        System.out.println("Output:");
        System.out.println(receiptGenerator.generateReceipt(items));
    }

    private static List<Item> parseInput() {
        Scanner scanner = new Scanner(System.in);
        List<Item> items = new ArrayList<>();
        System.out.println("Enter items (format: '1 [name] at [price]'), or type 'done' to finish:");

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            String[] parts = input.split(" at ");
            if (parts.length != 2) {
                System.out.println("Invalid format. Try again.");
                continue;
            }

            String name = parts[0].substring(2).trim();
            double price;
            try {
                price = Double.parseDouble(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Try again.");
                continue;
            }

            boolean imported = name.toLowerCase().contains("imported");
            ItemCategory category = determineCategory(name);

            items.add(new Item(name, price, imported, category));
        }
        return items;
    }

    private static ItemCategory determineCategory(final String name) {
        if (name.toLowerCase().contains("book")) {
            return ItemCategory.BOOK;
        } else if (name.toLowerCase().contains("chocolate") || name.toLowerCase().contains("food")) {
            return ItemCategory.FOOD;
        } else if (name.toLowerCase().contains("pills")) {
            return ItemCategory.MEDICAL;
        } else {
            return ItemCategory.OTHER;
        }
    }
}
