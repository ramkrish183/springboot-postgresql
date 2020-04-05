/**
 * 
 */
package com.rameshj.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rameshj.model.OrderInfo;
import com.rameshj.model.UserInformation;
import com.rameshj.repositories.OrderHistoryRepository;
import com.rameshj.repositories.UserInformationRepository;

/**
 * @author Ramesh
 *
 */
@Controller
@RequestMapping(path = "/orders")
public class OrderController {

	private Logger log=LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private OrderHistoryRepository orderhistoryrepo;

	@Autowired
	UserInformationRepository userInfoRepo;

	@GetMapping(path = "/getAllOrders")
	public @ResponseBody Iterable<OrderInfo> getAllUsers() {
		return orderhistoryrepo.findAll();
	}

	@PostMapping(path = "/createOrder/{firstName}")
	public @ResponseBody String createOrder(@PathVariable String firstName, @RequestBody OrderInfo orderInfo) {
		UserInformation userInfo = userInfoRepo.findByFirstName(firstName);
		orderInfo.setUserinfo(userInfo);
		orderhistoryrepo.save(orderInfo);
		log.info("Order has been saved");
		return "Order has been saved successfully";
	}

}
