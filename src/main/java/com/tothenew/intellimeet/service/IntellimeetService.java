package com.tothenew.intellimeet.service;

import com.tothenew.intellimeet.constants.IntellimeetConstants;
import com.tothenew.intellimeet.domain.Intellimeet;
import com.tothenew.intellimeet.repository.IntellimeetRepository;
import com.tothenew.intellimeet.util.DateUtil;
import com.tothenew.intellimeet.vo.IntellimeetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class IntellimeetService {


    public IntellimeetVO changeIntellimeetDate(String date) {
        Date parseDate = DateUtil.parseDate(date, IntellimeetConstants.INTELLIMEET_DATE_FORMAT);
        IntellimeetVO intellimeetVO = null;
        if (parseDate != null) {
            Intellimeet intellimeet = intellimeetRepository.getLastIntellimeet();
            Timestamp knowledgeMeetDate = DateUtil.toTimestamp(parseDate);
            if (intellimeet != null) {
                if (intellimeet.getIntellimeetDateInstance().after(new Date())) {
                    intellimeet.setIntellimeetDate(knowledgeMeetDate);
                    intellimeet.setIsDefaultDateChanged(true);
                    intellimeetRepository.save(intellimeet);
                    intellimeetVO = populateIntellimeetVO(intellimeet);
                }
            }
        }
        return intellimeetVO;
    }

    public IntellimeetVO findById(Long id) {
        Intellimeet intellimeet = intellimeetRepository.findById(id);
        if (intellimeet != null) {
            IntellimeetVO intellimeetVO = populateIntellimeetVO(intellimeet);
            return intellimeetVO;
        }
        return null;
    }

    public IntellimeetVO findByDate(Date date) {
        IntellimeetVO intellimeetVO = null;
        if (date != null) {
            Intellimeet intellimeet = intellimeetRepository.findByIntellimeetDate(DateUtil.toTimestamp(date));
            intellimeetVO = populateIntellimeetVO(intellimeet);
        }
        return intellimeetVO;
    }

    public List<IntellimeetVO> findAll() {
        List<Intellimeet> intellimeets = intellimeetRepository.findAll();
        List<IntellimeetVO> intellimeetVOs = new ArrayList<IntellimeetVO>();
        for (Intellimeet intellimeet : intellimeets) {
            intellimeetVOs.add(populateIntellimeetVO(intellimeet));
        }
        return intellimeetVOs;
    }

    public IntellimeetVO getLastIntellimeet() {
        Intellimeet intellimeet = intellimeetRepository.getLastIntellimeet();
        if (intellimeet != null) {
            IntellimeetVO intellimeetVO = populateIntellimeetVO(intellimeet);
            return intellimeetVO;
        }
        return null;
    }

    private IntellimeetVO populateIntellimeetVO(Intellimeet intellimeet) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(IntellimeetConstants.INTELLIMEET_DISPLAY_DATE_FORMAT);
        IntellimeetVO intellimeetVO = new IntellimeetVO();
        if (intellimeet != null) {
            intellimeetVO.setId(intellimeet.getId());
            if (intellimeet.getIntellimeetDateInstance() != null) {
                intellimeetVO.setIntellimeetDate(simpleDateFormat
                        .format(intellimeet.getIntellimeetDateInstance()));
            }
            if (intellimeet.getDateCreated() != null) {
                intellimeetVO.setDateCreated(simpleDateFormat.format(intellimeet.getDateCreated()));
            }
            if (intellimeet.getLastUpdated() != null) {
                intellimeetVO.setLastUpdated(simpleDateFormat.format(intellimeet.getLastUpdated()));
            }
            intellimeetVO.setSessions(intellimeet.getSessions());
        }
        return intellimeetVO;
    }

    @Autowired
    IntellimeetRepository intellimeetRepository;

}
