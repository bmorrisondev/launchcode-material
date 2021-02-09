package org.launchcode.java.studios.restaurant;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Restaurant {
    public static void main(String[] args) {
        var item1 = new MenuItem("Steak",
                "Chupa chups tart tootsie roll gingerbread danish pudding candy canes.",
                "Dinner",
                10.99,
                false);
        var item2 = new MenuItem("Chickenz",
                "Tootsie roll sesame snaps candy canes jelly beans tart muffin tart donut.",
                "Dinner",
                6.99,
                false);
        var item3 = new MenuItem("Omnom cake",
                "Chocolate cake sweet roll biscuit biscuit chocolate bar jujubes danish.",
                "Dessert",
                36.99,
                true);
        var item4 = new MenuItem("Chickenz",
                "Tootsie roll sesame snaps candy canes jelly beans tart muffin tart donut.",
                "Dinner",
                6.99,
                false);

        Date today = Calendar.getInstance().getTime();
        ArrayList<MenuItem> startingMenu = new ArrayList<>();

        Menu ourMenu = new Menu(today, startingMenu);

        ourMenu.addMenuItem(item1);
//        ourMenu.addMenuItem(item2);
        ourMenu.addMenuItem(item3);

        var lastUpdatedBefore = ourMenu.getLastUpdated();

        ourMenu.removeMenuItem(item2);

        var lastUpdatedAfter = ourMenu.getLastUpdated();


        ourMenu.printMenu();

//        ourMenu.printMenuItem(item2);


//
//        ourMenu.addMenuItem(item1);
//        ourMenu.addMenuItem(item2);
//        ourMenu.addMenuItem(item3);
//
//        ourMenu.printMenu();
//        ourMenu.printMenuItem(item2);
//        ourMenu.removeMenuItem(item2);
//
//        ourMenu.printMenu();
    }
}
