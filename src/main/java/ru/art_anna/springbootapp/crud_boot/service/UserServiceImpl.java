package ru.art_anna.springbootapp.crud_boot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.art_anna.springbootapp.crud_boot.model.User;
import ru.art_anna.springbootapp.crud_boot.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional
    @Override
    public void createUpdateUser(@Valid User user) {
        if (user.getId() == 0) {
            createUser(user);
        } else {
            updateUser(user);
        }
    }
    @Transactional
    public void createUser(User user) {
        userRepo.createUser(user);
    }

    @Transactional
    public void updateUser(User user) {
        userRepo.updateUser(user);
    }

    @Transactional
    @Override
    public void removeUser(int id) {
        User user = null;
        try {
            userRepo.removeUser(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userRepo.getUserById(id);
    }
}
