package org.launchcode.studio7;

public class Main {

    public static void main(String[] args){
        DVD myDvd = new DVD("2001 A Space Odyssey!",
                "Hard to say its about anything, are you saying you haven't seen it?",
                true,
                false);

//        myDvd.spinDisc();
        myDvd.write("Trumpet sounds!");
        myDvd.read();
    }
}
