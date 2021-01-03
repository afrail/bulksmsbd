package com.shopnobazz.bulksmsbd;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.domainsecurity.Role;
import com.shopnobazz.bulksmsbd.domainsecurity.UserRole;
import com.shopnobazz.bulksmsbd.service.UserService;
import com.shopnobazz.bulksmsbd.utility.SecurityUtility;

@SpringBootApplication
public class bulksms implements CommandLineRunner {
@Autowired
UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(bulksms.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUsername("kazi");
		user.setEmail("kazi35-2060@diu.edu.bd");
		user.setEnabled(true);
		user.setFirstName("Bashirul");
		user.setLastName("Islam");
		user.setPassword(SecurityUtility.passwordEncoder().encode("1"));
		user.setPhone("01518335758");
		Set<UserRole> userRoles = new HashSet<>();
		Role role = new Role();
		role.setRoleId(3);
		role.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user, role));
		userService.createUser(user, userRoles);
	}
}
