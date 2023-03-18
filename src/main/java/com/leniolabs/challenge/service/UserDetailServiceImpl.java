package com.leniolabs.challenge.service;

import com.leniolabs.challenge.model.Userg;
import com.leniolabs.challenge.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String userName){
        Userg us=repo.findOneByuserName(userName)
                .orElseThrow(()-> new UsernameNotFoundException(String.format("The user %s don't found",userName)))
                ;
        return new UserDetailsImpl(us);
    }

}
