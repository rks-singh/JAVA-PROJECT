package com.ravi.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ravi.binding.SearchCriteria;
import com.ravi.entity.CitizenPlan;
import com.ravi.service.CitizenPlanService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CitizenPlanController {

	@Autowired
	private CitizenPlanService citizenPlanService;

	@GetMapping("/")
	public String loadIndex(Model model) {
		searchUtils(model);
		model.addAttribute("criteria", new SearchCriteria());
		return "index";
	}

	private void searchUtils(Model model) {
		List<String> planNames = citizenPlanService.getPlanNames();
		List<String> planStatus = citizenPlanService.getPlanStatus();
		model.addAttribute("planName", planNames);
		model.addAttribute("planStatus", planStatus);
	}

	@PostMapping("/search")
	public String searchCitizens(@ModelAttribute("criteria") SearchCriteria criteria, Model model) {
		searchUtils(model);
		List<CitizenPlan> citizens = citizenPlanService.searchCitizens(criteria);
		model.addAttribute("citizens", citizens);
		return "index";
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
	public void generatePdf(HttpServletResponse response) throws Exception, Exception {
		response.setContentType("application/pdf");
		
		String headerKey = "content-Disposition";
		String headerValue = "attachment;filename=citizenPlan.pdf";
		
		response.setHeader(headerKey, headerValue);
		citizenPlanService.generatePdf(response);
	}

}
