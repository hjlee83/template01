package com.example.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bequs-xhjlee on 2016-09-21.
 */
@Deprecated
@RestController
public class TestController {

    @GetMapping("/")
    public String index() {
        return "hello test world";
    }
}
