package com.shopnobazz.bulksmsbd.service;

import java.util.Set;

import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.domainsecurity.UserRole;



public interface UserService {
	User findByUsername(String username);
	void createPasswordResetTokenForUser(final User user, final String token);
    User findByEmail(String email);
    User createUser(User user, Set<UserRole> userRoles) throws Exception;
}
