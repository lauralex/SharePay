package org.valenti.friendshipmanagement.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.valenti.friendshipmanagement.dto.FriendshipListDTO;
import org.valenti.friendshipmanagement.dto.UserDTO;
import org.valenti.friendshipmanagement.models.Friendship;
import org.valenti.friendshipmanagement.services.FriendshipService;

import java.util.Optional;

@Controller
@RequestMapping(path="/friendship")
public class FriendshipController {

    FriendshipService friendshipService;

    public FriendshipController(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    //GET http://localhost:8080/friendship/hello
    @GetMapping(path="/hello")
    public @ResponseBody String sayHello(){
        return friendshipService.sayHello();
    }

    //POST http://localhost:8080/friendship/add => AGGIUNGI UNA NUOVA AMICIZIA DATI I DUE ID
    @PostMapping(path="/add")
    public @ResponseBody String signup(@RequestBody Friendship newFriendship){
        return friendshipService.addNewFriendship(newFriendship);
    }

    //GET http://localhost:8080/friendship/find/all => LISTA AMICI DATO UN CERTO ID
    @GetMapping(path="/find/all")
    public @ResponseBody FriendshipListDTO findAllFriends(@RequestBody UserDTO user){
        Iterable<Friendship> friendshipList = friendshipService.getAllFriends(user.getUserId());
        return new FriendshipListDTO(friendshipList);
    }
}
