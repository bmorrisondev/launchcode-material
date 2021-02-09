package org.launchcode.studio7;

public class DVD extends BaseDisc implements OpticalDisc {

    public DVD(String name, String contents, Boolean isRewritable, Boolean isFileBasedDisc) {
        this.capacityInMB = 4700;
        this.discType = DiscType.Dvd;

        this.name = name;
        this.contents = contents;
        this.isRewritable = isRewritable;
        this.isFileBasedDisc = isFileBasedDisc;
    }

    @Override
    public void spinDisc() {
        System.out.println("A DVD spins at a rate of 570 - 1600 rpm.");
    }
}
