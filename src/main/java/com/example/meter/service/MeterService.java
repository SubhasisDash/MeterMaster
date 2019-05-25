package com.example.meter.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.meter.model.MeterMaster;
import com.example.meter.model.MeterReadings;
import com.example.meter.model.UserInfo;

@Transactional
public interface MeterService {

	List<MeterMaster> saveMeter(List<MeterMaster> meter);
	
	List<MeterMaster> findDept(String deptname);

	void updateReading(Integer reading, String meterNo);

	List<MeterMaster> findAll();

	MeterReadings findByMeterId(String meterNo);

	UserInfo findUser(String name);

	UserInfo saveUser(UserInfo user);

	List<MeterReadings> findLastMonthReadings();
	
	Long findLastMonthReadingsSum(String dept);
}
