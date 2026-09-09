package com.example.banking.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class AccountCreateRequest {
    private BigDecimal initialBalance;
}