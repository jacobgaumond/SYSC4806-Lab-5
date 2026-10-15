package org.example;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "buddyInfo", collectionResourceRel = "buddyInfo")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    List<BuddyInfo> findByName(String name);

    Optional<BuddyInfo> findById(Long id);
}
