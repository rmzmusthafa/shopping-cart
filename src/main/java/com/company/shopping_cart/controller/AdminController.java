package com.company.shopping_cart.controller;

import com.company.shopping_cart.form.ApiResponse;
import com.company.shopping_cart.form.UserForm;
import com.company.shopping_cart.services.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/server/admin")
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    private static final String ENTERED = "Entered AdminController : ";

    @Autowired
    private AdminService adminService;

    @GetMapping("/listAllCustomer")
    public List<UserForm> listAllCustomer(){
       LOGGER.info(ENTERED + "listAllCustomer");
       return adminService.listAllCustomer();
    }

    @PostMapping("/order/changeStatus")
    public ResponseEntity<ApiResponse>  changeStatus(@RequestParam("orderId") Long orderId){
        LOGGER.info(ENTERED + "changeStatus");
        return adminService.changeStatus(orderId);
    }

}
