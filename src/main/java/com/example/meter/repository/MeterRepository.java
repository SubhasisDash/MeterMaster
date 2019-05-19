package com.example.meter.repository;

import org.springframework.stereotype.Repository;

import com.example.meter.model.MeterMaster;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MeterRepository extends JpaRepository<MeterMaster, Long>{

	List<MeterMaster> findByDept(String dept);
}
