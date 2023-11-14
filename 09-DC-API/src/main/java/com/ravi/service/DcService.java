package com.ravi.service;

import java.util.Map;

import com.ravi.binding.Education;
import com.ravi.binding.Income;
import com.ravi.binding.Kids;
import com.ravi.binding.PlanSelection;
import com.ravi.binding.Summary;

public interface DcService {

	public Map<Integer, String> getPlanName();

	public boolean updatePlanSelection(PlanSelection planSelection);

	public boolean saveIncome(Income income);

	public boolean saveEducation(Education education);

	public boolean saveKids(Kids kids);
	
	public Summary getSummaryDetails(Integer caseNumber);
}
