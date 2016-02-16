package com.tothenew.intellimeet.repository;


import com.tothenew.intellimeet.domain.Topic;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {

    List<Topic> findAll();

    @Query("SELECT t from Topic t")
    List<Topic> all(Pageable pageable);

    @Query("SELECT t from Topic t WHERE t.name LIKE %?1%")
    List<Topic> findByNamelike(String name);

    Topic findByName(String name);

    Topic findById(Long id);

    List<Topic> findByOwner(String owner);

    @Query("select t.name from Topic as t")
    List<String> listOfTopicNames();
}
