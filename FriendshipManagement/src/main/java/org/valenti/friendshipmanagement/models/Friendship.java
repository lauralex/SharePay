package org.valenti.friendshipmanagement.models;


/*
    PROVA FORSE AD USARE NEO4J PER MODELLARE LE RELAZIONI DI AMICIZIA
 */

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message="the user requester parameter cannot be null!")
    private Integer requestingUser;

    @NotNull(message="the user acceptor parameter cannot be null!")
    private Integer acceptingUser;

    @CreationTimestamp
    private LocalDateTime friendshipStartDate;

    public Integer getId() {
        return id;
    }

    public Friendship setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getRequestingUser() {
        return requestingUser;
    }

    public Friendship setRequestingUser(Integer requestingUser) {
        this.requestingUser = requestingUser;
        return this;
    }

    public Integer getAcceptingUser() {
        return acceptingUser;
    }

    public Friendship setAcceptingUser(Integer acceptingUser) {
        this.acceptingUser = acceptingUser;
        return this;
    }

    public LocalDateTime getFriendshipStartDate() {
        return friendshipStartDate;
    }

    public Friendship setFriendshipStartDate(LocalDateTime friendshipStartDate) {
        this.friendshipStartDate = friendshipStartDate;
        return this;
    }

    @Override
    public String toString() {
        return "Friendship{" +
                "id=" + id +
                ", requestingUser=" + requestingUser +
                ", acceptingUser=" + acceptingUser +
                ", friendshipStartDate=" + friendshipStartDate +
                '}';
    }
}
