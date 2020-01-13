package com.techoutsource.mparking.model;

public class BadlyTreated {
    String id;
    String who_mistreated_you;
    String mistreat_description;

    public BadlyTreated(String id, String who_mistreated_you, String mistreat_description) {
        this.id = id;
        this.who_mistreated_you = who_mistreated_you;
        this.mistreat_description = mistreat_description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWho_mistreated_you() {
        return who_mistreated_you;
    }

    public void setWho_mistreated_you(String who_mistreated_you) {
        this.who_mistreated_you = who_mistreated_you;
    }

    public String getMistreat_description() {
        return mistreat_description;
    }

    public void setMistreat_description(String mistreat_description) {
        this.mistreat_description = mistreat_description;
    }
}
