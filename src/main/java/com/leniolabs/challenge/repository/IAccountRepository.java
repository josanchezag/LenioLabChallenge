package com.leniolabs.challenge.repository;

import com.leniolabs.challenge.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository  extends JpaRepository<Account, String> {
}
