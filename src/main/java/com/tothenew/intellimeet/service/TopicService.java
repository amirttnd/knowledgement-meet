package com.tothenew.intellimeet.service;

import com.tothenew.intellimeet.constants.IntellimeetConstants;
import com.tothenew.intellimeet.domain.Topic;
import com.tothenew.intellimeet.enums.TopicType;
import com.tothenew.intellimeet.exception.ObjectNotFoundException;
import com.tothenew.intellimeet.exception.ObjectNotSavedException;
import com.tothenew.intellimeet.repository.TopicRepository;
import com.tothenew.intellimeet.util.PageUtil;
import com.tothenew.intellimeet.vo.TopicVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TopicService {
    Logger log = Logger.getLogger(TopicService.class.getName());

    public TopicVO findById(Long id) throws ObjectNotFoundException {
        Topic topic = topicRepository.findById(id);
        TopicVO topicVO = null;
        if (topic == null) {
            throw new ObjectNotFoundException("Object Not Found at ID " + id);
        }
        topicVO = populateTopicVO(topic);
        return topicVO;
    }

    public List<TopicVO> findAll() {
        List<Topic> topicList = topicRepository.findAll(PageUtil.orderByIdDesc());
        List<TopicVO> topicVOs = new ArrayList<TopicVO>();
        for (Topic topic : topicList) {
            topicVOs.add(populateTopicVO(topic));
        }
        return topicVOs;
    }

    public List<String> listOfTopicNames() {
        return topicRepository.listOfTopicNames();
    }

    public Topic save(String name, String owner, TopicType topicType)
            throws ObjectNotSavedException {
        Topic topic = new Topic();
        topic.setName(name);
        topic.setOwner(owner);
        topic.setTopicType(topicType);
        topic.setImageSrc(IntellimeetConstants.TOPIC_LOGO_DEFAULT_PATH + File.separator + "NoImageFound.jpg");
        topicRepository.save(topic);
        if (topic.getId() == null) {
            throw new ObjectNotSavedException("Could Not Saved Object");
        }
        return topic;
    }

    private TopicVO populateTopicVO(Topic topic) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(IntellimeetConstants.INTELLIMEET_DISPLAY_DATE_FORMAT);
        if (topic != null) {
            TopicVO topicVO = new TopicVO();
            topicVO.setId(topic.getId());
            topicVO.setName(topic.getName());
            topicVO.setOwner(topic.getOwner());
            topicVO.setTopicType(topic.getTopicType());
            topicVO.setImageSrc(topic.getImageSrc());
            if (topic.getDateCreated() != null) {
                topicVO.setDateCreated(simpleDateFormat.format(topic.getDateCreated()));
            }

            if (topic.getLastUpdated() != null) {
                topicVO.setLastUpdated(simpleDateFormat.format(topic.getLastUpdated()));
            }

            return topicVO;
        }
        return null;
    }

    public Topic uploadFile(MultipartFile file, Long id, String outputSrc) {
        File outputFile = new File(outputSrc + IntellimeetConstants.TOPIC_LOGO_DEFAULT_PATH + File.separator + file.getOriginalFilename());
        Topic topic = topicRepository.findById(id);
        try {
            file.transferTo(outputFile);
            topic.setImageSrc(IntellimeetConstants.TOPIC_LOGO_DEFAULT_PATH + File.separator + file.getOriginalFilename());
            topicRepository.save(topic);
        } catch (Exception e) {
            return null;
        }
        return topic;
    }

    @Autowired
    TopicRepository topicRepository;

}
