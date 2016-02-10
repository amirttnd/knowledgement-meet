package com.tothenew.intellimeet.repository;

import com.tothenew.intellimeet.domain.Paper;
import com.tothenew.intellimeet.domain.Topic;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaperRepository extends CrudRepository<Paper, Long> {

    List<Paper> findAll(Pageable pageable);

    List<Paper> findAll(Sort sort);

    Paper findById(Long id);

    List<Paper> findByGivenBy(String givenBy);

    List<Paper> findByTopic(Topic topic);

}
