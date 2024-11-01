package com.example.time_api_app.Controllers;


import com.example.time_api_app.Repository.Db;
import com.example.time_api_app.Model.Time;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RestController
public class TimeController {

    private final RestTemplate restTemplate;
    private final Db db;

    public TimeController(RestTemplate restTemplate, Db db) {
        this.restTemplate = restTemplate;
        this.db = db;
    }

    @GetMapping(value = "/**")
    public String getTime(HttpServletRequest request) {
        String location = request.getRequestURI();
        final String uri = "http://worldtimeapi.org/api/timezone/" + location;
        String result = null;
        String utcDateTime = null;

        while (result == null) {
            try {
                result = restTemplate.getForObject(uri, String.class);
                utcDateTime = result.substring(result.indexOf("utc_datetime"), result.indexOf("timezone"));
                Time timeEntry = new Time();
                timeEntry.setQuery(location);
                timeEntry.setResult(utcDateTime);
                timeEntry.setTime(LocalDateTime.now());
                db.save(timeEntry);

                System.out.println("Inserted into Database");

            } catch (RestClientException e) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread was interrupted.");
                    return "Error: Thread was interrupted.";
                }
            }
        }
        return utcDateTime;
    }

}