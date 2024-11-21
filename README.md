## Sales Tax Calculator Application
This is a console-based Java application that calculates sales taxes for various items based on their category and whether they are imported.

#### OOPS Concepts Implemented

1. Encapsulation:
Data and methods are encapsulated within classes, providing controlled access through getter methods.
Example:
The Item class encapsulates details such as name, price, imported, and category.
These fields are private and accessed using public getters @Getter.
Classes like TaxCalculator encapsulate tax-related logic, hiding implementation details.

2. Abstraction:
The TaxCalculator class abstracts the tax calculation logic, hiding implementation details like the tax rates and rounding mechanism.
The Receipt class abstracts the receipt structure and operations to manage item entries, total taxes, and amounts.

3. Composition:
The application uses composition to build complex objects:
The Receipt class is composed of a list of ReceiptItem objects, where each ReceiptItem represents an Item and its associated tax.
ReceiptGenerator uses TaxCalculator to calculate taxes for each item in a given list.

4. Polymorphism:
Method Overriding:
The toString() method in the Receipt class overrides the default toString() method of the Object class to provide a customized string representation of the receipt.
