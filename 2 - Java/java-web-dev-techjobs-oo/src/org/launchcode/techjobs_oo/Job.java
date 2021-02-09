package org.launchcode.techjobs_oo;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job(String name) {
        this.name = name;
    }

    public Job(String name, Employer employer) {
        this.name = name;
        this.employer = employer;
    }

    @Override
    public String toString() {
        String retval = "\n";
        if(this.name.equals("")) {
            retval += "Name: Data not available\n";
        } else {
            retval += "Name: " + this.name + "\n";
        }

        if(this.employer.toString().equals("")) {
            retval += "Employer: Data not available\n";
        }

        return retval;
    }



    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
}
