package com.example.common.account;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;

/**
 * Created by bequs-xhjlee on 2016-09-21.
 */
@Slf4j
public class AccountDetails extends User {

    @Getter
    private String name;

    public AccountDetails(Account account) {
      super(account.getId(), account.getPw(), account.getRoles());
        this.name = account.getName();
    }
}
