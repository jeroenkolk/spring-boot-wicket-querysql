package com.jvdkolk.services;

import com.jvdkolk.entities.QUser;
import com.jvdkolk.entities.User;
import com.jvdkolk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SimpleUserServiceBean implements SimpleUserService {

    private final UserRepository userRepository;

    @Autowired
    public SimpleUserServiceBean(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUser(final String username) {
        //todo should be converted to an model/do object for usage in the web
        return userRepository.findOne(QUser.user.username.eq(username));
    }
}
