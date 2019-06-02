package com.example.meter.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="meter_readings")
@Entity
public class MeterReadings {

	@Id
	@Column(name="reading_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long readingId;
	
	@Column(name="meter_no")
	private String meterNo;
	
	@Column(name="reading")
	private Integer reading;
	
	@Column(name="last_reading")
	private Integer lastReading;
	
	
	@Column(name="date_time")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateTime;
	
	@Column(name="timestamp")
	private Long timestamp;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "meter_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	MeterMaster master;
	
	public String getMeterNo() {
		return meterNo;
	}

	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}

	public Integer getReading() {
		return reading;
	}

	public void setReading(Integer reading) {
		this.reading = reading;
	}

	public Integer getLastReading() {
		return lastReading;
	}

	public void setLastReading(Integer lastReading) {
		this.lastReading = lastReading;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	@JsonIgnore
	public MeterMaster getMaster() {
		return master;
	}

	public void setMaster(MeterMaster master) {
		this.master = master;
	}
	
	
}
