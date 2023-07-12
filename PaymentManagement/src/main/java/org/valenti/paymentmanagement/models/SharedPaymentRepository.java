package org.valenti.paymentmanagement.models;

import org.springframework.data.repository.CrudRepository;
import org.valenti.paymentmanagement.dto.ExistingSharedPaymentDTO;

import java.util.List;

public interface SharedPaymentRepository extends CrudRepository<SharedPayment, Integer> {
    //List<SharedPayment> getSharedPaymentByCreatorUser(Integer creatorUser);
    List<SharedPayment> getSharedPaymentByCreatorUser(Integer creatorUser);

}
