package com.ravi.service;

import java.util.List;

import com.ravi.entity.PlanEntity;
import com.ravi.request.PlanRequest;

public interface PlanService {

	public boolean savePlan(PlanRequest request);

	public List<PlanEntity> getPlans();

}
