package com.devapps.scoutProMalawi.data.models;

import jakarta.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Player_id;

    @Column
    String firstname;

    @Column
    String lastname;

    @Column
    String dob;

    @Column
    String picture;

    @Column
    String height;

    @Column
    String weight;

    @Column
    String position;

    @Column
    Long agent_id;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Long getAgent_id() {
        return agent_id;
    }

    public Long getPlayer_id() {
        return Player_id;
    }

    public String getDob() {
        return dob;
    }

    public String getHeight() {
        return height;
    }

    public String getPosition() {
        return position;
    }

    public String getWeight() {
        return weight;
    }
}
