package com.examle.demo.restutil.Controllers;

import com.examle.demo.restutil.Service.RandomPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController()

public class RandomPeopleController {
    @Autowired
    RandomPeopleService randomPeopleService;

    @GetMapping("/{name}")
    ResponseEntity<?> getRandomPeople(@PathVariable String name) {
        return randomPeopleService.getPeople(name);
    }
}
