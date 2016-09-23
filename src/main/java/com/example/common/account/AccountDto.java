package com.example.common.account;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by bequs-xhjlee on 2016-09-21.
 */
public class AccountDto {

    @Data
    public static class Response {

        private String id;
        private String name;
    }

    @Data
    public static class Update {

        @NotBlank
        private String name;
    }

    @Data
    public static class UpdatePW {

        @NotBlank
        private String pw;
    }
}
