package com.example.banking.controller;

import com.example.banking.dto.AccountCreateRequest;
import com.example.banking.model.Account;
import com.example.banking.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(
            Authentication authentication,
            @RequestBody AccountCreateRequest request) {

        String currentUsername = authentication.getName();

        Account createdAccount = accountService.createAccountForUser(currentUsername, request.getInitialBalance());
        return ResponseEntity.ok(createdAccount);
    }
}