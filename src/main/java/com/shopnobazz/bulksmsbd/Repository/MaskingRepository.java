package com.shopnobazz.bulksmsbd.Repository;

import org.springframework.data.repository.CrudRepository;

import com.shopnobazz.bulksmsbd.domain.Masking;
import com.shopnobazz.bulksmsbd.domain.Wallet;

public interface MaskingRepository extends CrudRepository<Masking, Long>{
Masking  findByWallet(Wallet wallet);

}
