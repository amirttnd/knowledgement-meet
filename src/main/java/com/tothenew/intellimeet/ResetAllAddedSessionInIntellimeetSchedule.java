package com.tothenew.intellimeet;

import com.tothenew.intellimeet.domain.Intellimeet;
import com.tothenew.intellimeet.enums.SessionStat;
import com.tothenew.intellimeet.repository.IntellimeetRepository;
import com.tothenew.intellimeet.repository.SessionRepository;
import com.tothenew.intellimeet.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class ResetAllAddedSessionInIntellimeetSchedule {

    @Scheduled(cron="0 0 19 1/1 * ?")
    void resetAllAddedSessionInIntellimeet() {
        Timestamp todayTimestamp = DateUtil.toTimestamp(DateUtil
                .converInDDMMYYYformat(new Date()));
        Intellimeet intellimeet = intellimeetRepository.getLastIntellimeet();
        if (intellimeet != null) {
            if (intellimeetRepository.getLastIntellimeet().getIntellimeetDateInstance()
                    .equals(todayTimestamp)) {
                System.out.println("Total Expire Sessions:-"
                        + sessionRepository
                        .expireAllAddedIntellimeetSessions(SessionStat.SCHEDULED));
            }
        }

    }

    @Autowired
    IntellimeetRepository intellimeetRepository;

    @Autowired
    SessionRepository sessionRepository;
}
