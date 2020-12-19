package com.shopnobazz.bulksmsbd.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.shopnobazz.bulksmsbd.domain.SendingHistory;
import com.shopnobazz.bulksmsbd.domain.User;

public interface SendingHistoryRepositry extends CrudRepository<SendingHistory, Long>{
	List<SendingHistory> findByUser(User user);
}
