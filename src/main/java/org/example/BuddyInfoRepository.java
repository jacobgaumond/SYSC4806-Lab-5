package org.example;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    List<BuddyInfo> findByName(String name);

    Optional<BuddyInfo> findById(Long id);
}
