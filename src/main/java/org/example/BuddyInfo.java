package org.example;

// Design decisions may be somewhat basic; TA said that the methods and stuff didn't really matter,
// as this is more about using Maven tooling and stuff.

public class BuddyInfo {
    private String name;
    private String phoneNumber;

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
}
