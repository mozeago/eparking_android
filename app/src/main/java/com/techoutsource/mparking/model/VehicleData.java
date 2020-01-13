package com.techoutsource.mparking.model;

public class VehicleData {
    String _id;
    String number_plate;
    String vehicle_type;

    public VehicleData() {
    }

    public VehicleData(String _id, String number_plate, String vehicle_type) {
        this._id = _id;
        this.number_plate = number_plate;
        this.vehicle_type = vehicle_type;
    }

    public String get_id() {
        return _id;
    }

    public String getNumber_plate() {
        return number_plate;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setNumber_plate(String number_plate) {
        this.number_plate = number_plate;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }
}
