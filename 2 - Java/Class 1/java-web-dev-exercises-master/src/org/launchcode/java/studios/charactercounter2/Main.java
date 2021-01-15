package org.launchcode.java.studios.charactercounter2;

import java.util.HashMap;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        var sentence = "Prow scuttle parrel provost Sail ho shrouds spirits boom mizzenmast yardarm. Pinnace holystone mizzenmast quarter crow's nest nipperkin grog yardarm hempen halter furl. Swab barque interloper chantey doubloon starboard grog black jack gangway rutters.";

        HashMap<Character, Integer> map = new HashMap<>();

        sentence = sentence.toLowerCase();

        for(var character : sentence.toCharArray()) {
            map.merge(character, 1, Integer::sum);
        }

        for (var entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
