package com.salesTax.model;

import lombok.Getter;

/**
 * Represents an item in the purchase list. Acts as a data model.
 * <p>
 * WHY: Encapsulation of item data ensures clarity, easier maintenance,
 * and reusability.
 */
@Getter
public class Item {
    private final String name;
    private final double price;
    private final boolean imported;
    private final ItemCategory category;

    public Item(final String name, final double price, final boolean imported, final ItemCategory category) {
        this.name = name;
        this.price = price;
        this.imported = imported;
        this.category = category;
    }

    // Added behavior to calculate base tax for the item
    public double calculateTax(double basicTaxRate, double importTaxRate) {
        double tax = 0.0;
        if (!category.isExempt()) {
            tax += price * basicTaxRate;
        }
        if (imported) {
            tax += price * importTaxRate;
        }
        return tax;
    }
}