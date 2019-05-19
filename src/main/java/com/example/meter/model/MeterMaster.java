package com.example.meter.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="meter_master")
@Entity
public class MeterMaster {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="dept")
	private String dept;
	
	@Column(name="meter_desc")
	private String meterDesc;
	
	@Column(name="entry_date")
	private Date entryDate;
	
	@Column(name="manual_reading")
	private Integer manualReading;
	
	@Column(name="update_flag")
	private boolean updateFlag;
	
	@Column(name="feeder")
	private String feeder;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "meter_number", referencedColumnName = "meter_no")
	MeterReadings readings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getMeterDesc() {
		return meterDesc;
	}

	public void setMeterDesc(String meterDesc) {
		this.meterDesc = meterDesc;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Integer getManualReading() {
		return manualReading;
	}

	public void setManualReading(Integer manualReading) {
		this.manualReading = manualReading;
	}

	public boolean isUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(boolean updateFlag) {
		this.updateFlag = updateFlag;
	}

	public String getFeeder() {
		return feeder;
	}

	public void setFeeder(String feeder) {
		this.feeder = feeder;
	}

	public MeterReadings getReadings() {
		return readings;
	}

	public void setReadings(MeterReadings readings) {
		this.readings = readings;
	}
	
}
