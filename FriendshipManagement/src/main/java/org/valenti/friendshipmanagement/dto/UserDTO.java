package org.valenti.friendshipmanagement.dto;

public class UserDTO {
    private Integer userId;

    public UserDTO() {}

    public UserDTO(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public UserDTO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                '}';
    }
}