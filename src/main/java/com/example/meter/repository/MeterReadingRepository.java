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
	
	@Query("select m from MeterReadings m where  dateTime between (?1) and (?2)")
	List<MeterReadings> findLastMonthReadings(Date curdate,Date lastmonth);
	
	//@Query("Select reading from MeterReadings mr where meterNo=(?1) order By dateTime ")
	
    @Query("SELECT mr.reading from MeterReadings mr where mr.dateTime=(Select MAX(dateTime) From MeterReadings where meterNo=(?1))")
	Integer findLatestReading(String meterNo);
}
