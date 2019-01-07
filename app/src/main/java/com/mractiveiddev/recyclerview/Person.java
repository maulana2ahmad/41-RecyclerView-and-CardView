package com.mractiveiddev.recyclerview;

public class Person
{
    private String name;
    private String username;
    private String preference; //  this take the bus or the plane

    public Person(String name, String username, String preference) {
        this.name = name;
        this.username = username;
        this.preference = preference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
