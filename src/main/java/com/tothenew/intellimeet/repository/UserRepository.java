package com.tothenew.intellimeet.repository;

import com.tothenew.intellimeet.domain.User;
import com.tothenew.intellimeet.enums.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u where u.username=?1 and u.password=?2")
    User findByUsernameAndPassword(String username, String password);

    User findById(Long id);

    @Query("SELECT COUNT(u) FROM User u where u.role=?1")
    long countByRole(Role role);
}
