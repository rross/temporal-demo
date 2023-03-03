package com.rickross.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class WaitlistUser {
    private @Id String email;
    private String firstName;
    private String lastName;
    private String leadSource;
    private boolean registered;
    private String inviteCode;

    WaitlistUser() {}

    public WaitlistUser(String email, String firstName, String lastName, String leadSource) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.leadSource = leadSource;
        this.registered = false;
        this.inviteCode = "";
    }

    public String getId() {
        return this.email;
    }

    public void setId(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getLeadSource() {
        return this.leadSource;
    }

    public boolean isRegistered() {
        return this.registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof WaitlistUser))
            return false;
        WaitlistUser user = (WaitlistUser) o;
        return Objects.equals(this.email, user.email) &&
                Objects.equals(this.firstName, user.firstName) &&
                Objects.equals(this.lastName, user.lastName) &&
                Objects.equals(this.leadSource, user.leadSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.email, this.firstName, this.lastName, this.leadSource);
    }

    @Override
    public String toString() {
        return "WaitListUser{" + "email=" + this.email +
                ", firstName=" + this.firstName +
                ", lastName=" + this.lastName +
                ", leadSource=" + this.leadSource +
                ", registered=" + this.registered +
                ", inviteCode=" + this.inviteCode +
                '}';
    }

}
