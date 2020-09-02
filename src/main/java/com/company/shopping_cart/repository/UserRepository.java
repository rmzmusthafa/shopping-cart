package com.company.shopping_cart.repository;

import com.company.shopping_cart.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUserName(String userName);

    User findByEmailId(String emailId);

    User findByMobile(String mobile);

    Boolean existsByUserName(String username);

    Boolean existsByEmailId(String email);

    Boolean existsByMobile(String mobile);

    List<User> findByRoleId(Long roleId);


    List<User> findAllByRoleId(Long roleId);
}
