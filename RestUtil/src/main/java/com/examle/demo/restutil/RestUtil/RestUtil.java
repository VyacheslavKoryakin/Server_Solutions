package com.examle.demo.restutil.RestUtil;

import com.examle.demo.restutil.Model.RandomNPeople;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestUtil {


    private RestTemplate restTemplate = new RestTemplate();

    @Value("${rand.people.url}")
    private String baseUrl;



    public ResponseEntity<?> getPeople(String name) {
        String url = baseUrl + "/?name=" + name;
        List<RandomNPeople> arr = new ArrayList<>();

        ResponseEntity<RandomNPeople> response = restTemplate.getForEntity(url, RandomNPeople.class);
        RandomNPeople result = null;
        if (response.getStatusCode().is2xxSuccessful()) {
            result = response.getBody();
            System.out.println(result);
            arr.add(new RandomNPeople(result.count,result.name,result.gender,result.probability));


            return ResponseEntity.ok(arr);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}