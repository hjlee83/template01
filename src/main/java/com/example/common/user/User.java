package com.example.common.user;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by bequs-xhjlee on 2016-09-21.
 */
@Entity
@Table(name="TBL_USER")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
}
