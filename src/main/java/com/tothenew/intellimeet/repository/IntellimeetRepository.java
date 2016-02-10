package com.tothenew.intellimeet.repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tothenew.intellimeet.domain.Intellimeet;

public interface IntellimeetRepository extends JpaRepository<Intellimeet, Long> {
	List<Intellimeet> findAll();

	Intellimeet findById(Long id);

	Intellimeet findByIntellimeetDate(Timestamp intellimeetDate);

	@Query(value = "SELECT * FROM intellimeet order by intellimeet_date desc limit 1", nativeQuery = true)
	Intellimeet getLastIntellimeet();
}
