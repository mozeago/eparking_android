package com.techoutsource.mparking.model;

public class ReportAccidentModel {
    String accident_id;
    String accident_vehicle_number_plate_1;
    String accident_vehicle_number_plate_2;
    String accident_location_radius;
    String accident_exact_location;
    String accident_reporter;
    String accident_cause;


    public ReportAccidentModel() {
    }

    public ReportAccidentModel(String accident_id, String accident_vehicle_number_plate_1, String accident_vehicle_number_plate_2, String accident_location_radius, String accident_exact_location, String accident_reporter, String accident_cause) {
        this.accident_id = accident_id;
        this.accident_vehicle_number_plate_1 = accident_vehicle_number_plate_1;
        this.accident_vehicle_number_plate_2 = accident_vehicle_number_plate_2;
        this.accident_location_radius = accident_location_radius;
        this.accident_exact_location = accident_exact_location;
        this.accident_reporter = accident_reporter;
        this.accident_cause = accident_cause;
    }

    public String getAccident_id() {
        return accident_id;
    }

    public void setAccident_id(String accident_id) {
        this.accident_id = accident_id;
    }

    public String getAccident_vehicle_number_plate_1() {
        return accident_vehicle_number_plate_1;
    }

    public void setAccident_vehicle_number_plate_1(String accident_vehicle_number_plate_1) {
        this.accident_vehicle_number_plate_1 = accident_vehicle_number_plate_1;
    }

    public String getAccident_vehicle_number_plate_2() {
        return accident_vehicle_number_plate_2;
    }

    public void setAccident_vehicle_number_plate_2(String accident_vehicle_number_plate_2) {
        this.accident_vehicle_number_plate_2 = accident_vehicle_number_plate_2;
    }

    public String getAccident_location_radius() {
        return accident_location_radius;
    }

    public void setAccident_location_radius(String accident_location_radius) {
        this.accident_location_radius = accident_location_radius;
    }

    public String getAccident_exact_location() {
        return accident_exact_location;
    }

    public void setAccident_exact_location(String accident_exact_location) {
        this.accident_exact_location = accident_exact_location;
    }

    public String getAccident_reporter() {
        return accident_reporter;
    }

    public void setAccident_reporter(String accident_reporter) {
        this.accident_reporter = accident_reporter;
    }

    public String getAccident_cause() {
        return accident_cause;
    }

    public void setAccident_cause(String accident_cause) {
        this.accident_cause = accident_cause;
    }
}
