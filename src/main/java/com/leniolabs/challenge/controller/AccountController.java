package com.leniolabs.challenge.controller;

import com.leniolabs.challenge.calculator.factory.FeeCalculatorFactory;
import com.leniolabs.challenge.model.Account;
import com.leniolabs.challenge.repository.IAccountRepository;
import com.leniolabs.challenge.service.AccounServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/lenio-challenge/account/v1")
public class AccountController {

    @Autowired
    private AccounServiceIF accountControllerService;

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private FeeCalculatorFactory feeCalculatorFactory;

    @PostMapping(value = "/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(this.accountRepository.save(account));
    }

    @GetMapping(value = "/calculate-fee/{id}")
    public ResponseEntity<Double> calculateFee(@PathVariable String id) throws Exception {
        Account account=this.accountRepository.findById(id)
                .orElseThrow(() -> new Exception("The Id doesn't find it - " ));
        return ResponseEntity.ok(this.feeCalculatorFactory.calculateFee(account.getAccountType()));
    }
}
