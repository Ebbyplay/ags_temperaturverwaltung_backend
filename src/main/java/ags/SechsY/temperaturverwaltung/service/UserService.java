package ags.SechsY.temperaturverwaltung.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ags.SechsY.temperaturverwaltung.dao.UserDAO;
import ags.SechsY.temperaturverwaltung.exception.UserNotFoundException;
import ags.SechsY.temperaturverwaltung.model.User;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User addUser(User user) {
        return userDAO.save(user);
    }

    public User findUserById(Long id) {
        Optional<User> user = userDAO.findById(id);

        if (!user.isPresent()) {
            throw new UserNotFoundException(id);
        } else {
            return user.get();
        }
    }

    public List<User> findAll() {
        return (List<User>) userDAO.findAll();
    }

    public User updateUser(User user) {
        if (findUserById(user.getId()) != null) {
            return addUser(user);
        } else {
            throw new UserNotFoundException(user.getId());
        }

    }

    public void deleteUserById(Long id) {
        User user = findUserById(id);
        if (user != null) {
            userDAO.delete(user);
        } else {
            throw new UserNotFoundException(id);
        }
    }

}
