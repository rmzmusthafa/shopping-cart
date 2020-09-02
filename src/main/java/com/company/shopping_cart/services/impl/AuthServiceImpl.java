package com.company.shopping_cart.services.impl;

import com.company.shopping_cart.entity.Role;
import com.company.shopping_cart.entity.User;
import com.company.shopping_cart.enums.RoleName;
import com.company.shopping_cart.enums.StatusEnum;
import com.company.shopping_cart.form.ApiResponse;
import com.company.shopping_cart.form.AppSignUpRequest;
import com.company.shopping_cart.form.JwtAuthenticationResponse;
import com.company.shopping_cart.form.LoginRequest;
import com.company.shopping_cart.security.JwtTokenProvider;
import com.company.shopping_cart.services.AuthService;
import com.company.shopping_cart.services.RoleService;
import com.company.shopping_cart.services.UserService;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;



    @Override
    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
        String username = loginRequest.getUsernameOrEmail();
        User requestUser = getUserByEmailOrPhone(username);
        if (requestUser==null){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "email or mobile not found!"),
                    HttpStatus.UNAUTHORIZED);
        }
        username = requestUser.getUserName();

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(username, loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());

        String jwt = tokenProvider.generateAccessToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @Override
    @Transactional
    public ResponseEntity<?> registerUser(AppSignUpRequest signUpRequest) {
        if (userService.existsByUserName(signUpRequest.getUserName())) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if (userService.existsByEmailId(signUpRequest.getEmailId())) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        if (userService.existsByMobile(signUpRequest.getMobile())) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Phone Number already registered!"),
                    HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setUserName(signUpRequest.getUserName());
        user.setEmailId(signUpRequest.getEmailId());
        user.setPassword(signUpRequest.getPassword());
        user.setMobile(signUpRequest.getMobile());
        Date date = new Date();
        user.setStatusId(StatusEnum.ACTIVE.getStatusId());
        user.setRoleId(signUpRequest.getRoleId());
        user.setCreatedTime(date);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        switch (signUpRequest.getRoleId().intValue()) {
            case 1:
                Role admin = roleService.findByName(RoleName.ROLE_ADMIN);
                user.setRoles(Collections.singleton(admin));
                break;
            case 2:
                Role owner = roleService.findByName(RoleName.ROLE_USER);
                user.setRoles(Collections.singleton(owner));
                break;
            default:
                break;
        }


        User result = userService.createUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUserName()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));

    }

    private User getUserByUsernameOrEmail(String usernameOrEmail) {

        try {
            User user = userService.findByUserName(usernameOrEmail);
            return user;
        } catch (ServiceException se) {
            return userService.findByEmailId(usernameOrEmail);

        }
    }

    private User getUserByEmailOrPhone(String emailOrPhone) {

        try {
            User user = userService.findByUserName(emailOrPhone);
            return user;
        } catch (ServiceException se) {
            return userService.findByMobile(emailOrPhone);

        }
    }

}
