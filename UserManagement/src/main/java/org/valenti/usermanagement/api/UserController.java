package org.valenti.usermanagement.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.valenti.usermanagement.dto.LoginDTO;
import org.valenti.usermanagement.models.User;
import org.valenti.usermanagement.services.UserService;
import java.util.Optional;

@Controller
@RequestMapping(path="/user")
public class UserController {

    //UserRepository repository;
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //GET http://localhost:8080/user/hello
    @GetMapping(path="/hello")
    public @ResponseBody String sayHello(){
        return userService.sayHello();
    }

    //GET http://localhost:8080/user/all
    @GetMapping(path="/search/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //GET http://localhost:8080/user/search/{username}
    @GetMapping(path="/search/{username}")
    public @ResponseBody Iterable<User> searchUserByUsername(@PathVariable String username){
        return userService.searchUserByUsername(username);
    }

    //POST http://localhost:8080/user/auth/signup
    @PostMapping(path="/auth/signup")
    public @ResponseBody String signup(@RequestBody User newUser){
        return userService.signup(newUser);
    }

    //POST http://localhost:8080/user/auth/login
    @PostMapping(path="/auth/login")
    public @ResponseBody String login(@RequestBody LoginDTO credentials) {
        return userService.login(credentials);
    }

    //DELETE http://localhost:8080/user/{id}
    @DeleteMapping(path="/{id}")
    public @ResponseBody String deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserById(id);
    }
}