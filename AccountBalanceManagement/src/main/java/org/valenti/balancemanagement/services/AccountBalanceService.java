package org.valenti.balancemanagement.services;

import org.springframework.stereotype.Service;
import org.valenti.balancemanagement.model.AccountBalance;
import org.valenti.balancemanagement.model.AccountBalanceRepository;

@Service
public class AccountBalanceService {
    AccountBalanceRepository accountBalanceRepository;

    public AccountBalanceService(AccountBalanceRepository accountBalanceRepository) {
        this.accountBalanceRepository = accountBalanceRepository;
    }

    public String sayHello() {
        return "Hello from the balance service!";
    }

    public AccountBalance createBalance(Integer userId) {
        return accountBalanceRepository.save(new AccountBalance(userId));
    }

    public Float getBalanceByUser(Integer userId) {
        return accountBalanceRepository.getAccountBalanceByUser(userId).get().getAvailableBalance();
    }

    public void rechargeBalance(Integer userId, Float amount) {
        accountBalanceRepository.updateAvailableBalanceByUserId(userId, amount);
    }
}
