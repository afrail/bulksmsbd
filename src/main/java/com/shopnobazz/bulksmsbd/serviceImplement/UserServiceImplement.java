package com.shopnobazz.bulksmsbd.serviceImplement;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopnobazz.bulksmsbd.Repository.PasswordResetTokenRepository;
import com.shopnobazz.bulksmsbd.Repository.RoleRepository;
import com.shopnobazz.bulksmsbd.Repository.UserRepository;
import com.shopnobazz.bulksmsbd.domain.Masking;
import com.shopnobazz.bulksmsbd.domain.NonMasking;
import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.domain.Wallet;
import com.shopnobazz.bulksmsbd.domainsecurity.PasswordResetToken;
import com.shopnobazz.bulksmsbd.domainsecurity.UserRole;
import com.shopnobazz.bulksmsbd.service.UserService;
@Service
public class UserServiceImplement implements UserService{
@Autowired
UserRepository userRepository;

@Autowired
RoleRepository roleRepository;

@Autowired
PasswordResetTokenRepository passwordResetTokenRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		 User localUser = userRepository.findByUsername(user.getUsername());

	        if(localUser != null) {
	           // LOG.info("user {} already exists. Nothing will be done.", user.getUsername());
	        } else {
	            for (UserRole ur : userRoles) {
	                roleRepository.save(ur.getRole());
	            }

	            user.getUserRoles().addAll(userRoles);
	            user.setEnabled(true);
	             
	             Masking masking = new Masking();
	             NonMasking nonMasking = new NonMasking();
	             Wallet wallet= new Wallet();
	             masking.setWallet(wallet);
	             nonMasking.setWallet(wallet);
	             wallet.setMasking(masking);
	             wallet.setNonMasking(nonMasking);
	             wallet.setUser(user);
	             user.setWallet(wallet);
	            localUser = userRepository.save(user);
	        }

	        return localUser;
	}
	 @Override
	    public User findByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }

	    @Override
	    public User findByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }
		@Override
		public void createPasswordResetTokenForUser(User user, String token) {
			 final PasswordResetToken myToken = new PasswordResetToken(token, user);
		        passwordResetTokenRepository.save(myToken);
			
		}

}
