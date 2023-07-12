package org.valenti.paymentmanagement.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SharedPaymentContributionRepository extends CrudRepository<SharedPaymentContribution, Integer> {
    List<SharedPaymentContribution> getSharedPaymentContributionsBySharedPayment(Integer sharedPaymentId);
}
