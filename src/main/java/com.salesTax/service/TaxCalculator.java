package com.salesTax.service;

import com.salesTax.model.Item;

/**
 * Handles tax calculation logic. Implements:
 * <p>
 * WHY: Encapsulation of tax rules into a separate class promotes scalability
 * and clarity. Future tax rule changes can be handled here without affecting
 * other parts of the codebase.
 */
public class TaxCalculator {
    private static final double BASIC_TAX_RATE = 0.10;
    private static final double IMPORT_TAX_RATE = 0.05;

    public double calculateTax(Item item) {
        return roundToNearest0_05(item.calculateTax(BASIC_TAX_RATE, IMPORT_TAX_RATE));
    }

    private double roundToNearest0_05(double amount) {
        return Math.ceil(amount * 20) / 20.0;
    }
}