package com.jvdkolk.services;

import com.jvdkolk.entities.User;

import java.util.Optional;

public interface SimpleUserService {

    Optional<User> findUser(final String username);
}
