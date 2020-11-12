package com.shopnobazz.bulksmsbd.Repository;

import org.springframework.data.repository.CrudRepository;

import com.shopnobazz.bulksmsbd.domain.NonMasking;
import com.shopnobazz.bulksmsbd.domain.Wallet;

public interface NonMaskingRepository extends CrudRepository<NonMasking, Long>{
NonMasking findByWallet(Wallet wallet);

}
