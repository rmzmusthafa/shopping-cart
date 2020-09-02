package com.company.shopping_cart.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface QkUserDetailService extends UserDetailsService {

    UserDetails loadUserById(Long userId);
}



