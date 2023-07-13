package org.valenti.balancemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.valenti.balancemanagement.model.AccountBalance;
import org.valenti.balancemanagement.services.AccountBalanceService;

@Controller
@RequestMapping(path="/balance")
public class AccountBalanceController {

    AccountBalanceService accountBalanceService;

    public AccountBalanceController(AccountBalanceService accountBalanceService) {
        this.accountBalanceService = accountBalanceService;
    }

    //GET http://localhost:8080/balance/hello
    @GetMapping(path = "/hello")
    public @ResponseBody String sayHello() {
        return accountBalanceService.sayHello();
    }

    //POST http://localhost:8080/balance/create/{id}
    @PostMapping(path = "/create/{userId}")
    public @ResponseBody AccountBalance sayHello(@PathVariable Integer userId) {
        return accountBalanceService.createBalance(userId);
    }

    //GET http://localhost:8080/balance/get/{id}
    @GetMapping(path = "/{userId}")
    public @ResponseBody Float getBalanceByUser(@PathVariable Integer userId) {
        return accountBalanceService.getBalanceByUser(userId);
    }

    //PUT http://localhost:8080/balance/{userId}/recharge/{amount}
    @PutMapping(path = "/{userId}/recharge/{amount}")
    public @ResponseBody void rechargeBalance(@PathVariable Integer userId, @PathVariable float amount) {
        accountBalanceService.rechargeBalance(userId, amount);
    }
}
