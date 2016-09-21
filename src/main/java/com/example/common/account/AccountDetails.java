package com.example.common.account;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by bequs-xhjlee on 2016-09-21.
 */
public class AccountDetails extends User {

    public AccountDetails(Account account) {
        super(account.getAc(), account.getPw(), AuthorityUtils.createAuthorityList("USER"));
    }
}
