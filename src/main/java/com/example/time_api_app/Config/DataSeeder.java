package com.example.time_api_app.Config;

import com.example.time_api_app.Model.Time;
import com.example.time_api_app.Repository.Db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataSeeder implements CommandLineRunner {

    private final Db db;

    @Autowired
    public DataSeeder(Db db) {
        this.db = db;
    }

    @Override
    public void run(String... args) {
        Time time1 = new Time(1L,"First query", "Result 1", LocalDateTime.now());
        Time time2 = new Time(2L,"Second query", "Result 2", LocalDateTime.now());
        Time time3 = new Time(3L,"Third query", "Result 3", LocalDateTime.now());

        db.save(time1);
        db.save(time2);
        db.save(time3);

        System.out.println("Sample data seeded into the database.");
    }
}