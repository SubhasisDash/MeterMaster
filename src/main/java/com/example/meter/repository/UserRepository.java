package com.example.meter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meter.model.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Long>{

	UserInfo findByUserName(String name);
}
