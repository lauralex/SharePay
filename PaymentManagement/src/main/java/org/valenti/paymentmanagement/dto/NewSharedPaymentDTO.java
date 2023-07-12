package org.valenti.paymentmanagement.dto;

import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

public class NewSharedPaymentDTO {
    @NotNull(message="the creator user cannot be null!")
    private Integer creatorUser;

    @NotNull(message="the shared payment description cannot be null!")
    @NotBlank(message="the shared payment description can't be blank!")
    private String description;

    @CreationTimestamp
    private LocalDateTime paymentCreationTime;

    @NotNull(message="the amount cannot be null!")
    private float totalAmount;

    @ElementCollection
    @NotEmpty(message="you cannot create a shared payment not being shared!")
    private List<Integer> friendsInvited;

    public NewSharedPaymentDTO() {}

    public NewSharedPaymentDTO(Integer creatorUser, String description, LocalDateTime paymentCreationTime, float totalAmount, List<Integer> friendsInvited) {
        this.creatorUser = creatorUser;
        this.description = description;
        this.paymentCreationTime = paymentCreationTime;
        this.totalAmount = totalAmount;
        this.friendsInvited = friendsInvited;
    }

    public Integer getCreatorUser() {
        return creatorUser;
    }

    public NewSharedPaymentDTO setCreatorUser(Integer creatorUser) {
        this.creatorUser = creatorUser;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public NewSharedPaymentDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getPaymentCreationTime() {
        return paymentCreationTime;
    }

    public NewSharedPaymentDTO setPaymentCreationTime(LocalDateTime paymentCreationTime) {
        this.paymentCreationTime = paymentCreationTime;
        return this;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public NewSharedPaymentDTO setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public List<Integer> getFriendsInvited() {
        return friendsInvited;
    }

    public float getSingleFeeAmount() {
        return totalAmount/(friendsInvited.size()+1);
    }

    public NewSharedPaymentDTO setFriendsInvited(List<Integer> friendsInvited) {
        this.friendsInvited = friendsInvited;
        return this;
    }
}
