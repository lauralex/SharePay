package org.valenti.usermanagement.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.valenti.usermanagement.dto.LoginDTO;
import org.valenti.usermanagement.models.User;
import org.valenti.usermanagement.models.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String sayHello() {
        return "Hello user!";
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public Iterable<User> searchUserByUsername(String username) {
        return userRepository.findByUsernameContainsIgnoreCase(username);
    }

    public String signup(User newUser) {
        try {
            userRepository.save(newUser);
        } catch(Exception ex) {
            return "Exception: " + ex.getMessage();
        }
        return "New user " + newUser.getUsername() + " registered!";
    }

    public String login(LoginDTO credentials) {
        Optional<User> userToLog = userRepository.findByEmail(credentials.getUsername());

        if (userToLog.isPresent() && userToLog.get().getPassword().equals(credentials.getPassword())) {
            return "User " + userToLog.get().getUsername() + " logged in!";
        }
        return "Wrong credentials";
    }

    public String deleteUserById(Integer id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return "User with id: " + id + " has been deleted!";
        }
        return "User with id: " + id + " is not present";
    }
}