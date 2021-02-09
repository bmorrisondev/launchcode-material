package org.launchcode.java.studios.restaurant;

import java.util.ArrayList;
import java.util.Date;

public class Menu {
    private Date lastUpdated;
    private ArrayList<MenuItem> menuItems;

    public Menu(Date lastUpdated, ArrayList<MenuItem> menuItems) {
        this.lastUpdated = lastUpdated;
        this.menuItems = menuItems;
    }

    public Date getLastUpdated() {
        return this.lastUpdated;
    }

    public void addMenuItem(MenuItem item) {
        if (!menuItems.contains(item)) {
            menuItems.add(item);
            lastUpdated = new Date();
        } else {
            System.out.println("That item already exists on the menu!");
        }
    }

    public void removeMenuItem(MenuItem item) {
        if(menuItems.contains(item)) {
            menuItems.remove(item);
            lastUpdated = new Date();
        }
    }

    public void printMenu() {
        for(var item: menuItems) {
            printMenuItem(item);
            System.out.println();
        }
    }

    public void printMenuItem(MenuItem item) {
        if (menuItems.contains(item)) {
            System.out.println(item.toString());
        } else {
            System.out.println("That item is not on the menu!");
        }
    }
}
