package com.company.shopping_cart.services.impl;

import com.company.shopping_cart.entity.Role;
import com.company.shopping_cart.repository.RoleRepository;
import com.company.shopping_cart.services.RoleService;
import com.company.shopping_cart.enums.RoleName;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(RoleName roleName) {

        try {
            Role role = roleRepository.findByName(roleName).get();
            return role;
        } catch (NoSuchElementException e) {
            throw new ServiceException("No such Role with RoleName:" + roleName, e);
        }

    }

}
