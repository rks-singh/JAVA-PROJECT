package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.PlanEntity;

public interface PlanRepository extends JpaRepository<PlanEntity, Integer>  {

}
