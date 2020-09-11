package com.shopnobazz.bulksmsbd.Repository;

import org.springframework.data.repository.CrudRepository;

import com.shopnobazz.bulksmsbd.domain.User;
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);
    
}

