package ags.SechsY.temperaturverwaltung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ags.SechsY.temperaturverwaltung.dto.UserDTO;
import ags.SechsY.temperaturverwaltung.mapper.UserMapper;
import ags.SechsY.temperaturverwaltung.model.User;
import ags.SechsY.temperaturverwaltung.service.UserService;

@RestController
@RequestMapping(value = "/user", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserController {

    @Autowired
    private UserService userService;
    private UserMapper userMapper;

    @GetMapping(path = "/{id}")
    public UserDTO findUser(@PathVariable("id") Long id) {
        User user = userService.findUserById(id);
        UserDTO userDto = userMapper.mapEntity(user);
        return userDto;
    }

    @PostMapping(path = "/create")
    public User createUser(@RequestBody UserDTO userDto) {
        User newUser = userMapper.mapDTO(userDto);
        return userService.addUser(newUser);
    }
}
