package org.launchcode.techjobs.console;

public class Position {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String employer;

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(String coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    private String location;
    private String positionType;
    private String coreCompetency;
    private String name;

    public Position(String name, String employer, String location, String positionType, String coreCompetency) {
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    public boolean anyFieldsContainSearchTerm(String term) {
        term = term.toLowerCase();
        return name.toLowerCase().contains(term) ||
                employer.toLowerCase().contains(term) ||
                location.toLowerCase().contains(term) ||
                positionType.toLowerCase().contains(term) ||
                coreCompetency.toLowerCase().contains(term);
    }

    public boolean doesFieldContainSearchTerm(String fieldName, String search) {
        search = search.toLowerCase();
        if(fieldName == "core competency") {
            return coreCompetency.toLowerCase().contains(search);
        }
        if(fieldName == "employer") {
            return employer.toLowerCase().contains(search);
        }
        if(fieldName == "location") {
            return location.toLowerCase().contains(search);
        }
        if(fieldName == "position type") {
            return positionType.toLowerCase().contains(search);
        }
        if(fieldName == "all") {
            return anyFieldsContainSearchTerm(search);
        }
        return false;
    }

    @Override
    public String toString() {
        var returnString = "*****\n";
        returnString += "position type: " + positionType + "\n";
        returnString += "name: " + name + "\n";
        returnString += "employer: " + employer + "\n";
        returnString += "location: " + location + "\n";
        returnString += "core competency: " + coreCompetency + "\n";
        returnString += "*****";
        return returnString;
    }
}
