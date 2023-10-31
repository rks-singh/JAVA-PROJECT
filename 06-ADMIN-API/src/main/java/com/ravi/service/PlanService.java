package com.ravi.service;

import java.util.List;

import com.ravi.entity.PlanEntity;
import com.ravi.model.Plan;

public interface PlanService {
	
	public String savePlan(Plan plan);
	public List<PlanEntity> getPlans();

}
