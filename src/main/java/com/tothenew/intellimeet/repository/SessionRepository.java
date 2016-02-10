package com.tothenew.intellimeet.repository;


import java.util.List;

import com.tothenew.intellimeet.enums.SessionStat;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tothenew.intellimeet.domain.Paper;
import com.tothenew.intellimeet.domain.Session;
import com.tothenew.intellimeet.domain.Topic;

public interface SessionRepository extends CrudRepository<Session, Long> {

    List<Session> findAll();

    @Query("select s from Session s where s.sessionStat=?1")
    List<Session> findAllBySessionStat(SessionStat sessionStat);

    List<Session> findAll(Pageable pageable);

    Session findById(Long id);

    List<Session> findByTopic(Topic topic);

    List<Session> findByPaper(Paper paper);

    @Modifying
    @Query("UPDATE Session s set s.isAddedInIntellimeet=false,s.sessionStat=?1")

    @Transactional(readOnly = false)
    int expireAllAddedIntellimeetSessions(SessionStat sessionStat);

}
