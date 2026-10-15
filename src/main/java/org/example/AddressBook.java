package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

// Design decisions may be somewhat basic; TA said that the methods and stuff didn't really matter,
// as this is more about using Maven tooling and stuff.

@Entity
public class AddressBook {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany
    private List<BuddyInfo> buddyList;

    public AddressBook() {
        buddyList = new ArrayList<BuddyInfo>();
    }

    public boolean addBuddy(String name, String phoneNumber) {
        BuddyInfo buddy = new BuddyInfo(name, phoneNumber);
        for (int i = 0; i < buddyList.size(); i++) { // Ensure no duplicates
            BuddyInfo currBuddy = buddyList.get(i);
            if (buddy.getName().equals(currBuddy.getName()) && buddy.getPhoneNumber().equals(currBuddy.getPhoneNumber())) {
                return false; // Failure
            }
        }

        // Buddy not yet in the book
        buddyList.add(new BuddyInfo(name, phoneNumber));
        return true; // Success
    }

    public BuddyInfo getBuddy(String name, String phoneNumber) {
        for (int i = 0; i < buddyList.size(); i++) {
            BuddyInfo buddy = buddyList.get(i);
            if (buddy.getName().equals(name) && buddy.getPhoneNumber().equals(phoneNumber)) {
                return buddy;
            }
        }
        return null; // Buddy not found.
    }

    public List<BuddyInfo> getBuddyList() {
        return buddyList;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}