package com.ravi.service;

import java.io.IOException;
import java.util.List;

import com.ravi.binding.SearchCriteria;
import com.ravi.entity.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

public interface CitizenPlanService {

	public List<String> getPlanNames();
	public List<String> getPlanStatus();
	public List<CitizenPlan> searchCitizens(SearchCriteria criteria);
	public void generateExcelReport(HttpServletResponse response) throws IOException;
	public void generatePdf(HttpServletResponse response);
}
