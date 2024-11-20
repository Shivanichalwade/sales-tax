package com.salesTax.service;

import com.salesTax.model.Item;

public class TaxCalculator {
    private static final double BASIC_TAX_RATE = 0.10;
    private static final double IMPORT_TAX_RATE = 0.05;

    public double calculateTax(final Item item) {
        double taxRate = 0.0;

        if (!item.getCategory().isExempt()) {
            taxRate += BASIC_TAX_RATE;
        }

        if (item.isImported()) {
            taxRate += IMPORT_TAX_RATE;
        }

        return roundToNearest0_05(item.getPrice() * taxRate);
    }

    private double roundToNearest0_05(final double amount) {
        return Math.ceil(amount * 20) / 20;
    }
}