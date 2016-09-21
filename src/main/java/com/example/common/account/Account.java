package com.example.common.account;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by bequs-xhjlee on 2016-09-21.
 */
@Entity
@Table(name = "TBL_ACCOUNT")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String ac;

    private String pw;
}
