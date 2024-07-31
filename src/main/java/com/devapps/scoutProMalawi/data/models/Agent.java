package com.devapps.scoutProMalawi.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.sql.Blob;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Agent implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agent_id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String email;

    @Column
    private String phone_no;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String date_joined;

    @Column(nullable = true)
    private Blob agent_picture;


    public Long getAgent_id() {
        return agent_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(username));
    }

    public String getPassword() {
        return password;
    }

    public Blob getAgent_picture() {
        return agent_picture;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public String getDate_joined() {
        return date_joined;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setAgent_picture(Blob agent_picture) {
        this.agent_picture = agent_picture;
    }

    public void setDate_joined(String date_joined) {
        this.date_joined = date_joined;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
