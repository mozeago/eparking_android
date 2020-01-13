package com.techoutsource.mparking.model;

public class ReportTrafficJam {
    String id, locationname, causedby;

    public ReportTrafficJam() {
    }

    public ReportTrafficJam(String id, String location_name, String caused_by) {
        this.id = id;
        this.locationname = location_name;
        this.causedby = caused_by;
    }

    public String getId() {
        return id;
    }

    public String getLocationname() {
        return locationname;
    }

    public String getCausedby() {
        return causedby;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocationname(String locationname) {
        this.locationname = locationname;
    }

    public void setCausedby(String causedby) {
        this.causedby = causedby;
    }
}
