package ags.SechsY.temperaturverwaltung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ags.SechsY.temperaturverwaltung.dao.LogDAO;
import ags.SechsY.temperaturverwaltung.model.Log;

@Service
public class LogService {

    @Autowired
    LogDAO logDao;

    public Log createLog(Log log) {
        return logDao.save(log);
    }

    public List<Log> findAll() {
        return (List<Log>) logDao.findAll();
    }

}
