package com.ravi.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.binding.SearchCriteria;
import com.ravi.entity.CitizenPlan;
import com.ravi.service.CitizenPlanService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class CitizenPlanController {

	@Autowired
	private CitizenPlanService citizenPlanService;

	@GetMapping(value = "/plan-names", produces = "application/json")
	public ResponseEntity<List<String>> getPlanName() {
		List<String> planNames = citizenPlanService.getPlanNames();
		return new ResponseEntity<>(planNames, HttpStatus.OK);
	}
	
	@GetMapping(value = "/plan-status", produces = "application/json")
	public ResponseEntity<List<String>> getPlanStatus(){
		List<String> planStatus = citizenPlanService.getPlanStatus();
		return new ResponseEntity<>(planStatus, HttpStatus.OK);
	}

	@PostMapping(value = "/search", produces = "applciction/json", consumes = "application/json")
	public ResponseEntity<List<CitizenPlan>> handleSeacrchBtn (@RequestBody SearchCriteria criteria) {
		List<CitizenPlan> citizens = citizenPlanService.searchCitizens(criteria);
		return new ResponseEntity<List<CitizenPlan>>(citizens,HttpStatus.OK);
		
	}
	
	@GetMapping("/excel")
	public void generateExcelReport(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=citizenPlan.xls";

		response.setHeader(headerKey, headerValue);
		citizenPlanService.generateExcelReport(response);
	}
	
	@GetMapping("/pdf")
	public void generatePdf(HttpServletResponse response){
		response.setContentType("application/pdf");
		
		String headerKey = "content-Disposition";
		String headerValue = "attachment;filename=citizenPlan.pdf";
		
		response.setHeader(headerKey, headerValue);
		citizenPlanService.generatePdf(response);
	}

}
