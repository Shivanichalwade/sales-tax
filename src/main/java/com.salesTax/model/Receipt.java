package com.salesTax.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a purchase receipt.
 * <p>
 * WHY: Keeps aggregation logic (e.g., total tax, total amount) encapsulated.
 */
public class Receipt {
    private final List<ReceiptItem> items = new ArrayList<>();
    private double totalTax = 0.0;
    private double totalAmount = 0.0;

    public void addItem(Item item, double tax) {
        items.add(new ReceiptItem(item, tax));
        totalTax += tax;
        totalAmount += item.getPrice() + tax;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ReceiptItem item : items) {
            sb.append(String.format("1 %s: %.2f%n", item.getItem().getName(), item.getItem().getPrice() + item.getTax()));
        }
        sb.append(String.format("Sales Taxes: %.2f%n", totalTax));
        sb.append(String.format("Total: %.2f", totalAmount));
        return sb.toString();
    }
}
