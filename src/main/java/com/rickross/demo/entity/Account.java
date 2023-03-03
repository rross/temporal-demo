package com.rickross.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Account {
    private @Id String email;
    private String firstName;
    private String lastName;
    private String leadSource;

    public Account() {
    }

    public Account(String email, String firstName, String lastName, String leadSource) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.leadSource = leadSource;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Account account = (Account) o;
        return email.equals(account.email) &&
                firstName.equals(account.firstName) &&
                lastName.equals(account.lastName) &&
                leadSource.equals(account.leadSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName, leadSource);
    }

    @Override
    public String toString() {
        return "Account{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", leadSource='" + leadSource + '\'' +
                '}';
    }
}
