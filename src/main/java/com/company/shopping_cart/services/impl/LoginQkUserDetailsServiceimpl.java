package com.company.shopping_cart.services.impl;

import com.company.shopping_cart.entity.User;
import com.company.shopping_cart.pojo.UserPrincipal;
import com.company.shopping_cart.repository.UserRepository;
import com.company.shopping_cart.services.QkUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginQkUserDetailsServiceimpl implements QkUserDetailService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if (null == user) {
            throw new UsernameNotFoundException("User not found for Username:" + userName);
        }
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).get();
        if (null == user) {
            throw new UsernameNotFoundException("User not found with id:" + id);
        }

        return UserPrincipal.create(user);
    }

}


