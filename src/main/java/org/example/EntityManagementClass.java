package org.example;

import jakarta.persistence.*;

import java.util.List;

public class EntityManagementClass {
    static void main() {
        EntityManagementClass emc = new EntityManagementClass();
        emc.performJPA();
    }

    public void performJPA() {
        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persisting-thing");

        EntityManager em = emf.createEntityManager();

        // *BuddyInfo Persistence*
        // Creating objects
        BuddyInfo buddy1 = new BuddyInfo("Homer", "1234567890");
        BuddyInfo buddy2 = new BuddyInfo("Marge", "0987654321");


        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(buddy1);
        em.persist(buddy2);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM BuddyInfo b");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results1 = q.getResultList();

        System.out.println("List of products\n----------------");

        for (BuddyInfo b : results1) {

            System.out.println("name=" + b.getName() + ", phoneNumber=" + b.getPhoneNumber() + "(id=" + b.getId() + ")");
        }

//        // *AddressBook Persistence*
//
//        AddressBook book = new AddressBook();
//        book.addBuddy("Bart", "1234567890");
//        book.addBuddy("Lisa", "0987654321");
//
//
//        // Creating a new transaction
//        tx = em.getTransaction();
//
//        tx.begin();
//
//        // Persisting the product entity objects
//        em.persist(book);
//
//        tx.commit();
//
//        // Querying the contents of the database using JPQL query
//        q = em.createQuery("SELECT a FROM AddressBook a");
//
//        @SuppressWarnings("unchecked")
//        List<AddressBook> results2 = q.getResultList();
//
//        System.out.println("List of products\n----------------");
//
//        for (AddressBook a : results2) {
//            System.out.println("AddressBook (" + a.getId() + "):");
//            for (BuddyInfo b : a.getBuddyList()) {
//                System.out.println("\tname=" + b.getName() + ", phoneNumber=" + b.getPhoneNumber() + "(id=" + b.getId() + ")");
//            }
//        }

        // Closing connection
        em.close();

        emf.close();
    }
}
