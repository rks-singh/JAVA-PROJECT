package com.ravi.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.binding.EligibilityDeterminationInfo;
import com.ravi.entity.CitizenRegistrationEntity;
import com.ravi.entity.CorrespondenceEntity;
import com.ravi.entity.EducationEntity;
import com.ravi.entity.IncomeEntity;
import com.ravi.entity.KidEntity;
import com.ravi.entity.PlanSelectionEntity;
import com.ravi.repository.CitizenRegistrationRepo;
import com.ravi.repository.CorrespondenceRepo;
import com.ravi.repository.EducationRepo;
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
	private CorrespondenceRepo correspondenceRepo;

	@Override
	public EligibilityDeterminationInfo determinEligibility(Integer caseNumber) {

		CitizenRegistrationEntity citizenEntity = citizenRepo.findById(caseNumber).get();
		IncomeEntity incomeEntity = incomeRepo.findByCaseNumber(caseNumber);
		EducationEntity educationEntity = educationRepo.findByCaseNumber(caseNumber);
		PlanSelectionEntity planEntity = planRepo.findById(citizenEntity.getPlanId()).get();
		List<KidEntity> kidsEntity = kidRepo.findByCaseNumber(caseNumber);

		EligibilityDeterminationInfo info = new EligibilityDeterminationInfo();

		if ("SNAP".equalsIgnoreCase(planEntity.getPlanName())) {

			if (incomeEntity.getMonthlySalaryIncome() <= 300) {
				info.setCaseNumber(caseNumber);
				info.setPlanName("SNAP");
				info.setPlanStatus("Approved");
				info.setBenefitAmount(350.00);
				info.setPlanStartDate(LocalDate.now());
				info.setPlanEndDate(LocalDate.now().plusMonths(3));
				info.setDenialReason("NA");

			} else {
				info.setCaseNumber(caseNumber);
				info.setPlanName("SNAP");
				info.setPlanStatus("Denied");
				info.setBenefitAmount(null);
				info.setPlanStartDate(null);
				info.setPlanEndDate(null);
				info.setDenialReason("HIGH INCOME!");
			}
		} else if ("CCAP".equalsIgnoreCase(planEntity.getPlanName())) {

			boolean isValidAge = true;

			for (KidEntity kid : kidsEntity) {
				int kidAge = Period.between(kid.getKidDob(), LocalDate.now()).getYears();
				if (kidAge > 16) {
					isValidAge = false;
					break;
				}
			}
			if ((incomeEntity.getMonthlySalaryIncome() <= 300) && (!kidsEntity.isEmpty()) && (isValidAge == true)) {
				info.setCaseNumber(caseNumber);
				info.setPlanName("CCAP");
				info.setPlanStatus("Approved");
				info.setBenefitAmount(250.00);
				info.setPlanStartDate(LocalDate.now());
				info.setPlanEndDate(LocalDate.now().plusMonths(3));
				info.setDenialReason("NA");

			} else {
				info.setCaseNumber(caseNumber);
				info.setPlanName("CCAP");
				info.setPlanStatus("Denied");
				info.setBenefitAmount(null);
				info.setPlanStartDate(null);
				info.setPlanEndDate(null);
				if (incomeEntity.getMonthlySalaryIncome() > 300) {
					info.setDenialReason("HIGH INCOME!");
				} else if(isValidAge==false) {
					info.setDenialReason("AGE CONDITION FAILED!");
				}else {
					info.setDenialReason("N0 CHILD!");
				}
			}
		} else if ("Medicaid".equalsIgnoreCase(planEntity.getPlanName())) {

			Double propertyIncome = incomeEntity.getPropertyIncome();
			Double rentIncome = incomeEntity.getRentIncome();

			Double totalIncome = propertyIncome + rentIncome;

			if ((incomeEntity.getMonthlySalaryIncome() <= 300) && (totalIncome <= 0)) {
				info.setCaseNumber(caseNumber);
				info.setPlanName("Medicaid");
				info.setPlanStatus("Approved");
				info.setBenefitAmount(500.00);
				info.setPlanStartDate(LocalDate.now());
				info.setPlanEndDate(LocalDate.now().plusMonths(3));
				info.setDenialReason("NA");
			} else {
				info.setCaseNumber(caseNumber);
				info.setPlanName("Medicaid");
				info.setPlanStatus("Denied");
				info.setBenefitAmount(null);
				info.setPlanStartDate(null);
				info.setPlanEndDate(null);
				if (incomeEntity.getMonthlySalaryIncome() > 300) {
					info.setDenialReason("HIGH INCOME!");
				} else {
					info.setDenialReason("PROPERTY INCOME AND RENT INCOME IS HIGH!");
				}
			}
		} else if ("Medicare".equalsIgnoreCase(planEntity.getPlanName())) {

			int citizenAge = Period.between(citizenEntity.getCitizeDob(), LocalDate.now()).getYears();

			if (citizenAge >= 65) {
				info.setCaseNumber(caseNumber);
				info.setPlanName("Medicare");
				info.setPlanStatus("Approved");
				info.setBenefitAmount(350.00);
				info.setPlanStartDate(LocalDate.now());
				info.setPlanEndDate(LocalDate.now().plusMonths(3));
				info.setDenialReason("NA");

			} else {
				info.setCaseNumber(caseNumber);
				info.setPlanName("Medicare");
				info.setPlanStatus("Denied");
				info.setBenefitAmount(null);
				info.setPlanStartDate(null);
				info.setPlanEndDate(null);
				info.setDenialReason("AGE CONDITION FAILED!");
			}
		} else if ("RIW".equalsIgnoreCase(planEntity.getPlanName())) {

			if ((educationEntity.getGraduationYear() != null) && (incomeEntity != null)) {

				info.setCaseNumber(caseNumber);
				info.setPlanName("RIW");
				info.setPlanStatus("Approved");
				info.setBenefitAmount(550.00);
				info.setPlanStartDate(LocalDate.now());
				info.setPlanEndDate(LocalDate.now().plusMonths(3));
				info.setDenialReason("NA");
			} else {
				info.setCaseNumber(caseNumber);
				info.setPlanName("RIW");
				info.setPlanStatus("Denied");
				info.setBenefitAmount(null);
				info.setPlanStartDate(null);
				info.setPlanEndDate(null);
				if(educationEntity.getGraduationYear() != null) {
					info.setDenialReason("NOT GRADUATED!");
				}else {
					info.setDenialReason("UN-EMPLOYED!");
				}

			}
		}
		
		generateCorrespondence(citizenEntity);
		return info;
	}

	private void generateCorrespondence(CitizenRegistrationEntity entity) {
		CorrespondenceEntity correspondenceEntity = new CorrespondenceEntity();
		correspondenceEntity.setNoticeStatus("Pending");
		correspondenceEntity.setCitizenRegistration(entity);
		
		correspondenceRepo.save(correspondenceEntity);
	}

}
