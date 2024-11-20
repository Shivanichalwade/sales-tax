package com.salesTax.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Receipt {
    private List<ReceiptItem> items;
    private double totalTax;
    private double totalAmount;

    public Receipt() {
        this.items = new ArrayList<>();
        this.totalTax = 0.0;
        this.totalAmount = 0.0;
    }
    public void addItem(Item item, double tax) {
        items.add(new ReceiptItem(item, tax));
        totalTax += tax;
        totalAmount += item.getPrice() + tax;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ReceiptItem item : items) {
            sb.append(String.format("%s: %.2f%n",
                    item.getItem().getName(),
                    item.getItem().getPrice() + item.getTax()));
        }
        sb.append(String.format("Sales Taxes: %.2f%n", totalTax));
        sb.append(String.format("Total: %.2f", totalAmount));
        return sb.toString();
    }
}