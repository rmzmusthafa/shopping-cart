package com.company.shopping_cart.services;

import com.company.shopping_cart.form.ApiResponse;
import com.company.shopping_cart.form.UserForm;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {

    List<UserForm> listAllCustomer();

    ResponseEntity<ApiResponse> changeStatus(Long orderId);
}
