package com.example.meter.repository;

import org.springframework.stereotype.Repository;

import com.example.meter.model.MeterMaster;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MeterRepository extends JpaRepository<MeterMaster, Long>{

}
