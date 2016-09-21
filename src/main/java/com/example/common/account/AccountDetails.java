package com.example.common.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;

/**
 * Created by bequs-xhjlee on 2016-09-21.
 */
@Slf4j
public class AccountDetails extends User {

    public AccountDetails(Account account) {
      super(account.getAc(), account.getPw(), account.getRoles());
    }
}
