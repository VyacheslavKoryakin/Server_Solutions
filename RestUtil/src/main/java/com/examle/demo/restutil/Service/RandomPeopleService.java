package com.examle.demo.restutil.Service;

import com.examle.demo.restutil.Model.RandomNPeople;
import com.examle.demo.restutil.RestUtil.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RandomPeopleService {
    @Autowired
    RestUtil restUtil;

    public ResponseEntity<?> getPeople(String name) {
        return restUtil.getPeople(name);
    }
}
