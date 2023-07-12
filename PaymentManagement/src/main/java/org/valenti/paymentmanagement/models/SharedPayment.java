package org.valenti.paymentmanagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class SharedPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message="the creator user cannot be null!")
    private Integer creatorUser;

    @NotNull(message="the shared payment description cannot be null!")
    @NotBlank(message="the shared payment description can't be blank!")
    private String description;

    @CreationTimestamp
    private LocalDateTime paymentCreationTime;

    @NotNull(message="the amount cannot be null!")
    private float totalAmount;

    /*
    @ElementCollection
    @NotEmpty(message="you cannot create a shared payment not being shared!")
    private List<Integer> friendsInvited;
     */

    @NotNull(message="the shared payment cannot have a null status")
    private boolean isCompleted = false;

    public SharedPayment() {}

    public SharedPayment(Integer creatorUser, String description, float totalAmount) {
        this.creatorUser = creatorUser;
        this.description = description;
        this.totalAmount = totalAmount;
    }

    public Integer getId() {
        return id;
    }

    public SharedPayment setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getCreatorUser() {
        return creatorUser;
    }

    public SharedPayment setCreatorUser(Integer creatorUser) {
        this.creatorUser = creatorUser;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SharedPayment setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getPaymentCreationTime() {
        return paymentCreationTime;
    }

    public SharedPayment setPaymentCreationTime(LocalDateTime paymentCreationTime) {
        this.paymentCreationTime = paymentCreationTime;
        return this;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public SharedPayment setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    /*
    public List<Integer> getFriendsInvited() {
        return friendsInvited;
    }

    public SharedPayment setFriendsInvited(List<Integer> friendsInvited) {
        this.friendsInvited = friendsInvited;
        return this;
    }
     */

    public boolean isCompleted() {
        return isCompleted;
    }

    public SharedPayment setCompleted(boolean completed) {
        isCompleted = completed;
        return this;
    }

    /*
    public float getSingleFeeAmount() {
        return totalAmount/(friendsInvited.size()+1);
    }


    @Override
    public String toString() {
        return "SharedPayment{" +
                "id=" + id +
                ", creatorUser=" + creatorUser +
                ", description='" + description + '\'' +
                ", paymentCreationTime=" + paymentCreationTime +
                ", totalAmount=" + totalAmount +
                ", friendsInvited=" + friendsInvited +
                ", isCompleted=" + isCompleted +
                '}';
    }

     */
}
