package com.example.newspringherokuapparduino.service;

import com.example.newspringherokuapparduino.model.Temperature;
import com.example.newspringherokuapparduino.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureServiceImpl implements TemperatureService{
    @Autowired
    private TemperatureRepository temperatureRepository;

    @Override
    public Temperature saveTemperature(Temperature temperature) {
        return temperatureRepository.save(temperature);
    }

    @Override
    public List<Temperature> getAllTemperatures(){
        return temperatureRepository.findAll();
    }

    @Override
    public int getMaxId() {
        String max;
        try{
            max = temperatureRepository.getMaxId();
            if(max.equalsIgnoreCase("NULL")){
                return -1;
            } else {
                return Integer.parseInt(max);
            }
        } catch (Exception e){
            return -1;
        }
    }
}
