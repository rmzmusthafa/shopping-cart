package com.company.shopping_cart.controller;

import com.company.shopping_cart.annotation.CurrentUser;
import com.company.shopping_cart.entity.User;
import com.company.shopping_cart.pojo.UserPrincipal;
import com.company.shopping_cart.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class TestController {

    @Autowired
    UserService userService ;
    @GetMapping("/test")
    public String getname(@CurrentUser UserPrincipal userPrincipal){
        User user = userService.findByMobile(userPrincipal.getMobile());
        return user.getName();
    }

}
