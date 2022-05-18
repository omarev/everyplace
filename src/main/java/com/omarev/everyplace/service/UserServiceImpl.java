package com.omarev.everyplace.service;

import com.omarev.everyplace.entity.Place;
import com.omarev.everyplace.entity.User;
import com.omarev.everyplace.repository.PlaceRepository;
import com.omarev.everyplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }
}
