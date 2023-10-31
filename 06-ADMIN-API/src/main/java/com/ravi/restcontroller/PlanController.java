package com.ravi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.entity.PlanEntity;
import com.ravi.model.Plan;
import com.ravi.service.PlanService;

@RestController
public class PlanController {
	
	@Autowired
	private PlanService planService;
	
	@PostMapping(value = "/plan",consumes = "application/json",produces = "text/plain")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){
		String status = planService.savePlan(plan);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/plans",produces = "application/json")
	public ResponseEntity<List<PlanEntity>> getPlans(){
		List<PlanEntity> plans = planService.getPlans();
		return new ResponseEntity<>(plans,HttpStatus.OK);
	}

}
