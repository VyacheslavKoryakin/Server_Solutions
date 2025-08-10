package com.example.demo.homeworkss.Controller;

import com.example.demo.homeworkss.Models.MovieApiResponse;
import com.example.demo.homeworkss.Models.Search;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mc")
public class MovieController {

    String baseUrl = "https://www.omdbapi.com";
    String apiKey = "266b43cd";


    @GetMapping("/{title}")
    public ResponseEntity<?> getMovie(@RequestParam int viewSize, @RequestParam int page, @PathVariable String title) {

        String url = baseUrl + "?s=" + title + "&apiKey=" + apiKey + "&page=";
        int pageForRequest = (int) Math.ceil((page * viewSize) / 10.0);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MovieApiResponse> response = restTemplate.getForEntity(url + pageForRequest, MovieApiResponse.class);
        MovieApiResponse result;

        if (response.getStatusCode().is2xxSuccessful()) {
            result = response.getBody();
            List<Search> arr = new ArrayList<>(result.Search);


            int totalResult = Integer.parseInt(result.totalResults);
            int pages = (int) Math.ceil((double) totalResult / viewSize);
            int temp1 = (pageForRequest * 10);
            int temp2 = (pageForRequest * 10 - viewSize);


            int movieOffset = temp1 - temp2;
            List<Search> arr2 = arr.stream().skip(10 - movieOffset).limit(viewSize).collect(Collectors.toList());

            result.totalPages = pages;
            result.currentPage = page;
            result.Search = new ArrayList<>(arr2);
            result.owner = "VKoryakin";
            result.group = "Java411";
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}




