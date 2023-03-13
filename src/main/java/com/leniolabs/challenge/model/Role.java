package com.leniolabs.challenge.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TEG_ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;


    @Column(name = "DS_DESCRIPTION", nullable = false)
    private String dsDescription;

    @Column(name = "DS_SHORT_NAME", nullable = false)
    private String dsShortName;
}
