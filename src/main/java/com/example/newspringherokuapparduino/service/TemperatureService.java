package com.example.newspringherokuapparduino.service;

import com.example.newspringherokuapparduino.model.Temperature;

import java.util.List;

public interface TemperatureService {
    public Temperature saveTemperature(Temperature temperature);
    public List<Temperature> getAllTemperatures();
    public int getMaxId();
}