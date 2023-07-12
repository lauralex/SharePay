package org.valenti.paymentmanagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class SharedPaymentContribution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message="the contribution cannot miss the shared payment it is part of!")
    private Integer sharedPayment;

    @NotNull(message="The contribution is missing any participating user!")
    private Integer contributingUser;

    @NotNull(message="The contribution is missing the amount to pay!")
    private float contributionAmount;

    @NotNull(message="The contribution cannot have a null status!")
    private boolean isPaid;

    public SharedPaymentContribution(Integer sharedPayment, Integer contributingUser, float contributionAmount) {
        this.sharedPayment = sharedPayment;
        this.contributingUser = contributingUser;
        this.contributionAmount = contributionAmount;
        this.isPaid = false;
    }

    public SharedPaymentContribution() {}

    public Integer getId() {
        return id;
    }

    public SharedPaymentContribution setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getSharedPayment() {
        return sharedPayment;
    }

    public SharedPaymentContribution setSharedPayment(Integer sharedPayment) {
        this.sharedPayment = sharedPayment;
        return this;
    }

    public Integer getContributingUser() {
        return contributingUser;
    }

    public SharedPaymentContribution setContributingUser(Integer contributingUser) {
        this.contributingUser = contributingUser;
        return this;
    }

    public float getContributionAmount() {
        return contributionAmount;
    }

    public SharedPaymentContribution setContributionAmount(float contributionAmount) {
        this.contributionAmount = contributionAmount;
        return this;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public SharedPaymentContribution setPaid(boolean paid) {
        isPaid = paid;
        return this;
    }

    @Override
    public String toString() {
        return "ParticipationFee{" +
                "id=" + id +
                ", sharedPayment=" + sharedPayment +
                ", contributingUser=" + contributingUser +
                ", contributionAmount=" + contributionAmount +
                ", isPaid=" + isPaid +
                '}';
    }
}