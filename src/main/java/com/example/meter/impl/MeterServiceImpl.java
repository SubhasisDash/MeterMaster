package com.example.meter.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.meter.model.MeterMaster;
import com.example.meter.model.MeterReadings;
import com.example.meter.model.UserInfo;
import com.example.meter.repository.MeterReadingRepository;
import com.example.meter.repository.MeterRepository;
import com.example.meter.repository.UserRepository;
import com.example.meter.service.MeterService;

@Service
public class MeterServiceImpl implements MeterService {

	@Autowired
	MeterRepository meterRepository;
	
	@Autowired
	MeterReadingRepository meterReadingRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public MeterMaster saveMeter(MeterMaster meter) {
		return meterRepository.save(meter);
	}
	
	@Override
	public List<MeterMaster> findAll() {
		return meterRepository.findAll();
	}
	
	@Override
	public List<MeterMaster> findDept(String deptname) {
		return meterRepository.findByDept(deptname);
	}
	
	@Override
	public void updateReading(Integer reading,String meterNo) {
		meterReadingRepository.updateReading(reading,meterNo);
	}

	@Override
	public MeterReadings findByMeterId(String meterNo) {
		Optional<MeterReadings> findById = meterReadingRepository.findById(meterNo);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}
	
	@Override
	public List<MeterReadings> findLastMonthReadings() {
		Calendar c = Calendar.getInstance();
		Date date1 = c.getTime();
		c.add(Calendar.MONTH, -1);// then one month
		Date date2 = c.getTime();
		System.out.println(date2+ " " +date1);
		return meterReadingRepository.findByDateTimeBetween(date2,date1);
	}
	
	

	@Override
	public UserInfo findUser(String name) {
		return userRepository.findByUserName(name);
		
	}
	
	@Override
	public UserInfo saveUser(UserInfo user) {
		return userRepository.save(user);
		
	}
	
}
