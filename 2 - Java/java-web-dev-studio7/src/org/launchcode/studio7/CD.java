package org.launchcode.studio7;

public class CD extends BaseDisc implements OpticalDisc {
    public CD(String name, String contents, Boolean isRewritable, Boolean isFileBasedDisc) {
        this.capacityInMB = 700;
        this.discType = DiscType.Cd;

        this.name = name;
        this.contents = contents;
        this.isRewritable = isRewritable;
        this.isFileBasedDisc = isFileBasedDisc;
    }

    @Override
    public void spinDisc() {
        System.out.println("A CD spins at a rate of 200 - 500 rpm.");
    }
}
