package com.tothenew.intellimeet.repository;


import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tothenew.intellimeet.domain.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {

	List<Topic> findAll();
	
	List<Topic> findAll(Sort sort);

	Topic findByName(String name);

	Topic findById(Long id);

	List<Topic> findByOwner(String owner);

	@Query("select t.name from Topic as t")
	List<String> listOfTopicNames();
}
