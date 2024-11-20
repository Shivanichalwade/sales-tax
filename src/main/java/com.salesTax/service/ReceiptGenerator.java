package com.salesTax.service;

import com.salesTax.model.Item;
import com.salesTax.model.Receipt;

import java.util.List;

public class ReceiptGenerator {
    private final TaxCalculator taxCalculator;

    public ReceiptGenerator(final TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public Receipt generateReceipt(final List<Item> items) {
        Receipt receipt = new Receipt();
        for (Item item : items) {
            double tax = taxCalculator.calculateTax(item);
            receipt.addItem(item, tax);
        }
        return receipt;
    }
}
