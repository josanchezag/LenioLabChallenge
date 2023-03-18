package com.leniolabs.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TEG_ACCOUNT")
public class Account {
    @Id
    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "DS_NAME", nullable = false)
    private String name;

    @Column(name = "DS_LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "DS_ACCOUNT_TYPE", nullable = false)
    private String accountType;

    @Column(name = "BALANCE", nullable = false)
    private Double balance;
}
