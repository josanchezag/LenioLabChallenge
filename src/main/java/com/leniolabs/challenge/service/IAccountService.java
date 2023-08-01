package com.leniolabs.challenge.service;

import com.leniolabs.challenge.model.Account;

import java.util.Optional;

public interface IAccountService {
    public Optional<Account> findById(String id);
    public Account save(Account acount);
}
