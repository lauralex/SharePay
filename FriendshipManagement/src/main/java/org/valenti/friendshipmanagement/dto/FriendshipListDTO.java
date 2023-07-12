package org.valenti.friendshipmanagement.dto;

import org.valenti.friendshipmanagement.models.Friendship;

import java.util.Optional;

public class FriendshipListDTO {

    private Iterable<Friendship> friendships;

    public FriendshipListDTO() {}

    public FriendshipListDTO(Iterable<Friendship> friendships) {
        this.friendships = friendships;
    }

    public Iterable<Friendship> getFriendships() {
        return friendships;
    }

    public FriendshipListDTO setFriendships(Iterable<Friendship> friendships) {
        this.friendships = friendships;
        return this;
    }

    @Override
    public String toString() {
        return "FriendshipListDTO{" +
                "friendships=" + friendships +
                '}';
    }
}
