package ags.SechsY.temperaturverwaltung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ags.SechsY.temperaturverwaltung.model.Log;
import ags.SechsY.temperaturverwaltung.repo.LogRepo;

@Service
public class LogService {

    @Autowired
    private LogRepo logRepo;

    public Log createLog(Log log) {
        return logRepo.save(log);
    }

    public List<Log> findAll() {
        return (List<Log>) logRepo.findAll();
    }

}
