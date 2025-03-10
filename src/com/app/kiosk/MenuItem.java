package com.app.kiosk;

public class MenuItem{

    private final String name;
    private final double price;
    private final String description;
    private final Category category;

    public MenuItem(String name, double price, String description,Category category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;

    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return
                 name + "\t |" +
                "  $ " + price + "  | "+
                 description + '\t';
    }
}
