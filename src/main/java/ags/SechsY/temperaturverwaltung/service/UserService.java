package ags.SechsY.temperaturverwaltung.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ags.SechsY.temperaturverwaltung.exception.UserNotFoundException;
import ags.SechsY.temperaturverwaltung.model.User;
import ags.SechsY.temperaturverwaltung.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User findUserById(Long id) {
        Optional<User> user = userRepo.findById(id);

        if (!user.isPresent()) {
            throw new UserNotFoundException(id);
        } else {
            return user.get();
        }
    }

    public List<User> findAll() {
        return (List<User>) userRepo.findAll();
    }

    public User updateUser(User user) {
        if (findUserById(user.getId()) != null) {
            return createUser(user);
        } else {
            throw new UserNotFoundException(user.getId());
        }

    }

    public void deleteUserById(Long id) {
        User user = findUserById(id);
        if (user != null) {
            userRepo.delete(user);
        } else {
            throw new UserNotFoundException(id);
        }
    }

}
