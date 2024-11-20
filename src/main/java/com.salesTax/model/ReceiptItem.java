package com.salesTax.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReceiptItem {
    private final Item item;
    private final double tax;
}