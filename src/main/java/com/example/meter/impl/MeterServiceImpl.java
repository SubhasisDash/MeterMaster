package com.example.meter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.meter.model.MeterMaster;
import com.example.meter.repository.MeterRepository;
import com.example.meter.service.MeterService;

@Service
public class MeterServiceImpl implements MeterService {

	@Autowired
	MeterRepository meterRepository;
	
	@Override
	public MeterMaster saveMeter(MeterMaster meter) {
		return meterRepository.save(meter);
	}

}
