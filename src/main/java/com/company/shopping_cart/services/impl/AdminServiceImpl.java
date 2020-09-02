package com.company.shopping_cart.services.impl;

import com.company.shopping_cart.entity.Order;
import com.company.shopping_cart.entity.User;
import com.company.shopping_cart.enums.OrderStatus;
import com.company.shopping_cart.enums.RoleName;
import com.company.shopping_cart.form.ApiResponse;
import com.company.shopping_cart.form.UserForm;
import com.company.shopping_cart.repository.OrderRepo;
import com.company.shopping_cart.repository.UserRepository;
import com.company.shopping_cart.services.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.plaf.basic.BasicEditorPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public List<UserForm> listAllCustomer() {
        List<User> users = userRepository.findAllByRoleId(RoleName.ROLE_USER.getRoleId());
        List<UserForm> userForms = new ArrayList<>();
        for (User user : users){
            UserForm userForm = new UserForm();
            BeanUtils.copyProperties(user,userForm);
            userForms.add(userForm);
        }
        return userForms ;
    }

    @Override
    public ResponseEntity<ApiResponse> changeStatus(Long orderId) {
        Optional<Order> orderOptional = orderRepo.findById(orderId);
        if (orderOptional.isPresent()){
            orderOptional.get().setOrderStatus(OrderStatus.COMPLETED.getId());
            orderRepo.save(orderOptional.get());
            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Order Status changed!"),
                    HttpStatus.OK);
        }
        return new ResponseEntity<ApiResponse>(new ApiResponse(false, "order not found!"),
                HttpStatus.OK);
    }
}
