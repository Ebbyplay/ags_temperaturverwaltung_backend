package ags.SechsY.temperaturverwaltung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ags.SechsY.temperaturverwaltung.dao.UserDAO;
import ags.SechsY.temperaturverwaltung.model.User;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User addUser(User user) {
        return userDAO.save(user);
    }

    public User findUserById(Long id) {
        return userDAO.findById(id).get();
    }

    public List<User> findAll() {
        return (List<User>) userDAO.findAll();
    }

    public User updateUser(User user) {
        return addUser(user);
    }

    public void deleteUser(User user) {
        userDAO.delete(user);
    }

}
