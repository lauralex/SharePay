package org.valenti.paymentmanagement.dto;

import org.valenti.paymentmanagement.models.SharedPayment;
import org.valenti.paymentmanagement.models.SharedPaymentContribution;

import java.util.List;

public class ExistingSharedPaymentDTO {
    private SharedPayment sharedPayment;
    private List<SharedPaymentContribution> friendsContributions;

    public ExistingSharedPaymentDTO() {}

    public ExistingSharedPaymentDTO(SharedPayment sharedPayment, List<SharedPaymentContribution> friendContributions) {
        this.sharedPayment = sharedPayment;
        this.friendsContributions = friendContributions;
    }

    public SharedPayment getSharedPayment() {
        return sharedPayment;
    }

    public ExistingSharedPaymentDTO setSharedPayment(SharedPayment sharedPayment) {
        this.sharedPayment = sharedPayment;
        return this;
    }

    public List<SharedPaymentContribution> getFriendContributions() {
        return friendsContributions;
    }

    public ExistingSharedPaymentDTO setFriendContributions(List<SharedPaymentContribution> friendContributions) {
        this.friendsContributions = friendContributions;
        return this;
    }
}
