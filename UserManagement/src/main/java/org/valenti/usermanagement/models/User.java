package org.valenti.usermanagement.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/*
Ogni User deve avere:
id: un intero univoco AUTO generato dal tool ORM
username: un nickname identificativo univoco
name: una stringa obbligatoria
surname: una stringa obbligatoria
email: una stringa univoca obbligatoria
password: una stringa obbligatoria
 */

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message="the name parameter cannot be null!")
    @NotBlank(message="the name parameter cannot be blank!")
    @Column(unique=true)
    private String username;

    @NotNull(message="the name parameter cannot be null!")
    @NotBlank(message="the name parameter cannot be blank!")
    private String name;

    @NotNull(message="the name parameter cannot be null!")
    @NotBlank(message="the name parameter cannot be blank!")
    private String surname;

    @NotNull(message="the name parameter cannot be null!")
    @NotBlank(message="the name parameter cannot be blank!")
    @Column(unique=true) //deve essere univoco: userò l'attributo email nella business logic:
    private String email;        // constraint: non possono esserci customer con stessa email

    @NotNull(message="the name parameter cannot be null!")
    @NotBlank(message="the name parameter cannot be blank!")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username = '" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + name + '\'' +
                ", email='" + email + '\'' +
                ", psw='" + password + '\'' +
                '}';
    }
}
