package com.ravi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.PlanEntity;
import com.ravi.model.Plan;
import com.ravi.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepository planRepository;
	
	@Override
	public String savePlan(Plan plan) {
		try {
			PlanEntity planEntity = new PlanEntity();
			BeanUtils.copyProperties(plan, planEntity);
			planEntity.setActiveSwitch("Y");
			planRepository.save(planEntity);
		}catch (Exception e) {
			return "Plan Not Created";
		}
		return "Plan Created";
	}

	@Override
	public List<PlanEntity> getPlans() {
		List<PlanEntity> plans = planRepository.findAll();
		return plans;
	}

}
