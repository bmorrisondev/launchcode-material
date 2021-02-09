package org.launchcode.java.studios.charactercounter;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        var sentence = "should be fine. It will update the value for the existing mapping. Note that this uses auto-boxing. With the help of map.get(key) we get the value of corresponding key, then you can update with your requirement. Here I am updating to increment value by 1.";
        HashMapApproach(sentence);
    }

    public static void HashMapApproach(String sentence) {
        // Create the hashmap
        HashMap<Character, Integer> map = new HashMap<>();

        // Loop over the characters in the sentence
        for (var character : sentence.toCharArray()) {
            // Check to see of the character is in the hashmap
            if(map.get(character) == null) {
                // If it is not, add it with a value of 1 since it is found in the sentence
                map.put(character, 1);
            } else {
                // If it is already in the map, bump the count
                var currentValue = map.get(character);
                map.put(character, currentValue + 1);
            }
        }

        // Loop over the map again and log out each entry
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void ArrayApproach(String sentence) {
        // Define a set of characters to check for
        var charArr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`~1!2@3#4$5%6^7&8*9(0)-_=+[{]}\\|;:'\",<.>/?".toCharArray();

        // Loop through our predefined list of characters
        for (var character : charArr) {
            // Set a variable to hold how many times that character is in our sentence
            var count = 0;
            // Iterate over the sentence to check for that character
            for (var sentenceChar : sentence.toCharArray()) {
                if(character == sentenceChar) {
                    count++;
                }
            }
            // If the sentence contains that character, log out the number of times its found
            if(count > 0) {
                System.out.println(character + ": " + count);
            }
        }
    }

    public static void ArrayListApproach(String sentence) {
        // Create an empty arraylist to hold the characters we find.
        ArrayList<Character> uniqueCharacters = new ArrayList<Character>();

        // Loop through the sentence once to find all possible characters
        for (var character : sentence.toCharArray()) {
            if(!uniqueCharacters.contains(character)) {
                uniqueCharacters.add(character);
            }
        }

        // Loop the unique characters array and find out how many times that character is found
        for (var character : uniqueCharacters) {
            var count = 0;
            // For that character, loop over the sentence to find out how many times its in there
            for(var sentenceChar : sentence.toCharArray()) {
                if(character == sentenceChar) {
                    count++;
                }
            }
            // Log out the character & times it is found
            System.out.println(character + ": " + count);
        }
    }
}
