package com.example.banking;

import com.example.banking.model.Account;
import com.example.banking.model.User;
import com.example.banking.repository.AccountRepository;
import com.example.banking.repository.UserRepository;
import com.example.banking.service.TransferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
class TransferIntegrationTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine");

    @Autowired
    private TransferService transferService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        accountRepository.deleteAll();
        userRepository.deleteAll();

        User user = new User();
        user.setUsername("testuser");
        user.setPassword("encoded_password");
        userRepository.save(user);

        Account acc1 = new Account();
        acc1.setAccountNumber("RO01");
        acc1.setBalance(new BigDecimal("1000.00"));
        acc1.setUser(user);
        acc1.setVersion(0L);

        Account acc2 = new Account();
        acc2.setAccountNumber("RO02");
        acc2.setBalance(new BigDecimal("500.00"));
        acc2.setUser(user);
        acc2.setVersion(0L);

        accountRepository.save(acc1);
        accountRepository.save(acc2);
    }

    @Test
    void shouldTransferMoneySuccessfully() {
        transferService.transferMoney("RO01", "RO02", new BigDecimal("200.00"));

        Account acc1 = accountRepository.findByAccountNumber("RO01").orElseThrow();
        Account acc2 = accountRepository.findByAccountNumber("RO02").orElseThrow();

        assertThat(acc1.getBalance()).isEqualByComparingTo("800.00");
        assertThat(acc2.getBalance()).isEqualByComparingTo("700.00");
    }
}