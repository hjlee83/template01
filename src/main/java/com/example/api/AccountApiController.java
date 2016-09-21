package com.example.api;

import com.example.common.account.AccountDto;
import com.example.common.account.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bequs-xhjlee on 2016-09-21.
 */
@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/list")
    public List<AccountDto.Response> list() {

        List<AccountDto.Response> responseList =
                accountService.findAll()
                        .parallelStream()
                        .map(account -> modelMapper.map(account, AccountDto.Response.class))
                        .collect(Collectors.toList());

        return responseList;
    }
}
