package com.company.shopping_cart.services;

import com.company.shopping_cart.entity.User;

import java.util.List;

public interface UserService  {

    User createUser(User user);

    User updateUser(User user);

    User findByUserName(String userName);

    User findByEmailId(String emailId);

    User findByMobile(String mobile);

    Boolean existsByUserName(String username);

    Boolean existsByEmailId(String email);

    Boolean existsByMobile(String phone);

    List<User> listUsers();

}

