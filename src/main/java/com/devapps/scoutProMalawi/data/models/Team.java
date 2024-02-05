package com.devapps.scoutProMalawi.data.models;

import jakarta.persistence.*;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String team_id;

    @Column
    private String team_name;

    @Column
    private String location;

    @Column
    private String email;

    @Column
    private String phone_no;

    @Column
    private String password;

    @Column
    private String date_joined;

    @Column
    private String team_picture;

    public String getTeam_id() {
        return team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public String getPassword() {
        return password;
    }

    public String getDate_joined() {
        return date_joined;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam_picture() {
        return team_picture;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public void setTeam_picture(String team_picture) {
        this.team_picture = team_picture;
    }

    public void setDate_joined(String date_joined) {
        this.date_joined = date_joined;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }
}
