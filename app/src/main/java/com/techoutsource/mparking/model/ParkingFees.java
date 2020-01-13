package com.techoutsource.mparking.model;

public class ParkingFees {
    String id, phone_number, numberplate;

    public ParkingFees() {
    }

    public ParkingFees(String id, String phone_number, String numberplate) {
        this.id = id;
        this.phone_number = phone_number;
        this.numberplate = numberplate;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
