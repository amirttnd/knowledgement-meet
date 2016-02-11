package com.tothenew.intellimeet.controller;

import com.tothenew.intellimeet.domain.Paper;
import com.tothenew.intellimeet.exception.ObjectNotFoundException;
import com.tothenew.intellimeet.exception.ObjectNotSavedException;
import com.tothenew.intellimeet.model.PaperModel;
import com.tothenew.intellimeet.service.PaperService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/paper")
public class PaperController {
    static Logger log = Logger.getLogger(PaperController.class.getName());

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Paper> show(@PathVariable("id") Long id) {
        Paper paper = null;
        try {
            paper = paperService.findById(id);
        } catch (ObjectNotFoundException e) {
        }

        return new ResponseEntity<Paper>(paper, HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Paper>> list(@RequestParam(name = "page", defaultValue = "0") Integer page, @RequestParam(name = "size", defaultValue = "10") Integer size) {
        return new ResponseEntity<Collection<Paper>>(paperService.findAll(page,size),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Paper> create(@RequestBody PaperModel paperModel) {
        Paper paper = null;
        try {
            paper = paperService.save(paperModel);
        } catch (ObjectNotSavedException e) {

        }

        return new ResponseEntity<Paper>(paper, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Paper> delete(@PathVariable("id") Long id) {

        return new ResponseEntity<Paper>(paperService.delete(id), HttpStatus.OK);
    }

    @Autowired
    PaperService paperService;
}
