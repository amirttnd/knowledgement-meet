package com.tothenew.intellimeet.service;

import java.util.List;

import com.tothenew.intellimeet.util.PageUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tothenew.intellimeet.domain.Paper;
import com.tothenew.intellimeet.domain.Topic;
import com.tothenew.intellimeet.enums.TopicType;
import com.tothenew.intellimeet.exception.ObjectNotFoundException;
import com.tothenew.intellimeet.exception.ObjectNotSavedException;
import com.tothenew.intellimeet.model.PaperModel;
import com.tothenew.intellimeet.repository.PaperRepository;
import com.tothenew.intellimeet.repository.TopicRepository;

@Service
@Transactional
public class PaperService {
	Logger log = Logger.getLogger(PaperService.class.getName());

	public List<Paper> findAll(Integer page,Integer size) {
		return paperRepository.findAll(PageUtil.page(page,size));
	}

	public Paper findById(Long id) throws ObjectNotFoundException {
		Paper paper = paperRepository.findById(id);

		if (paper == null) {
			throw new ObjectNotFoundException("Object Not Found at Id " + id);
		}
		return paperRepository.findById(id);
	}

	public List<Paper> findByGivenBy(String givenBy) {
		return paperRepository.findByGivenBy(givenBy);
	}

	public List<Paper> findByTopic(Topic topic) {
		return paperRepository.findByTopic(topic);
	}

	public Paper save(PaperModel paperModel) throws ObjectNotSavedException {
		Paper paper = new Paper();
		paper.setAgenda(paperModel.getAgenda());
		paper.setGivenBy(paperModel.getGivenBy());
		Topic topic = topicRepository.findByName(paperModel.getTopicName());
		if (topic == null) {
			topic = topicService
					.save(paperModel.getTopicName(),
							paperModel.getGivenBy(),
							paperModel.getTopicType() == "Advanced" ? TopicType.ADVANCED
									: TopicType.HYGIENE);
		}
		sessionService.save(null, paper, paperModel.getGivenBy());
		paper.setTopic(topic);
		paperRepository.save(paper);
		if (paper.getId() == null) {
			throw new ObjectNotSavedException("Could Not Save Object");
		}
		return paper;
	}

	public Paper delete(Long id) {
		Paper paper = paperRepository.findById(id);
		paper.setDeleted(true);
		paperRepository.save(paper);
		return paper;
	}

	@Autowired
	SessionService sessionService;

	@Autowired
	TopicService topicService;

	@Autowired
	PaperRepository paperRepository;

	@Autowired
	TopicRepository topicRepository;
}
