package org.valenti.friendshipmanagement.services;

import org.springframework.stereotype.Service;
import org.valenti.friendshipmanagement.models.Friendship;
import org.valenti.friendshipmanagement.models.FriendshipRepository;

import java.util.Optional;

@Service
public class FriendshipService {
    FriendshipRepository friendshipRepository;

    public FriendshipService(FriendshipRepository friendshipRepository) {
        this.friendshipRepository = friendshipRepository;
    }

    public String sayHello() {
        return "Hello from the friendship service!";
    }

    public String addNewFriendship(Friendship newFriendship) {
        friendshipRepository.save(newFriendship);
        return "New friendship registered!";
        /*
        try {
            friendshipRepository.save(newFriendship);
        } catch(Exception ex) {
            return "Exception: " + ex.getMessage();
        }
        return "New friendship registered!";
        */
    }

    public Iterable<Friendship> getAllFriends(Integer user) {
        return friendshipRepository.findByAcceptingUserOrRequestingUser(user, user);
    }
}
