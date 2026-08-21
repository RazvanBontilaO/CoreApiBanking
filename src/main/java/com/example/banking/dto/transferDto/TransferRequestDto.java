package com.example.banking.dto.transferDto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class TransferRequestDto {
    @NotBlank(message = "From account number cannot be blank")
    private String fromAccountNumber;
    @NotBlank(message = "To account number cannot be blank")
    private String toAccountNumber;
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    private BigDecimal amount;
}
