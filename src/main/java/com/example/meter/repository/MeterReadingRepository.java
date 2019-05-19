package com.example.meter.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.meter.model.MeterReadings;

@Repository
public interface MeterReadingRepository extends JpaRepository<MeterReadings, String>{

	@Transactional
	@Modifying
	@Query("update MeterReadings set reading=(?1) where meterNo=(?2)")
	void updateReading(Integer reading,String meterNo);
	
	/*@Query("select m from MeterReadings m where  between (?1) and (?2)")
	List<MeterReadings> findLastMonthReadings(Date curdate,Date lastmonth);*/
	
	List<MeterReadings> findByDateTimeBetween(Date curdate,Date lastmonth);
}
