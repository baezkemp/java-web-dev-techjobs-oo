package org.launchcode.techjobs_oo;

import java.util.ArrayList;

public class Job {

    private int id;
    private static int nextId = 1;
    private static String emptyVariable = "Data not available";

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // DONE* TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public String toString() {

        ArrayList<String> jobInfoArray = new ArrayList<>();

        jobInfoArray.add(Integer.toString(id));
        jobInfoArray.add(name);
        jobInfoArray.add(employer.toString());
        jobInfoArray.add(location.toString());
        jobInfoArray.add(positionType.toString());
        jobInfoArray.add(coreCompetency.toString());

        for(int i = 0; i<jobInfoArray.size();i++){
            if (jobInfoArray.get(i).equals("")) {
                jobInfoArray.set(i, emptyVariable);
            }
        }

//        Is there is a better way to do this next part...
        if(jobInfoArray.get(1).equals(emptyVariable)&&
                jobInfoArray.get(2).equals(emptyVariable)&&
                jobInfoArray.get(3).equals(emptyVariable) &&
                jobInfoArray.get(4).equals(emptyVariable) &&
                jobInfoArray.get(5).equals(emptyVariable)){
            return "OOPS! This job does not seem to exist.";
        } else {
            String htmlarray = "" +
                    "\nID: " + jobInfoArray.get(0) +
                    "\nName: " + jobInfoArray.get(1) +
                    "\nEmployer: " + jobInfoArray.get(2) +
                    "\nLocation: " + jobInfoArray.get(3) +
                    "\nPosition type: " + jobInfoArray.get(4) +
                    "\nCore Competency: " + jobInfoArray.get(5) +
                    "";

            return htmlarray;
        }
    }


    // DONE* TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
