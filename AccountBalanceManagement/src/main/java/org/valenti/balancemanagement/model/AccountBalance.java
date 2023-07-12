package org.valenti.balancemanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class AccountBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "The balance is missing its user!")
    @Column(unique=true)
    private Integer user;

    @NotNull(message = "The balance is missing its amount!")
    private Float availableBalance;

    public AccountBalance() {}

    public AccountBalance(Integer user) {
        this.user = user;
        this.availableBalance = 0.0f;
    }

    public Integer getId() {
        return id;
    }

    public AccountBalance setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUser() {
        return user;
    }

    public AccountBalance setUser(Integer user) {
        this.user = user;
        return this;
    }

    public Float getAvailableBalance() {
        return availableBalance;
    }

    public AccountBalance setAvailableBalance(Float availableBalance) {
        this.availableBalance = availableBalance;
        return this;
    }

    @Override
    public String toString() {
        return "AccountBalance{" +
                "id=" + id +
                ", user=" + user +
                ", balance=" + availableBalance +
                '}';
    }
}
