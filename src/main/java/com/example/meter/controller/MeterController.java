package com.example.meter.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.websocket.server.PathParam;

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
import com.example.meter.model.UserInfo;
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
	

	//saving and updating details of both meter master and readings
	@PostMapping("/save")
	public ResponseEntity<List<MeterMaster>> saveMeterDetails(@RequestBody List<MeterMaster> master) {		
		List<MeterMaster> saveMeter = meterService.saveMeter(master);
		return new ResponseEntity<>(saveMeter, HttpStatus.OK);
	}
	
	//find all details
	@GetMapping("/findall")
	public ResponseEntity<List<MeterMaster>> findAll() {		
		return new ResponseEntity<>(meterService.findAll(), HttpStatus.OK);
	}
	
	//get data by department name
	@GetMapping("/getdept")
	public ResponseEntity<List<MeterMaster>> saveMeterDetails(@PathParam(value = "dept") String dept) {		
		return new ResponseEntity<>(meterService.findDept(dept), HttpStatus.OK);
	}	
	
	//update data by passing json reading and meter
	/*{
		"reading":"11",
		"meter":"BF1/01"
	}*/
	@PostMapping("/updatereading")
	public ResponseEntity<MeterReadings> updateReading(@RequestBody Map<String,String> readings) {		
		try {
			meterService.updateReading(Integer.valueOf(readings.get("reading")),readings.get("meter"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(meterService.findByMeterId(readings.get("meter")), HttpStatus.OK);
	}
	
	//get last month readings
	@GetMapping("/lastmonthreadings")
	public ResponseEntity<List<MeterReadings>> getLastMonthReadings() {		
		return new ResponseEntity<>(meterService.findLastMonthReadings(), HttpStatus.OK);
	}
	
	//sum of readings of department for current month
	@GetMapping("/readingsum")
	public ResponseEntity<Map<String,Long>> getSumLastMonthReadings(@PathParam(value = "dept") String dept) {		
		Map<String,Long> map=new HashMap<>();
		map.putIfAbsent("sum", meterService.findLastMonthReadingsSum(dept));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}	
	
}
