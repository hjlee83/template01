package com.example.common.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bequs-xhjlee on 2016-09-21.
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account findOne(String id)
    {
        return accountRepository.findOne(id);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
