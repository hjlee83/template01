package com.example.common.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bequs-xhjlee on 2016-09-21.
 */
@Service
@Slf4j
public class AccountDetailsService implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String ac) throws UsernameNotFoundException {

        Account account = accountService.getAccount(ac);

        if (account == null)
        {
            // 계정이 존재하지 않음
            throw new UsernameNotFoundException("login fail");
        }

        return new AccountDetails(account);
    }
}
