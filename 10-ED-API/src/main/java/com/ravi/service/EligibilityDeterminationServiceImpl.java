package com.ravi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.binding.EligibilityDeterminationInfo;
import com.ravi.entity.CitizenRegistrationEntity;
import com.ravi.entity.EducationEntity;
import com.ravi.entity.EligibilityDeterminationEntity;
import com.ravi.entity.IncomeEntity;
import com.ravi.entity.KidEntity;
import com.ravi.entity.PlanSelectionEntity;
import com.ravi.repository.CitizenRegistrationRepo;
import com.ravi.repository.EducationRepo;
import com.ravi.repository.EligibilityDeterminationRepo;
import com.ravi.repository.IncomeRepo;
import com.ravi.repository.KidRepo;
import com.ravi.repository.PlanSelectionRepo;

@Service
public class EligibilityDeterminationServiceImpl implements EligibilityDeterminationService {

	@Autowired
	private CitizenRegistrationRepo citizenRepo;

	@Autowired
	private IncomeRepo incomeRepo;

	@Autowired
	private EducationRepo educationRepo;

	@Autowired
	private PlanSelectionRepo planRepo;

	@Autowired
	private KidRepo kidRepo;

	@Autowired
	private EligibilityDeterminationRepo eligibilityRepo;

	@Override
	public EligibilityDeterminationInfo determinEligibility(Integer caseNumber) {

		EligibilityDeterminationEntity entity = new EligibilityDeterminationEntity();

		CitizenRegistrationEntity citizenEntity = citizenRepo.findById(caseNumber).get();
		IncomeEntity incomeEntity = incomeRepo.findByCaseNumber(caseNumber);
		EducationEntity educationEntity = educationRepo.findByCaseNumber(caseNumber);
		PlanSelectionEntity planEntity = planRepo.findById(citizenEntity.getPlanId()).get();
		List<KidEntity> kidsEntity = kidRepo.findByCaseNumber(caseNumber);

		if ("SNAP".equalsIgnoreCase(planEntity.getPlanName())) {

			EligibilityDeterminationInfo info = new EligibilityDeterminationInfo();

			if (incomeEntity.getMonthlySalaryIncome() <= 300) {
				info.setCaseNumber(caseNumber);
				info.setPlanName("SNAP");
				info.setPlanStatus("Approved");
				info.setBenefitAmount(350.00);
				info.setPlanStartDate(LocalDate.now());
				info.setPlanEndDate(LocalDate.now().plusMonths(3));
				info.setDenialReason("NA");

				BeanUtils.copyProperties(info, entity);
				eligibilityRepo.save(entity);

			} else {
				info.setCaseNumber(caseNumber);
				info.setPlanName("SNAP");
				info.setPlanStatus("Denied");
				info.setBenefitAmount(null);
				info.setPlanStartDate(null);
				info.setPlanEndDate(null);
				info.setDenialReason("MONTHLY SALARY CONDITION FAILED!");

				BeanUtils.copyProperties(info, entity);
				eligibilityRepo.save(entity);
			}
		} else if ("CCAP".equalsIgnoreCase(planEntity.getPlanName())) {

			EligibilityDeterminationInfo info = new EligibilityDeterminationInfo();

			int kidsCount = 0;
			boolean isValidAge = true;

			for (KidEntity kid : kidsEntity) {
				kidsCount++;
				if (kid.getKidAge() > 16) {
					isValidAge = false;
					break;
				}
			}
			if ((incomeEntity.getMonthlySalaryIncome() <= 300) && (kidsCount > 0) && (isValidAge == true)) {
				info.setCaseNumber(caseNumber);
				info.setPlanName("CCAP");
				info.setPlanStatus("Approved");
				info.setBenefitAmount(250.00);
				info.setPlanStartDate(LocalDate.now());
				info.setPlanEndDate(LocalDate.now().plusMonths(3));
				info.setDenialReason("NA");

				BeanUtils.copyProperties(info, entity);
				eligibilityRepo.save(entity);
			} else {
				info.setCaseNumber(caseNumber);
				info.setPlanName("CCAP");
				info.setPlanStatus("Denied");
				info.setBenefitAmount(null);
				info.setPlanStartDate(null);
				info.setPlanEndDate(null);
				if (incomeEntity.getMonthlySalaryIncome() > 300) {
					info.setDenialReason("MONTHLY SALARY CONDITION FAILED!");
				} else {
					info.setDenialReason("AGE CONDITION FAILED!");
				}

				BeanUtils.copyProperties(info, entity);
				eligibilityRepo.save(entity);
			}
		} else if ("Medicaid".equalsIgnoreCase(planEntity.getPlanName())) {

			EligibilityDeterminationInfo info = new EligibilityDeterminationInfo();

			Double propertyIncome = incomeEntity.getPropertyIncome();
			Double rentIncome = incomeEntity.getRentIncome();

			Double totalIncome = propertyIncome + rentIncome;

			if ((incomeEntity.getMonthlySalaryIncome() <= 300) && (totalIncome == 0)) {
				info.setCaseNumber(caseNumber);
				info.setPlanName("Medicaid");
				info.setPlanStatus("Approved");
				info.setBenefitAmount(500.00);
				info.setPlanStartDate(LocalDate.now());
				info.setPlanEndDate(LocalDate.now().plusMonths(3));
				info.setDenialReason("NA");

				BeanUtils.copyProperties(info, entity);
				eligibilityRepo.save(entity);
			}else {
				info.setCaseNumber(caseNumber);
				info.setPlanName("Medicaid");
				info.setPlanStatus("Denied");
				info.setBenefitAmount(null);
				info.setPlanStartDate(null);
				info.setPlanEndDate(null);
				if (incomeEntity.getMonthlySalaryIncome() > 300) {
					info.setDenialReason("MONTHLY SALARY CONDITION FAILED!");
				} else {
					info.setDenialReason("INCOME CONDITION FAILED!");
				}

				BeanUtils.copyProperties(info, entity);
				eligibilityRepo.save(entity);
			}
		}else if("Medicare".equalsIgnoreCase(planEntity.getPlanName())) {
			
			EligibilityDeterminationInfo info = new EligibilityDeterminationInfo();
			
			int birthYear = citizenEntity.getCitizeDob().getYear();
			int currentYear = LocalDate.now().getYear();
			int citizenAge = currentYear - birthYear;
			
			if(citizenAge>=65) {
				info.setCaseNumber(caseNumber);
				info.setPlanName("Medicare");
				info.setPlanStatus("Approved");
				info.setBenefitAmount(350.00);
				info.setPlanStartDate(LocalDate.now());
				info.setPlanEndDate(LocalDate.now().plusMonths(3));
				info.setDenialReason("NA");

				BeanUtils.copyProperties(info, entity);
				eligibilityRepo.save(entity);
			}else {
				info.setCaseNumber(caseNumber);
				info.setPlanName("Medicare");
				info.setPlanStatus("Denied");
				info.setBenefitAmount(null);
				info.setPlanStartDate(null);
				info.setPlanEndDate(null);
				info.setDenialReason("AGE CONDITION FAILED!");

				BeanUtils.copyProperties(info, entity);
				eligibilityRepo.save(entity);
			}
		}else if("RIW".equalsIgnoreCase(planEntity.getPlanName())) {
			
			EligibilityDeterminationInfo info = new EligibilityDeterminationInfo();
			
			if(("un-employed".equalsIgnoreCase(educationEntity.getHighestDegree()))&&
					("graduated".equalsIgnoreCase(educationEntity.getHighestDegree()))) {
				
				info.setCaseNumber(caseNumber);
				info.setPlanName("RIW");
				info.setPlanStatus("Approved");
				info.setBenefitAmount(550.00);
				info.setPlanStartDate(LocalDate.now());
				info.setPlanEndDate(LocalDate.now().plusMonths(3));
				info.setDenialReason("NA");

				BeanUtils.copyProperties(info, entity);
				eligibilityRepo.save(entity);
			}else {
				info.setCaseNumber(caseNumber);
				info.setPlanName("RIW");
				info.setPlanStatus("Denied");
				info.setBenefitAmount(null);
				info.setPlanStartDate(null);
				info.setPlanEndDate(null);
				info.setDenialReason("EDUCATION CONDITION FAILED!");

				BeanUtils.copyProperties(info, entity);
				eligibilityRepo.save(entity);
			}
		}
		
		EligibilityDeterminationEntity eligiblityInfo = eligibilityRepo.findByCaseNumber(caseNumber);
		EligibilityDeterminationInfo info = new EligibilityDeterminationInfo();
		
		BeanUtils.copyProperties(eligiblityInfo, info);
		info.setCaseNumber(caseNumber);
		return info;
	}

}
