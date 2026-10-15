package org.example;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {
    private AddressBook book;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        book = new AddressBook();

        book.addBuddy("Bart", "1234567890");
        book.addBuddy("Lisa", "0987654321");
    }

    @org.junit.jupiter.api.Test
    void getBuddy() {
        BuddyInfo buddy = book.getBuddy("Bart", "1234567890");

        assertEquals("Bart", buddy.getName());
        assertEquals( "1234567890", buddy.getPhoneNumber());
    }

    @org.junit.jupiter.api.Test
    void addBuddy() { // Requires a functioning AddressBook.getBuddy()
        BuddyInfo buddy = new BuddyInfo("Maggie", "1231231234");
        book.addBuddy(buddy.getName(), buddy.getPhoneNumber());

        BuddyInfo retrievedBuddy = book.getBuddy(buddy.getName(), buddy.getPhoneNumber());
        assertEquals(buddy.getName(), retrievedBuddy.getName());
        assertEquals(buddy.getPhoneNumber(), retrievedBuddy.getPhoneNumber());
    }

    @org.junit.jupiter.api.Test
    void getBuddyList() {
        ArrayList<BuddyInfo> list = book.getBuddyList();

        BuddyInfo buddy1 = list.get(0);
        BuddyInfo buddy2 = list.get(1);

        // Ensure different buddies
        assertNotEquals(buddy1.getName(), buddy2.getName());
        assertNotEquals(buddy1.getPhoneNumber(), buddy2.getPhoneNumber());

        // Ensure correct (regardless of which is which)
        assertTrue(buddy1.getName().equals("Bart") || buddy1.getName().equals("Lisa"));
        assertTrue(buddy2.getName().equals("Bart") || buddy2.getName().equals("Lisa"));
        assertTrue(buddy1.getPhoneNumber().equals("1234567890") || buddy1.getPhoneNumber().equals("0987654321"));
        assertTrue(buddy2.getPhoneNumber().equals("1234567890") || buddy2.getPhoneNumber().equals("0987654321"));

        // Ensure no other buddies in the list
        assertEquals(2, list.size());
    }
}