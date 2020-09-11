package com.shopnobazz.bulksmsbd.Repository;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.domainsecurity.PasswordResetToken;
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
	  
	 PasswordResetToken findByToken(String token);

	    PasswordResetToken findByUser(User user);

	    Stream<PasswordResetToken> findAllByExpiryDateLessThan(Date now);

	    @Modifying
	    @Query("delete from PasswordResetToken t where t.expiryDate <= ?1")
	    void deleteAllExpiredSince(Date now);
}
