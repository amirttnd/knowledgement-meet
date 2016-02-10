package com.tothenew.intellimeet.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tothenew.intellimeet.IntellimeetRestApiApplication;
import com.tothenew.intellimeet.domain.Schedule;
import com.tothenew.intellimeet.model.ScheduleModel;
import com.tothenew.intellimeet.repository.ScheduleRepository;
import com.tothenew.intellimeet.service.ScheduleService;
import com.tothenew.intellimeet.vo.ScheduleVO;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	static Logger log = Logger.getLogger(ScheduleController.class.getName());

	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Schedule> show(@PathVariable("id") Long id) {
		return new ResponseEntity<Schedule>(scheduleService.findById(id),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Schedule>> list() {
		return new ResponseEntity<List<Schedule>>(scheduleService.findAll(),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Schedule> update(@PathVariable("id") Long id,
			@RequestBody ScheduleModel scheduleModel) {
		return new ResponseEntity<Schedule>(scheduleService.update(id,
				scheduleModel), HttpStatus.OK);
	}

	@RequestMapping(value = "/fullDaySchedule", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScheduleVO> fullDaySchedule() {
		return new ResponseEntity<ScheduleVO>(scheduleService.fullDaySchedule(), HttpStatus.OK);
	}
	

	@Autowired
	ScheduleService scheduleService;

}
