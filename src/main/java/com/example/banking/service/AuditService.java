package com.example.banking.service;

import com.example.banking.model.Status;
import com.example.banking.model.Transaction;
import com.example.banking.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AuditService {

    private final TransactionRepository transactionRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void logTransaction(String fromAccountNumber, String toAccountNumber, BigDecimal amount, Status status) {
        Transaction transaction = new Transaction(fromAccountNumber, toAccountNumber,
                amount, status);
        transactionRepository.save(transaction);
    }
}
