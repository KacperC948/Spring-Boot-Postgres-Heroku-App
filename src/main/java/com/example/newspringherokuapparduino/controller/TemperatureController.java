package com.example.newspringherokuapparduino.controller;

import com.example.newspringherokuapparduino.model.Temperature;
import com.example.newspringherokuapparduino.service.TemperatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("temperature")
public class TemperatureController {
    @Autowired
    private TemperatureService temperatureService;

    Logger logger = LoggerFactory.getLogger(TemperatureController.class);
    //comment
    //123
    @PostMapping("/add")
    @ResponseBody
    public String add(@RequestParam(name = "temperature") float temperature, @Autowired HttpServletRequest request){
        Temperature temperature1 = new Temperature();
        Date date = new Date();
        if(temperatureService.getMaxId() == -1){
            temperature1.setId(1);
        } else {
            temperature1.setId(temperatureService.getMaxId() + 1);
        }
        temperature1.setTemperature(temperature);
        temperature1.setDate(date);
        temperatureService.saveTemperature(temperature1);
        logger.info("IP ADDRESS: " + request.getRemoteAddr());
        return "New temperature is added";
    }
}
