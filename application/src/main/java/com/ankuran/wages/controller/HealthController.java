package com.ankuran.wages.controller;

import com.ankuran.wages.model.Centre;
import com.ankuran.wages.model.response.SampleResponse;
import com.ankuran.wages.repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Sushil Mittal.
 * @Created At 18/02/19.
 */
@Controller
public class HealthController {

    @Autowired
    private CenterRepository centerRepository;

    /**
     * Sample code for a controller
     *
     * @return
     */
    @GetMapping("/status")
    public ResponseEntity<HttpStatus> getStatus() {
        //Creating sample request object
        SampleResponse sampleResponse = new SampleResponse();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Centre>> findAllCenter() {
        return new ResponseEntity<>(centerRepository.findAll(), HttpStatus.OK);
    }
}
