package com.example.gdscapp;

public class userhelper {String name,phone,email,domain,year;

    public userhelper(String name) {
        this.name = name;
    }

    public userhelper(String phone, String name, String year, String domain, String email) {

        this.phone = phone;
        this.name=name;
        this.email = email;
        this.domain=domain;
        this.year = year;


    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
