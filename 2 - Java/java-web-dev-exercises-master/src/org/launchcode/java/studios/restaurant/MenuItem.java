package org.launchcode.java.studios.restaurant;

import java.util.Objects;

public class MenuItem {
    // price, desc, category, name
    private String name;
    private String description;
    private String category;
    private double price;
    private boolean isNew;

    public MenuItem(String name, String description, String category, double price, boolean isNew) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.isNew = isNew;
    }

    public boolean getIsNew() {
        return this.isNew;
    }

    @Override
    public String toString() {
        var returnString = "** " + name;
        if(isNew) {
            returnString += " (New!)";
        }
        returnString += " **\n" +
                description + "\n" +
                "Category: " + category + "\n" +
                "Price: $" + price;
        return returnString;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuItem)) return false;
        MenuItem menuItem = (MenuItem) o;
        return Double.compare(menuItem.price, price) == 0 && isNew == menuItem.isNew && name.equals(menuItem.name) && description.equals(menuItem.description) && category.equals(menuItem.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, category, price, isNew);
    }
}
