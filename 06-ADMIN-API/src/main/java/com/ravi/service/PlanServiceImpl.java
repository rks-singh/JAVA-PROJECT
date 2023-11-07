package com.ravi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.PlanEntity;
import com.ravi.repository.PlanRepository;
import com.ravi.request.PlanRequest;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepository planRepository;
	
	@Override
	public boolean savePlan(PlanRequest request) {
		try {
			PlanEntity planEntity = new PlanEntity();
			BeanUtils.copyProperties(request, planEntity);
			planEntity.setActiveSwitch("Y");
			planRepository.save(planEntity);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<PlanEntity> getPlans() {
		List<PlanEntity> plans = planRepository.findAll();
		return plans;
	}

}
