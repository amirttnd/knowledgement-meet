package com.tothenew.intellimeet.controller;

import com.tothenew.intellimeet.constants.IntellimeetConstants;
import com.tothenew.intellimeet.service.IntellimeetService;
import com.tothenew.intellimeet.util.DateUtil;
import com.tothenew.intellimeet.vo.IntellimeetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/intellimeet")
public class IntellimeetController {

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IntellimeetVO> show(@PathVariable("id") Long id) {
        return new ResponseEntity<IntellimeetVO>(intellimeetService.findById(id),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<IntellimeetVO>> list() {
        return new ResponseEntity<List<IntellimeetVO>>(
                intellimeetService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/lastIntellimeet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IntellimeetVO> show() {
        return new ResponseEntity<IntellimeetVO>(
                intellimeetService.getLastIntellimeet(), HttpStatus.OK);
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IntellimeetVO> view(@RequestParam(name = "date") @DateTimeFormat(pattern = IntellimeetConstants.INTELLIMEET_DATE_FORMAT) Date date) {
        return new ResponseEntity<IntellimeetVO>(intellimeetService.findByDate(date),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/changeIntellimeetDate", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IntellimeetVO> changeIntellimeetDate(@RequestBody String date) {
        return new ResponseEntity<IntellimeetVO>(intellimeetService.changeIntellimeetDate(date), HttpStatus.OK);
    }

    @Autowired
    IntellimeetService intellimeetService;
}
