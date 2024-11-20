package com.salesTax.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {
    private String name;
    private double price;
    private boolean imported;
    private ItemCategory category;
}