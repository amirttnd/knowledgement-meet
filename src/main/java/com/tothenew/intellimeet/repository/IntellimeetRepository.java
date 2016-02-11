package com.tothenew.intellimeet.repository;

import com.tothenew.intellimeet.domain.Intellimeet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface IntellimeetRepository extends JpaRepository<Intellimeet, Long> {
	List<Intellimeet> findAll();

	Intellimeet findById(Long id);

	Intellimeet findByIntellimeetDate(Timestamp intellimeetDate);

	@Query(value = "SELECT * FROM intellimeet order by intellimeet_date desc limit 1", nativeQuery = true)
	Intellimeet getLastIntellimeet();
}
