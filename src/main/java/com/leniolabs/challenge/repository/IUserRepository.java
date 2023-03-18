package com.leniolabs.challenge.repository;


import com.leniolabs.challenge.model.Userg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository  extends JpaRepository<Userg, Integer> {
    public Optional<Userg> findOneByuserName(String userName);
}

