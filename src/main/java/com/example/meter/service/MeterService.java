package com.example.meter.service;

import org.springframework.transaction.annotation.Transactional;

import com.example.meter.model.MeterMaster;

@Transactional
public interface MeterService {

	MeterMaster saveMeter(MeterMaster meter);
}
