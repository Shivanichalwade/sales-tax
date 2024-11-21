package com.salesTax.model;

import lombok.Getter;

/**
 * Enum representing categories of items. Defines if a category is exempt from basic tax.
 * <p>
 * WHY: Encapsulating category-specific behavior
 * ensures consistency and avoids hardcoding these rules in other parts of the code.
 */
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