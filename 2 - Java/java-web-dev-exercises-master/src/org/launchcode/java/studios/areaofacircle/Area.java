package org.launchcode.java.studios.areaofacircle;

import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Area {
    public static void main (String[] args) {
        var scanner = new Scanner(System.in);
        var isInputValid = false;
        while(!isInputValid) {
            System.out.println("Enter a radius: ");
            var input = scanner.nextLine();
            try {
                double radius = 0;
                try {
                    radius = parseDouble(input);
                } catch (Exception exc) {
                    throw new Exception("You must enter a number...");
                }

                if(radius < 0) {
                    throw new Exception("Entered number must be positive...");
                }

                var area = Circle.getArea(radius);
                var output = "The area of a circle of radius ";
                output = output.concat(input).concat(" is: ").concat(String.valueOf(area));
                System.out.println(output);
                isInputValid = true;
            } catch (Exception exc) {
                System.out.println("Invalid input: " + exc.getMessage());
            }
        }
        scanner.close();
    }
}
