package com.example.coleta_logsup.models;

public class Airport {
    private int id;
    private String initials, uf;

    public Airport() {
    }

    public Airport(String initials, String uf) {
        this.initials = initials;
        this.uf = uf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}
