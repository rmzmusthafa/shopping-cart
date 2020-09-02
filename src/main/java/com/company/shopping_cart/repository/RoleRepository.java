package com.company.shopping_cart.repository;

import com.company.shopping_cart.entity.Role;
import com.company.shopping_cart.enums.RoleName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);
}
