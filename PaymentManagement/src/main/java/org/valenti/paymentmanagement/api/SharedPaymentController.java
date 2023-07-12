package org.valenti.paymentmanagement.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.valenti.paymentmanagement.dto.ExistingSharedPaymentDTO;
import org.valenti.paymentmanagement.dto.NewSharedPaymentDTO;
import org.valenti.paymentmanagement.models.SharedPayment;
import org.valenti.paymentmanagement.services.SharedPaymentService;

import java.util.List;

@Controller
@RequestMapping(path="/shared_payment")
public class SharedPaymentController {
    SharedPaymentService sharedPaymentService;

    public SharedPaymentController(SharedPaymentService sharedPaymentService) {
        this.sharedPaymentService = sharedPaymentService;
    }

    //GET http://localhost:8080/shared_payment/hello
    @GetMapping(path = "/hello")
    public @ResponseBody String sayHello() {
        return sharedPaymentService.sayHello();
    }

    /*
    @PostMapping(path = "/create")
    public @ResponseBody SharedPayment createSharedPayment(@RequestBody SharedPayment newSharedPayment) {
        return sharedPaymentService.createSharedPayment(newSharedPayment);
    }

     */

    @PostMapping(path = "/create")
    public @ResponseBody SharedPayment createSharedPayment(@RequestBody NewSharedPaymentDTO newSharedPayment) {
        return sharedPaymentService.createSharedPayment(newSharedPayment);
    }

    @GetMapping(path = "/get/createdBy/{id}")
    public @ResponseBody List<ExistingSharedPaymentDTO> getAllPaymentByCreator(@PathVariable Integer id) {
        return sharedPaymentService.getAllPaymentByCreator(id);
    }
}