package com.salesTax.model;

import lombok.Getter;


@Getter
public enum ItemCategory {
    BOOK(true),
    FOOD(true),
    MEDICAL(true),
    OTHER(false);
    private final boolean exempt;

    ItemCategory(boolean exempt) {
        this.exempt = exempt;
    }

}