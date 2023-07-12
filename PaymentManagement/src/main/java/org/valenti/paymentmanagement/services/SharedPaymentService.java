package org.valenti.paymentmanagement.services;

import org.springframework.stereotype.Service;
import org.valenti.paymentmanagement.dto.ExistingSharedPaymentDTO;
import org.valenti.paymentmanagement.dto.NewSharedPaymentDTO;
import org.valenti.paymentmanagement.models.SharedPaymentContribution;
import org.valenti.paymentmanagement.models.SharedPaymentContributionRepository;
import org.valenti.paymentmanagement.models.SharedPayment;
import org.valenti.paymentmanagement.models.SharedPaymentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SharedPaymentService {

    SharedPaymentRepository sharedPaymentRepository;
    SharedPaymentContributionRepository sharedPaymentContributionRepository;

    public SharedPaymentService(SharedPaymentRepository sharedPaymentRepository, SharedPaymentContributionRepository sharedPaymentContributionRepository) {
        this.sharedPaymentRepository = sharedPaymentRepository;
        this.sharedPaymentContributionRepository = sharedPaymentContributionRepository;
    }

    public String sayHello() {
        return "Hello from the shared payments service!";
    }

    /*
    public SharedPayment createSharedPayment(SharedPayment newSharedPayment) {
        SharedPayment paymentCreated = sharedPaymentRepository.save(newSharedPayment);

        for(Integer friendInvited : newSharedPayment.getFriendsInvited()) {
            SharedPaymentContribution newSharedPaymentContribution = new SharedPaymentContribution(paymentCreated.getId(), friendInvited, paymentCreated.getSingleFeeAmount());
            sharedPaymentContributionRepository.save(newSharedPaymentContribution);
        }
        return paymentCreated;
    }

     */

    public SharedPayment createSharedPayment(NewSharedPaymentDTO newSharedPayment) {
        //SharedPayment paymentToCreate = new SharedPayment(newSharedPayment.getCreatorUser(), newSharedPayment.getDescription(), newSharedPayment.getTotalAmount());

        SharedPayment sharedPaymentCreated = sharedPaymentRepository.save(new SharedPayment(newSharedPayment.getCreatorUser(), newSharedPayment.getDescription(), newSharedPayment.getTotalAmount()));

        for(Integer friendInvited : newSharedPayment.getFriendsInvited()) {
            SharedPaymentContribution newSharedPaymentContribution = new SharedPaymentContribution(sharedPaymentCreated.getId(), friendInvited, newSharedPayment.getSingleFeeAmount());
            sharedPaymentContributionRepository.save(newSharedPaymentContribution);
        }
        return sharedPaymentCreated;
    }

    public List<ExistingSharedPaymentDTO> getAllPaymentByCreator(Integer userId) {
        List<SharedPayment> existingSharedPayments = sharedPaymentRepository.getSharedPaymentByCreatorUser(userId);

        List<ExistingSharedPaymentDTO> existingSharedPaymentsDTO = new ArrayList<>();

        for(SharedPayment existingSharedPayment : existingSharedPayments) {
            List<SharedPaymentContribution> friendsContributions = sharedPaymentContributionRepository.getSharedPaymentContributionsBySharedPayment(existingSharedPayment.getId());

            existingSharedPaymentsDTO.add(new ExistingSharedPaymentDTO(existingSharedPayment, friendsContributions));
        }
        return existingSharedPaymentsDTO;
    }
}
