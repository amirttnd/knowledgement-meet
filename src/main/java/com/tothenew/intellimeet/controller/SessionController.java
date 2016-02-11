package com.tothenew.intellimeet.controller;

import com.tothenew.intellimeet.domain.Session;
import com.tothenew.intellimeet.enums.SessionStat;
import com.tothenew.intellimeet.service.SessionService;
import com.tothenew.intellimeet.vo.SessionVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {
    static Logger log = Logger.getLogger(SessionController.class.getName());

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SessionVO>> list(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size) {
        return new ResponseEntity<List<SessionVO>>(sessionService.findAllDefault(), HttpStatus.OK);
    }

    @RequestMapping(value = "/show/{id}")
    public ResponseEntity<Session> show(@PathVariable("id") Long id) {

        return new ResponseEntity<Session>(sessionService.findById(id),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/addPresenter/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Session> addPresenter(@PathVariable("id") Long id,
                                                @RequestBody String presenter) {

        return new ResponseEntity<Session>(sessionService.addPresenter(id,
                presenter), HttpStatus.OK);
    }

    @RequestMapping(value = "/removePresenter/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Session> removePresenter(@PathVariable("id") Long id,
                                                   @RequestBody String presenter) {
        return new ResponseEntity<Session>(sessionService.removePresenter(id,
                presenter), HttpStatus.OK);
    }

    @RequestMapping(value = "/addToComingIntellimeet/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SessionVO> addToComingIntellimeet(
            @PathVariable("id") Long id) {
        return new ResponseEntity<SessionVO>(
                sessionService.addToComingIntellimeet(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/removeSessionFromIntellimeet/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SessionVO> removeSessionFromIntellimeet(
            @PathVariable("id") Long id) {
        return new ResponseEntity<SessionVO>(
                sessionService.removeSessionFromIntellimeet(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/listOfSessionStat", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> listOfSessionStat() {
        return new ResponseEntity<List<String>>(sessionService.listOfSessionStat(), HttpStatus.OK);
    }

    @RequestMapping(value = "/findAllSessionBySessionStat", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SessionVO>> fetchSessionOnTheBasisOfSessionStat(@RequestParam("sessionStat") String sessionStat) {
        return new ResponseEntity<List<SessionVO>>(sessionService.findAllSessionBySessionStat(sessionStat), HttpStatus.OK);
    }


    @Autowired
    SessionService sessionService;

}
