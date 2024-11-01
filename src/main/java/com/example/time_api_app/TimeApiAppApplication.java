package com.example.time_api_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.time_api_app")
public class TimeApiAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeApiAppApplication.class, args);
    }

}
