package com.example.meter.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.meter.model.MeterMaster;
import com.example.meter.model.MeterReadings;
import com.example.meter.service.MeterService;

@RestController
@RequestMapping("/meter")
public class MeterController {

	@Autowired
	MeterService meterService;
	

	@GetMapping("/test")
	public ResponseEntity<String> getDetails() {
		return new ResponseEntity<>("Hello GG", HttpStatus.OK);
	}
	
	@GetMapping("/testsave")
	public ResponseEntity<MeterMaster> saveMeter() {
		
		MeterReadings readings=new MeterReadings();
		readings.setMeterNo("BF1/01");
		readings.setDateTime(new Date());
		readings.setLastReading(12323);
		readings.setTimestamp(System.currentTimeMillis());
		
		MeterMaster master=new MeterMaster();
		master.setDept("Blast Furnace");
		master.setEntryDate(new Date());
		master.setFeeder("HTSS INCOMER 01");
		master.setMeterDesc("33 KV");
		master.setReadings(readings);
		
		MeterMaster saveMeter = meterService.saveMeter(master);
		return new ResponseEntity<>(saveMeter, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<MeterMaster> saveMeterDetails(@RequestBody MeterMaster master) {		
		MeterMaster saveMeter = meterService.saveMeter(master);
		return new ResponseEntity<>(saveMeter, HttpStatus.OK);
	}
	
}
