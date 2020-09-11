package com.shopnobazz.bulksmsbd.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shopnobazz.bulksmsbd.Repository.UserRepository;
import com.shopnobazz.bulksmsbd.domain.User;


@Service
public class UserSecurityService implements UserDetailsService{

	
	 @Autowired
	    private UserRepository userRepository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = userRepository.findByUsername(username);

	        if(null == user) {
	            throw new UsernameNotFoundException("Username not found");
	        }

	        return user;
	    }

}
