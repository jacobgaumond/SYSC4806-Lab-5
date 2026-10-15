package org.example;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "addressBook", collectionResourceRel = "addressBook")
public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
    Optional<AddressBook> findById(Long id);
}
