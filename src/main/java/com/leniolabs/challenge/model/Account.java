package com.leniolabs.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private String id;
    private String name;
    private String lastName;
    private String accountType;
    private Double balance;
}
