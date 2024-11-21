package com.salesTax.service;

import com.salesTax.model.Item;
import com.salesTax.model.Receipt;
import com.salesTax.model.ReceiptItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles the generation of receipts by processing a list of items
 * through the TaxCalculator.
 * <p>
 * WHY: This separation avoids bloating. Makes the flow more modular
 * and easier to test.
 */
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
