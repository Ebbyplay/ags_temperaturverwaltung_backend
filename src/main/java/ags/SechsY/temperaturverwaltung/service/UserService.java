package ags.SechsY.temperaturverwaltung.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ags.SechsY.temperaturverwaltung.exception.EntityIsStillBeingUsedException;
import ags.SechsY.temperaturverwaltung.exception.EntityNotFoundException;
import ags.SechsY.temperaturverwaltung.model.User;
import ags.SechsY.temperaturverwaltung.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User create(User user) {
        return userRepo.save(user);
    }

    public User findById(Long id) {
        Optional<User> user = userRepo.findById(id);

        if (!user.isPresent()) {
            throw new EntityNotFoundException(User.ENTITY_NAME, id);
        }
        return user.get();
    }

    public List<User> findAll() {
        return (List<User>) userRepo.findAll();
    }

    public User update(User user) {
        if (findById(user.getId()) != null) {
            return create(user);
        } else {
            throw new EntityNotFoundException(User.ENTITY_NAME, user.getId());
        }
    }

    public void deleteById(Long id) {
        User user = findById(id);
        if (user != null) {
            try {
                userRepo.delete(user);
            } catch (Exception e) {
                throw new EntityIsStillBeingUsedException(User.ENTITY_NAME, id);
            }
        } else {
            throw new EntityNotFoundException(User.ENTITY_NAME, id);
        }
    }

}
