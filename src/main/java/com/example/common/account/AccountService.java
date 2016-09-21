package com.example.common.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bequs-xhjlee on 2016-09-21.
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccount(String ac)
    {
        return accountRepository.findOneByAc(ac);
    }
}
