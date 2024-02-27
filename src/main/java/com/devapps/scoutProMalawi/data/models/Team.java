package com.devapps.scoutProMalawi.data.models;

import jakarta.persistence.*;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teamId;

    @Column
    String teamname;

    @Column
    String email;

    @Column
    String location;

    @Column
    String contact;

    @Column
    String password;

    @Column
    String profilepicture;

    @Column
    String date_joined;

    public String getTeamname() {
        return teamname;
    }

    public String getLocation() {
        return location;
    }

    public String getContact() {
        return contact;
    }

    public long getTeamId() {
        return teamId;
    }

    public String getDate_joined() {
        return date_joined;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getProfilepicture() {
        return profilepicture;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setDate_joined(String date_joined) {
        this.date_joined = date_joined;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfilepicture(String profilepicture) {
        this.profilepicture = profilepicture;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }
};