package com.company.shopping_cart.services;

import com.company.shopping_cart.entity.Role;
import com.company.shopping_cart.enums.RoleName;

public interface RoleService {
    Role findByName(RoleName roleName);
}
