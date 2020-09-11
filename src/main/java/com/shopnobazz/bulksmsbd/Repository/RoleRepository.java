package com.shopnobazz.bulksmsbd.Repository;

import org.springframework.data.repository.CrudRepository;

import com.shopnobazz.bulksmsbd.domainsecurity.Role;
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}

