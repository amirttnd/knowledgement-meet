package com.tothenew.intellimeet.repository;


import com.tothenew.intellimeet.domain.Paper;
import com.tothenew.intellimeet.domain.Session;
import com.tothenew.intellimeet.domain.Topic;
import com.tothenew.intellimeet.enums.SessionStat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SessionRepository extends CrudRepository<Session, Long> {


    @Query("select s from Session s")
    Page<Session> all(Pageable pageable);

    @Query("select s from Session s where s.sessionStat=?1")
    Page<Session> findAllBySessionStat(SessionStat sessionStat, Pageable pageable);


    Page<Session> findAll(Pageable pageable);

    Session findById(Long id);


    @Query("select count(s) from Session s where s.sessionStat=?1")
    Long countBySessionStat(SessionStat sessionStat);

    @Modifying
    @Query("UPDATE Session s set s.isAddedInIntellimeet=false,s.sessionStat=?1")

    @Transactional(readOnly = false)
    int expireAllAddedIntellimeetSessions(SessionStat sessionStat);


    @Query("SELECT s FROM Session s where s.paper.topic.name LIKE %?1%")
    Page<Session> findAllByTopicName(String name, Pageable pageable);

}
