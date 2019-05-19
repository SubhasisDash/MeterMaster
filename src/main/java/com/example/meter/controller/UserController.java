package com.example.meter.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.meter.model.UserInfo;
import com.example.meter.service.MeterService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	MeterService meterService;
	
	@PostMapping("/checkuser")
	public ResponseEntity<Boolean> checkUser(@RequestBody UserInfo userInfo) {		
		UserInfo user = meterService.findUser(userInfo.getUserName());
		if(Objects.nonNull(user) && user.getPassword().equals(userInfo.getPassword())) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return new ResponseEntity<>(false, HttpStatus.OK);
	}
	
	@PostMapping("/saveuser")
	public ResponseEntity<UserInfo> saveUser(@RequestBody UserInfo userInfo) {		
		return new ResponseEntity<>( meterService.saveUser(userInfo), HttpStatus.OK);
	}
}
