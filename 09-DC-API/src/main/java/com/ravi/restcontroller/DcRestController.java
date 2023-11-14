package com.ravi.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.binding.Education;
import com.ravi.binding.Income;
import com.ravi.binding.Kids;
import com.ravi.binding.PlanSelection;
import com.ravi.binding.Summary;
import com.ravi.service.DcService;

@RestController
public class DcRestController {

	@Autowired
	private DcService dcService;
	
	@GetMapping(value = "/plans", produces = "application/json")
	public ResponseEntity<Map<Integer, String>> getPlanName(){
		Map<Integer,String> planName = dcService.getPlanName();
		return new ResponseEntity<>(planName,HttpStatus.OK);
	}
	
	@PostMapping(value = "/plans", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> updatePlanSelection(@RequestBody PlanSelection request){
		boolean status = dcService.updatePlanSelection(request);
		if(status) {
			return new ResponseEntity<>("Plan Updation Success",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Plan Updation Failed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/income", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> saveIncomeDetails(@RequestBody Income request){
		boolean status = dcService.saveIncome(request);
		if(status) {
			return new ResponseEntity<>("Income Data Saved",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Income Data Failed To Save",HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/education", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> saveEducationData(@RequestBody Education request){
		boolean status = dcService.saveEducation(request);
		if(status) {
			return new ResponseEntity<>("Education Data Saved",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Education Data Failed To Save",HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/kids", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> saveKidsData(@RequestBody Kids request){
		boolean status = dcService.saveKids(request);
		if(status) {
			return new ResponseEntity<>("Kids Data Saved",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Kids Data Failed To Save",HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/summarys/{caseNumber}", produces = "application/json")
	public ResponseEntity<Summary> getSummaryDetails(@PathVariable("caseNumber")Integer caseNumber){
		Summary summaryDetails = dcService.getSummaryDetails(caseNumber);
		return new ResponseEntity<>(summaryDetails,HttpStatus.OK);
	}
	
	
}
