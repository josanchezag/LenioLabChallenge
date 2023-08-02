package com.leniolabs.challenge.service;

import com.leniolabs.challenge.model.Account;
import com.leniolabs.challenge.repository.IAccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/** 
* AccountServiceImpl Tester. 
* 
* @author <Sanchez, Josimar>
* @since <pre>jul. 31, 2023</pre> 
* @version 1.0 
*/
@SpringBootTest
public class AccountServiceImplTest {
    @Mock
    public IAccountRepository accountRepository;

    @InjectMocks
    public AccountServiceImpl accountService;

@BeforeEach
public void before() {
    accountRepository = mock(IAccountRepository.class);
    accountService = new AccountServiceImpl();
    accountService.setAccountRepository(accountRepository);
}

/** 
* 
* Method: findById(String id) 
* 
*/ 
@Test
public void testFindById() throws Exception {
    MockitoAnnotations.openMocks(this);
    when(accountRepository.findById(anyString())).thenReturn(Optional.of(new Account()));
    Assertions.assertNotNull(accountService.findById("1023"));
} 

/** 
* 
* Method: save(Account account) 
* 
*/ 
@Test
public void testSave() throws Exception {
    MockitoAnnotations.openMocks(this);
    when(accountRepository.save(any(Account.class))).thenReturn(new Account());
    Account account=new Account();
    account.builder()
            .name("Test Account")
            .lastName("Test last account")
            .build();
    Assertions.assertNotNull(accountService.save(account));
} 


} 
