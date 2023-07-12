package org.valenti.balancemanagement.model;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.valenti.balancemanagement.services.AccountBalanceService;

import java.util.Optional;

public interface AccountBalanceRepository extends CrudRepository<AccountBalance, Integer> {
    public Optional<AccountBalance> getAccountBalanceByUser(Integer user);

    @Modifying
    @Transactional
    @Query("UPDATE AccountBalance ab SET ab.availableBalance = ab.availableBalance + :amount WHERE ab.user = :user")
    void updateAvailableBalanceByUserId(@Param("user") Integer user, @Param("amount") Float amount);
}
