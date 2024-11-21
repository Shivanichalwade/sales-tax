package com.salesTax.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ReceiptItem {
    private final Item item;
    private final double tax;

    public ReceiptItem(final Item item,final double tax) {
        this.item = item;
        this.tax = tax;
    }
}