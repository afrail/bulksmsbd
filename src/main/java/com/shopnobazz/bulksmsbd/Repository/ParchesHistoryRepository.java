package com.shopnobazz.bulksmsbd.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shopnobazz.bulksmsbd.domain.ParchesHistory;
import com.shopnobazz.bulksmsbd.domain.User;

public interface ParchesHistoryRepository extends CrudRepository<ParchesHistory, Long>{
 List<ParchesHistory> findByUser(User user);
}
