package com.company.shopping_cart.services;

import com.company.shopping_cart.form.AppSignUpRequest;
import com.company.shopping_cart.form.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<?> authenticateUser(LoginRequest loginRequest);

    ResponseEntity<?> registerUser(AppSignUpRequest signUpRequest);

}
