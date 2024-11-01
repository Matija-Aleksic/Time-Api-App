package com.example.time_api_app.Controllers;

import com.example.time_api_app.Repository.Db;
import com.example.time_api_app.Model.Time;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class DbController {
    private final Db db;

    public DbController(Db db) {
        this.db = db;
    }

    @GetMapping("db/{id}")
    public Time getTimeById(@PathVariable Long id) {
        return db.findById(id).orElseThrow(() -> new EntityNotFoundException("No record found with ID " + id));
    }
}
