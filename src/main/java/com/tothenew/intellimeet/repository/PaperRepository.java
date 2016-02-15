package com.tothenew.intellimeet.repository;

import com.tothenew.intellimeet.domain.Paper;
import com.tothenew.intellimeet.domain.Topic;
import org.jboss.logging.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaperRepository extends CrudRepository<Paper, Long> {

    Page<Paper> findAll(Pageable pageable);

    List<Paper> findAll(Sort sort);

    Paper findById(Long id);

    List<Paper> findByGivenBy(String givenBy);

    List<Paper> findByTopic(Topic topic);

    @Query("SELECT p FROM Paper p JOIN p.topic t ON t.name LIKE %?1%")
    Page<Paper> findAllByTopicName( String name, Pageable pageable);

}
