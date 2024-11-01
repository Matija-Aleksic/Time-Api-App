package com.example.time_api_app.Repository;

import com.example.time_api_app.Model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Db extends JpaRepository<Time, Long> {
}