package com.example.common.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bequs-xhjlee on 2016-09-21.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
