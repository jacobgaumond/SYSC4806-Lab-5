package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuddyInfoTest {
    private BuddyInfo buddy;

    @BeforeEach
    void setUp() {
        buddy = new BuddyInfo("Maggie", "1231231234");
    }

    @Test
    void getName() {
        assertEquals("Maggie", buddy.getName());
    }

    @Test
    void getPhoneNumber() {
        assertEquals("1231231234", buddy.getPhoneNumber());
    }
}