package com.example.api;

import com.example.common.account.Account;
import com.example.common.account.AccountDto;
import com.example.common.account.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bequs-xhjlee on 2016-09-21.
 */
@RestController
@RequestMapping("/api/account")
@Slf4j
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

    @PutMapping
    public ResponseEntity<?> changePWSave(Principal principal, @RequestBody @Valid AccountDto.UpdatePW updateDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }

        Account oldAccount = accountService.findOne(principal.getName());

        if (oldAccount == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        oldAccount.setPw(updateDto.getPw());
        Account account = accountService.save(oldAccount);

        return new ResponseEntity<>(modelMapper.map(account, AccountDto.Response.class), HttpStatus.OK);
    }
}
