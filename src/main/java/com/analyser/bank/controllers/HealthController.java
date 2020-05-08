package com.analyser.bank.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @RequestMapping(value = "/isAlive", method = RequestMethod.GET)
    public ResponseEntity<?> isAlive() {
        return ResponseEntity.ok().body("OK");
    }
}
