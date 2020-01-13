package com.techoutsource.mparking.model;

public class PayCountyFines {
    String id, mpesa_phone_number, numberplate, offence_number;

    public PayCountyFines() {
    }

    public PayCountyFines(String id, String mpesa_phone_number, String numberplate, String offence_number) {
        this.id = id;
        this.mpesa_phone_number = mpesa_phone_number;
        this.numberplate = numberplate;
        this.offence_number = offence_number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMpesa_phone_number() {
        return mpesa_phone_number;
    }

    public void setMpesa_phone_number(String mpesa_phone_number) {
        this.mpesa_phone_number = mpesa_phone_number;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public String getOffence_number() {
        return offence_number;
    }

    public void setOffence_number(String offence_number) {
        this.offence_number = offence_number;
    }
}
