package com.shopnobazz.bulksmsbd.Repository;

import org.springframework.data.repository.CrudRepository;

import com.shopnobazz.bulksmsbd.domain.User;
import com.shopnobazz.bulksmsbd.domain.Wallet;

public interface WalletRepository extends CrudRepository<Wallet, Long>{
Wallet findByUser(User user);
}
