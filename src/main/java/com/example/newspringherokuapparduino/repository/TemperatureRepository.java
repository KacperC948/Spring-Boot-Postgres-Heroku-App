package com.example.newspringherokuapparduino.repository;

import com.example.newspringherokuapparduino.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {
    @Query("SELECT MAX(id) FROM Temperature")
    String getMaxId();
}