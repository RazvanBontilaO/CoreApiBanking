package com.example.banking.service;

import com.example.banking.model.Account;
import com.example.banking.model.User;
import com.example.banking.repository.AccountRepository;
import com.example.banking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public Account createAccountForUser(String username, BigDecimal initialBalance) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Account account = new Account();
        account.setAccountNumber("RO" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20).toUpperCase());
        account.setBalance(initialBalance != null ? initialBalance : BigDecimal.ZERO);
        account.setUser(user);
        account.setVersion(0L);

        return accountRepository.save(account);
    }
}