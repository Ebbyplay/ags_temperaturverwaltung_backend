package ags.SechsY.temperaturverwaltung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ags.SechsY.temperaturverwaltung.dao.UserDAO;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

}
