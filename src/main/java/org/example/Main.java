package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        AddressBook book = new AddressBook();

        book.addBuddy("Homer", "1234567890");
        book.addBuddy("Marge", "0987654321");

        System.out.println("Printing BuddyInfo");
        BuddyInfo buddy = book.getBuddy("Homer", "1234567890");
        System.out.println(buddy.getName());
        System.out.println(buddy.getPhoneNumber());
        System.out.println();
        buddy = book.getBuddy("Marge", "0987654321");
        System.out.println(buddy.getName());
        System.out.println(buddy.getPhoneNumber());
        System.out.println();

        System.out.println("Printing BuddyList");
        System.out.println(book.getBuddyList());
    }
}
