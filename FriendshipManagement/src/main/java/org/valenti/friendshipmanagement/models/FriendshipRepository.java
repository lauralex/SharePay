package org.valenti.friendshipmanagement.models;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FriendshipRepository extends CrudRepository<Friendship, Integer> {
    Iterable<Friendship> findByAcceptingUserOrRequestingUser(Integer user, Integer user2);
}
