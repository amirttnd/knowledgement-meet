package com.tothenew.intellimeet.repository;

import com.tothenew.intellimeet.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u where u.username=?1 and u.password=?2")
    User findByUsernameAndPassword(String username, String password);
}
