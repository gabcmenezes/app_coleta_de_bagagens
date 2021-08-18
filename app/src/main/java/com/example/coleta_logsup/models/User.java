package com.example.coleta_logsup.models;

import java.io.Serializable;

public class User implements Serializable {

    private Integer id;
    private String name;
    private String surname;
    private String password;
    private int role;
    private long phone;
    private long CPF;
    private boolean admin;

    public User() {
    }

    public User(String name, String surname, long CPF, String password, long phone, int role, boolean admin) {
        this.name = name;
        this.CPF = CPF;
        this.surname = surname;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullName(){
        return String.format("%s %s", name, surname);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
