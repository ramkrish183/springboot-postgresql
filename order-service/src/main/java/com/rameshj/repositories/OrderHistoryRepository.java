package com.rameshj.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rameshj.model.OrderInfo;

@Repository
public interface OrderHistoryRepository extends CrudRepository<OrderInfo,Integer> {

}
