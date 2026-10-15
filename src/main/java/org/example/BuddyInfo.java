package org.example;

// Design decisions may be somewhat basic; TA said that the methods and stuff didn't really matter,
// as this is more about using Maven tooling and stuff.

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String phoneNumber;

    protected BuddyInfo() {

    }

    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Long getId() {
        return this.id;
    }

    public void setName(String name) { // Setters are for best practice
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("BuddyInfo[id=%d, name='%s', phoneNumber='%s'", id, name, phoneNumber);
    }
}
