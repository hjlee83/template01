package com.example.web.user;

import com.example.common.account.Account;
import com.example.common.account.AccountDto;
import com.example.common.account.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bequs-xhjlee on 2016-09-21.
 */
@Controller
@RequestMapping("/web/account")
@Slf4j
public class AccountController {

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

    @GetMapping("/read")
    public void read(Model model, Principal principal) {
        model.addAttribute("account", modelMapper.map(accountService.findOne(principal.getName()), AccountDto.Response.class));
    }

    @PostMapping("/read")
    public String save(Principal principal, @ModelAttribute @Valid AccountDto.Update updateDto, BindingResult bindingResult, RedirectAttributes rttr) {

        if(bindingResult.hasErrors()){
            return "/web/account/read";
        }

        Account oldAccount = accountService.findOne(principal.getName());
        oldAccount.setName(updateDto.getName());
        Account updatedAccount = accountService.save(oldAccount);

        rttr.addFlashAttribute(updatedAccount);
        rttr.addFlashAttribute("SUCCESS", true);
        return "redirect:/web/account/read";
    }
}
