package ru.art_anna.springbootapp.crud_boot.service;

import ru.art_anna.springbootapp.crud_boot.model.User;

import javax.validation.Valid;
import java.util.List;

public interface UserService {

    void createUpdateUser(@Valid User user);

    void removeUser(int id);

    List<User> getAllUsers();

    User getUserById(int id);

}
