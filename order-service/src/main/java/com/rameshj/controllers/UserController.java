package com.rameshj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rameshj.model.UserInformation;
import com.rameshj.repositories.UserInformationRepository;

@Controller
@RequestMapping(path="/demo")
public class UserController {

	@Autowired
	private UserInformationRepository userInformationRepository;
	
	 @GetMapping(path="/all")
	  public @ResponseBody Iterable<UserInformation> getAllUsers() {
	    // This returns a JSON or XML with the users
	    return userInformationRepository.findAll();
	  }
	 
	 @PostMapping(path="/add") // Map ONLY POST Requests
	  public @ResponseBody String addNewUser (@RequestParam String name
	      , @RequestParam String phoneNumber) {
	    UserInformation userInfo= new UserInformation();
	    userInfo.setFirstName(name);
	    userInfo.setLastName(name);
	    userInfo.setPhoneNumber(Integer.parseInt(phoneNumber));
	    userInformationRepository.save(userInfo);
	    return "Saved";
	  }
}
