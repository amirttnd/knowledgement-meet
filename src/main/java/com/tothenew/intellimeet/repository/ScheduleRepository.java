package com.tothenew.intellimeet.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tothenew.intellimeet.domain.Schedule;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
	List<Schedule> findAll();

	Schedule findById(Long id);
}
