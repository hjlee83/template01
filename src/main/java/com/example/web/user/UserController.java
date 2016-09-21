package com.example.web.user;

import com.example.common.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bequs-xhjlee on 2016-09-21.
 */
@Controller
@RequestMapping("/web/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public void list(Model model) {
        String name = userService.find();
        model.addAttribute("name", name);
    }
}
