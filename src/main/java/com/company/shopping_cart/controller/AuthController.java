package com.company.shopping_cart.controller;

import com.company.shopping_cart.form.AppSignUpRequest;
import com.company.shopping_cart.form.LoginRequest;
import com.company.shopping_cart.services.AuthService;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/server")
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    private static final String ENTERED = "Entered AuthController : ";

    private static final String Exception = "Exception at Auth method :";

    @Autowired
    private AuthService authService;

    @PostMapping("/api/auth/admin/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        LOGGER.info(ENTERED + "authenticateUser Method");
        try {
            return authService.authenticateUser(loginRequest);
        } catch (ServiceException e) {
            throw new ServiceException(Exception + "authenticateUser");
        }
    }

    @PostMapping("/api/auth/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody AppSignUpRequest signUpRequest) {
        LOGGER.info(ENTERED + "registerUser Method");
        return authService.registerUser(signUpRequest);

    }

}