package com.salesTax.service;

import com.salesTax.model.Item;
import com.salesTax.model.ItemCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxCalculatorTest {
    private TaxCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new TaxCalculator();
    }

    @Test
    void testExemptNonImportedItem() {
        Item book = new Item("book", 12.49, false, ItemCategory.BOOK);
        assertEquals(0.0, calculator.calculateTax(book));
    }

    @Test
    void testNonExemptNonImportedItem() {
        Item cd = new Item("music CD", 14.99, false, ItemCategory.OTHER);
        assertEquals(1.50, calculator.calculateTax(cd));
    }

    @Test
    void testExemptImportedItem() {
        Item chocolate = new Item("imported chocolate", 10.00, true, ItemCategory.FOOD);
        assertEquals(0.50, calculator.calculateTax(chocolate));
    }

    @Test
    void testNonExemptImportedItem() {
        Item perfume = new Item("imported perfume", 47.50, true, ItemCategory.OTHER);
        assertEquals(7.15, calculator.calculateTax(perfume));
    }
    }