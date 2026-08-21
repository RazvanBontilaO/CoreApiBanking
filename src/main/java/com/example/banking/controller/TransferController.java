package com.example.banking.controller;

import com.example.banking.dto.transferDto.TransferRequestDto;
import com.example.banking.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/api/v1/transfers")
    public ResponseEntity<String> transferMoney(@RequestBody TransferRequestDto request) {
        transferService.transferMoney(
                request.getFromAccountNumber(),
                request.getToAccountNumber(),
                request.getAmount());
        return ResponseEntity.ok("Transfer successful");
    }
}
