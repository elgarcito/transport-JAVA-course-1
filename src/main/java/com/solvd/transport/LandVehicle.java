package com.solvd.transport;

import com.solvd.transport.enums.Roads;

import java.util.ArrayList;
import java.util.List;

/** Abstract class representing a generic land vehicle that is kind of
 * a vehicle in the Transport hierarchy.
 * This class encapsulates common properties and behaviors shared by
 * all kind of land vehicles.
 */
abstract class LandVehicle extends Vehicle {
    protected int wheels;                       // Wheels of the land vehicle
    private List<Roads> suitableTerrain;  // List of suitable terrain for the land vehicle
    // Default constructor
    public LandVehicle() {
        super();
        this.wheels = 4;
        this.suitableTerrain = new ArrayList<>();
    }
    // Custom constructor
    public LandVehicle(String model, int year, String propulsion,
                       int wheels, List<Roads> suitableTerrain) {
        super(model, year, propulsion);
        this.wheels = wheels;
        this.suitableTerrain = new ArrayList<>();
        this.setSuitableTerrain(suitableTerrain);
    }
    // Getters and setters
    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) throws InvalidValueException {
        if (wheels < 1) {
            throw new InvalidValueException("The value of wheels is invalid.");
        }
        else {
            this.wheels = wheels;
        }
    }

    public ArrayList<Roads> getSuitableTerrain() {
        return new ArrayList<>(this.suitableTerrain);
    }

    public void setSuitableTerrain(List<Roads>  suitableTerrain) {
        for (Roads r : Roads.values()) {
            this.suitableTerrain.add(r);
        }
    }

    public String getModel() {
        return super.getModel();
    }

    public void setModel(String model) {
        super.setModel(model);
    }

    public int getYear() {
        return super.getYear();
    }

    public void setYear(int year) {
        super.setYear(year);
    }

    public String getPropulsion() {
        return super.getPropulsion();
    }

    public void setPropulsion(String propulsion) {
        super.setPropulsion(propulsion);
    }

    public abstract void startUp();
    public Roads.RoadCondition getRoadConditionByNumber(int roadNumber) {
        return this.suitableTerrain.get(roadNumber).getRoadCondition();
    }
}
