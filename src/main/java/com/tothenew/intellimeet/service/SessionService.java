package com.tothenew.intellimeet.service;

import com.tothenew.intellimeet.constants.IntellimeetConstants;
import com.tothenew.intellimeet.domain.*;
import com.tothenew.intellimeet.enums.SessionStat;
import com.tothenew.intellimeet.model.ScheduleModel;
import com.tothenew.intellimeet.repository.IntellimeetRepository;
import com.tothenew.intellimeet.repository.SessionRepository;
import com.tothenew.intellimeet.util.DateUtil;
import com.tothenew.intellimeet.util.PageUtil;
import com.tothenew.intellimeet.vo.SessionVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SessionService {
    Logger log = Logger.getLogger(SessionService.class.getName());

    public List<SessionVO> findAllDefault() {
        List<Session> sessionList = sessionRepository.findAllBySessionStat(SessionStat.CURRENT_MONTH);
        List<SessionVO> sessionVOs = new ArrayList<SessionVO>();
        for (Session session : sessionList) {
            sessionVOs.add(populateSessionVO(session));
        }
        return sessionVOs;
    }

    public Map<String, Object> findAllSessionBySessionStat(String sessionStat, Integer page, Integer max) {
        SessionStat sessionStatInstance = null;
        Long totalItems = 0L;
        Map<String, Object> map = new HashMap<String, Object>();
        List<SessionVO> sessionVOs = new ArrayList<SessionVO>();
        List<Session> sessionList;
        try {
            sessionStatInstance = SessionStat.getSessionStat(sessionStat);
        } catch (Exception e) {
        }
        if (sessionStatInstance != null) {
            sessionList = sessionRepository.findAllBySessionStat(sessionStatInstance, PageUtil.page(page, max));
            totalItems = sessionRepository.countBySessionStat(sessionStatInstance);
        } else {
            sessionList = sessionRepository.all(PageUtil.page(page, max));
            totalItems = sessionRepository.count();
        }
        for (Session session : sessionList) {
            sessionVOs.add(populateSessionVO(session));
        }

        map.put("sessions", sessionVOs);
        map.put("totalItems", totalItems);
        map.put("max", max);
        return map;
    }

    public List<String> listOfSessionStat() {
        List<String> sessionStatValue = new ArrayList<String>();
        SessionStat[] sessionStatList = SessionStat.values();
        for (SessionStat sessionStat : SessionStat.values()) {
            sessionStatValue.add(sessionStat.getValue());
        }
        return sessionStatValue;
    }

    public List<Session> findAll(int page, int size) {

        return sessionRepository.findAll(PageUtil.page(page, size));
    }

    public Session findById(Long id) {
        return sessionRepository.findById(id);
    }

    public Session save(Topic topic, Paper paper, String presenter) {
        Session session = new Session();
        session.setPaper(paper);
        session.setTopic(topic);
        session.setSessionStat(SessionStat.NOT_SCHEDULED);
        session.setPresenter(presenter);
        ScheduleModel scheduleModel = ScheduleModel.populateDefaultScheduleModel();
        Schedule schedule = scheduleService.save(scheduleModel);
        session.setSchedule(schedule);
        sessionRepository.save(session);
        return session;
    }

    public Session addPresenter(Long id, String presenter) {
        Session session = sessionRepository.findById(id);
        session.setPresenter(presenter);
        sessionRepository.save(session);
        return session;
    }

    public Session removePresenter(Long id, String presenter) {
        Session session = sessionRepository.findById(id);
        session.removePresenter(presenter);
        sessionRepository.save(session);
        return session;
    }


    public SessionVO addToComingIntellimeet(Long id) {
        Intellimeet intellimeet = intellimeetRepository.getLastIntellimeet();
        Session session = sessionRepository.findById(id);
        Timestamp lastSaturday = DateUtil.toTimestamp(DateUtil
                .getLastSaturdayOfIntellimeet());
        if (intellimeet == null) {
            intellimeet = new Intellimeet();
        } else if (intellimeet.isExpire()) {
            intellimeet = new Intellimeet();
        } else {
            lastSaturday = DateUtil.toTimestamp(intellimeet.getIntellimeetDateInstance());
        }

        if (session.hasScheduled()) {
            session = session.clone();
            ScheduleModel scheduleModel = ScheduleModel.populateDefaultScheduleModel();
            Schedule schedule = scheduleService.save(scheduleModel);
            session.setSchedule(schedule);
        }
        session.setSessionStat(SessionStat.CURRENT_MONTH);
        intellimeet.setIntellimeetDate(lastSaturday);
        intellimeet.setSession(session);
        session.setIsAddedInIntellimeet(true);
        sessionRepository.save(session);
        intellimeetRepository.save(intellimeet);
        session.setIntellimeet(intellimeet);
        sessionRepository.save(session);
        SessionVO sessionVO = populateSessionVO(session);
        return sessionVO;
    }

    public SessionVO removeSessionFromIntellimeet(Long id) {
        Intellimeet intellimeet = intellimeetRepository.getLastIntellimeet();
        Session session = sessionRepository.findById(id);
        if (intellimeet.removeSession(session)) {
            session.setIsAddedInIntellimeet(false);
            if (!session.hasScheduled()) {
                session.setSessionStat(SessionStat.NOT_SCHEDULED);
                session.setIntellimeet(null);
            }
            intellimeetRepository.save(intellimeet);
            sessionRepository.save(session);
            SessionVO sessionVO = populateSessionVO(session);
            return sessionVO;
        }
        return null;
    }

    public Page<Session> findAllByTopicName(String name, Integer page, Integer size) {
        return sessionRepository.findAllByTopicName(name, PageUtil.page(page, size));
    }

    private SessionVO populateSessionVO(Session session) {
        if (session != null) {
            SessionVO sessionVO = new SessionVO();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(IntellimeetConstants.INTELLIMEET_DISPLAY_DATE_FORMAT);
            sessionVO.setId(session.getId());
            sessionVO.setTopic(session.getTopic());
            sessionVO.setPaper(session.getPaper());
            sessionVO.setPresenters(session.getPresenters());
            sessionVO.setIsAddedInIntellimeet(session.getIsAddedInIntellimeet());
            sessionVO.setSchedule(session.getSchedule());
            sessionVO.setSessionStat(session.getSessionStat());
            sessionVO.setSessionStatValue(session.getSessionStat().getValue());
            sessionVO.setDateCreated(simpleDateFormat.format(session.getDateCreated()));
            sessionVO.setLastUpdated(simpleDateFormat.format(session.getLastUpdated()));
            sessionVO.setIntellimeet(session.getIntellimeet());
            return sessionVO;
        }
        return null;
    }


    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    IntellimeetRepository intellimeetRepository;

    @Autowired
    ScheduleService scheduleService;
}
