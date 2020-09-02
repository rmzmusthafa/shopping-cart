package com.company.shopping_cart.services.impl;

import com.company.shopping_cart.entity.User;
import com.company.shopping_cart.repository.UserRepository;
import com.company.shopping_cart.services.UserService;
import com.company.shopping_cart.enums.RoleName;
import com.company.shopping_cart.enums.StatusEnum;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User findByUserName(String userName) {
        User user = userRepository.findByUserName(userName);
        if (null == user) {
            LOGGER.error("No Such User with userName:" + userName);
            throw new ServiceException("No Such User with userName:" + userName);
        }
        return user;
    }

    @Override
    @Transactional
    public User findByEmailId(String emailId) {
        User user = userRepository.findByEmailId(emailId);
        if (null == user) {
            LOGGER.error("No Such User with username/email:" + emailId);
            throw new ServiceException("No Such User with username/email:" + emailId);
        }
        return user;
    }

    @Override
    @Transactional
    public User findByMobile(String mobile) {
        User user = userRepository.findByMobile(mobile);
        if (null == user) {
            LOGGER.error("No Such User with email/phone:" + mobile);
            throw new ServiceException("No Such User with email/phone:" + mobile);
        }
        return user;
    }

    @Override
    @Transactional
    public Boolean existsByUserName(String username) {
        return userRepository.existsByUserName(username);
    }

    @Override
    @Transactional
    public Boolean existsByEmailId(String email) {
        return userRepository.existsByEmailId(email);
    }

    @Override
    @Transactional
    public Boolean existsByMobile(String phone) {
        return userRepository.existsByMobile(phone);
    }

    @Override
    public List<User> listUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        users.removeIf(u -> u.getStatusId().equals(StatusEnum.INACTIVE.getStatusId()));
        return users;
    }



}