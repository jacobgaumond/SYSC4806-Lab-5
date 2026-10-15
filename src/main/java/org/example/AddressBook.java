package org.example;

import java.util.ArrayList;

// Design decisions may be somewhat basic; TA said that the methods and stuff didn't really matter,
// as this is more about using Maven tooling and stuff.

public class AddressBook {
    private ArrayList<BuddyInfo> buddyList = new ArrayList<BuddyInfo>();

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

    public ArrayList<BuddyInfo> getBuddyList() {
        return buddyList;
    }
}