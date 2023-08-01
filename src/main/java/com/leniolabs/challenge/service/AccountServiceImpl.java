package com.leniolabs.challenge.service;

import com.leniolabs.challenge.model.Account;
import com.leniolabs.challenge.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService{
    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public Optional<Account> findById(String id) {

        return id.isEmpty()?null:accountRepository.findById(id);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
