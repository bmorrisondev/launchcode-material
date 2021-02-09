package org.launchcode.studio7;

public abstract class BaseDisc {
    String name;
    Integer capacityInMB;
    String contents;
    DiscType discType;
    Boolean isRewritable;
    Boolean isFileBasedDisc;

    public void write(String contents) {
        // only if its rewritable
        if(!this.isRewritable) {
            System.out.println("Disc is not rewritable.");
            return;
        }
        // check length against capacity
        if(contents.length() > this.capacityInMB) {
            System.out.println("Content too large for this disc.");
            return;
        }
        this.contents = contents;
    }

    public void read() {
        System.out.println(this.contents);
    }
}
