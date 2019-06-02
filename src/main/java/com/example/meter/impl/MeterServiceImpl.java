package com.example.meter.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
	public List<MeterMaster> saveMeter(List<MeterMaster> meter) {
		return meterRepository.saveAll(meter);
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
		return meterReadingRepository.findLastMonthReadings(date2,date1);
	}
	
	@Override
	public Long findLastMonthReadingsSum(String dept) {
//		List<MeterMaster> findByDept = meterRepository.findByDept(dept);
//		Calendar cal1 = Calendar.getInstance();
//		Long sum=0l;
//		for(MeterMaster p:findByDept) {
//			MeterReadings readings = p.getReadings();
//			if(Objects.nonNull(readings)) {
//				Calendar cal2=Calendar.getInstance();	
//				cal2.setTime(readings.getDateTime());
//				if((cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) && (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)))
//				{
//					sum= sum+ readings.getReading();
//				}
//			}	
//		}
		return 0l;
	}

	@Override
	public UserInfo findUser(String name) {
		return userRepository.findByUserName(name);
		
	}
	
	@Override
	public UserInfo saveUser(UserInfo user) {
		return userRepository.save(user);
		
	}

	@Override
	public void saveMeterReading(MeterReadings readings) {
		MeterMaster master=meterRepository.findByMeterNo(readings.getMeterNo());
		readings.setMaster(master);
		Integer lastReading=meterReadingRepository.findLatestReading(readings.getMeterNo());
		if (lastReading!=null) {
			readings.setLastReading(lastReading);
		}
		else {
			readings.setLastReading(readings.getReading());
		}
		meterReadingRepository.save(readings);
		
	}
	
}
