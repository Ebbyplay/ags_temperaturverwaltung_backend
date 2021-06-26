package ags.SechsY.temperaturverwaltung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ags.SechsY.temperaturverwaltung.model.Log;
import ags.SechsY.temperaturverwaltung.service.LogService;

@RestController
@RequestMapping(value = "/log", produces = { MediaType.APPLICATION_JSON_VALUE })
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/findAll")
    public List<Log> findAll() {
        return logService.findAll();
    }
}
