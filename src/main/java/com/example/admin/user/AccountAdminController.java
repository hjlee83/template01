package com.example.admin.user;

import com.example.common.account.AccountDto;
import com.example.common.account.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bequs-xhjlee on 2016-09-21.
 */
@Controller
@RequestMapping("/admin/account")
public class AccountAdminController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/list")
    public void list(Model model) {

        List<AccountDto.Response> responseList =
                accountService.findAll()
                        .parallelStream()
                        .map(account -> modelMapper.map(account, AccountDto.Response.class))
                        .collect(Collectors.toList());

        model.addAttribute(responseList);
    }
}
