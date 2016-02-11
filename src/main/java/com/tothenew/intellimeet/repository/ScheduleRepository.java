package com.tothenew.intellimeet.repository;

import com.tothenew.intellimeet.domain.Schedule;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
	List<Schedule> findAll();

	Schedule findById(Long id);
}
