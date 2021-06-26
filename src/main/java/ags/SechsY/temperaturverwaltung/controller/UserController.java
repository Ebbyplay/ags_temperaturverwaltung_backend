package ags.SechsY.temperaturverwaltung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ags.SechsY.temperaturverwaltung.dao.UserDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserController {

    @Autowired
    private UserDAO userDAO;

}
