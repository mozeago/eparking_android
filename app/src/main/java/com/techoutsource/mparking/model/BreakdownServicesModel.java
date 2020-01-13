package com.techoutsource.mparking.model;

public class BreakdownServicesModel {
    String id;
    String vehicle_number_plate;
    String location_radius;
    String exact_location;
    String mobile_number;
    String vehicle_type;

    public BreakdownServicesModel(String id, String vehicle_number_plate, String location_radius, String exact_location, String mobile_number, String vehicle_type) {
        this.id = id;
        this.vehicle_number_plate = vehicle_number_plate;
        this.location_radius = location_radius;
        this.exact_location = exact_location;
        this.mobile_number = mobile_number;
        this.vehicle_type = vehicle_type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicle_number_plate() {
        return vehicle_number_plate;
    }

    public void setVehicle_number_plate(String vehicle_number_plate) {
        this.vehicle_number_plate = vehicle_number_plate;
    }

    public String getLocation_radius() {
        return location_radius;
    }

    public void setLocation_radius(String location_radius) {
        this.location_radius = location_radius;
    }

    public String getExact_location() {
        return exact_location;
    }

    public void setExact_location(String exact_location) {
        this.exact_location = exact_location;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }
}
