package com.tothenew.intellimeet.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.tothenew.intellimeet.constants.IntellimeetConstants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tothenew.intellimeet.domain.Intellimeet;
import com.tothenew.intellimeet.domain.Schedule;
import com.tothenew.intellimeet.domain.Session;
import com.tothenew.intellimeet.model.ScheduleModel;
import com.tothenew.intellimeet.repository.IntellimeetRepository;
import com.tothenew.intellimeet.repository.ScheduleRepository;
import com.tothenew.intellimeet.vo.ScheduleVO;

@Service
public class ScheduleService {
    Logger log = Logger.getLogger(ScheduleService.class.getName());

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public Schedule findById(Long id) {
        return scheduleRepository.findOne(id);
    }

    public Schedule save(ScheduleModel scheduleModel) {
        Schedule schedule = new Schedule(scheduleModel);
        scheduleRepository.save(schedule);
        return schedule;
    }

    public Schedule update(Long id, ScheduleModel scheduleModel) {
        Schedule schedule = findById(id);
        schedule.setSchedule(scheduleModel);
        scheduleRepository.save(schedule);
        return schedule;
    }

    public ScheduleVO fullDaySchedule() {
        Intellimeet intellimeet = intellimeetRepository.getLastIntellimeet();
        if (intellimeet != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                    IntellimeetConstants.INTELLIMEET_DISPLAY_DATE_FORMAT);
            ScheduleVO scheduleVO = new ScheduleVO();
            scheduleVO.setIntellimeetDay(simpleDateFormat.format(intellimeet
                    .getIntellimeetDateInstance()));
            Set<String> lunch = new TreeSet<String>();

            Schedule commonSchedule = intellimeet.getSessions().get(0)
                    .getSchedule();
            for (Session session : intellimeet.getSessions()) {
                lunch.add(session.getSchedule().getLunch());
            }
            scheduleVO.setBreakFast(commonSchedule.getBreakFast());
            scheduleVO.setSessionCommencement(commonSchedule
                    .getSessionCommencement());
            scheduleVO.setLunch(lunch);
            scheduleVO.setDiscussionAndFeedback(commonSchedule
                    .getDiscussionAndFeedback());
            scheduleVO.setWrapUp(commonSchedule.getWrapUp());
            return scheduleVO;
        }
        return null;
    }

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    IntellimeetRepository intellimeetRepository;

}
