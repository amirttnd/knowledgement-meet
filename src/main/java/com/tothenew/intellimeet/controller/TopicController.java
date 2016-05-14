package com.tothenew.intellimeet.controller;

import java.util.Collection;
import java.util.List;

import com.tothenew.intellimeet.vo.TopicVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tothenew.intellimeet.domain.Topic;
import com.tothenew.intellimeet.enums.TopicType;
import com.tothenew.intellimeet.exception.ObjectNotSavedException;
import com.tothenew.intellimeet.service.TopicService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/topic")
public class TopicController {

    static Logger log = Logger.getLogger(TopicController.class.getName());

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Topic> create(@RequestParam("name") String name,
                                        @RequestParam("owner") String owner) {
        Topic topic = null;
        try {
            topic = topicService.save(name, owner, TopicType.ADVANCED);
        } catch (ObjectNotSavedException e) {

        }
        return new ResponseEntity<Topic>(topic, HttpStatus.OK);
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TopicVO> show(@PathVariable("id") Long id) {
        TopicVO topicVO = null;
        try {
            topicVO = topicService.findById(id);
        } catch (Exception e) {
        }
        return new ResponseEntity<TopicVO>(topicVO, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TopicVO> update(@PathVariable Long id) {
        TopicVO topicVO = null;
        try {
            topicVO = topicService.findById(id);
        } catch (Exception e) {
        }

        return new ResponseEntity<TopicVO>(topicVO, HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<TopicVO>> list() {

        return new ResponseEntity<Collection<TopicVO>>(topicService.findAll(),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/listOfTopicNames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> listOfTopicNames() {

        return new ResponseEntity<List<String>>(
                topicService.listOfTopicNames(), HttpStatus.OK);
    }

    @RequestMapping(value = "/uploadLogo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Topic> uploadLogo(@RequestParam(value = "logo") MultipartFile file, @RequestParam(value = "topicId") Long id, HttpServletRequest request) {
        return new ResponseEntity<Topic>(topicService.uploadFile(file, id, request.getServletContext().getRealPath("/")), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveCloudinaryUrl", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Topic> saveCloudinaryUrl(@RequestParam(value = "imageUrl") String imageUrl, @RequestParam(value = "topicId") Long id) {
        return new ResponseEntity<Topic>(topicService.saveCloudinaryUrl(id, imageUrl), HttpStatus.OK);
    }

    @RequestMapping(value = "/findByNameLike", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TopicVO>> findByNameLike(@RequestParam(name = "name") String name) {
        return new ResponseEntity<List<TopicVO>>(topicService.findByNameLike(name), HttpStatus.OK);
    }

    @Autowired
    TopicService topicService;
}
