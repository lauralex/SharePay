package org.valenti.authmanagement.dto;

public class LoginDTO {
    private String username, password;

    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public LoginDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
