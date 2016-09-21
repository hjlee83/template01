package com.example.common.account;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

    private String name;

    @ManyToMany
    private List<Role> roles;
/*
    public List<GrantedAuthority> getRoles() {

        List<GrantedAuthority> authorities = roles.parallelStream()
                .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        return authorities;
    }*/
}
