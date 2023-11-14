package com.ravi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.binding.Education;
import com.ravi.binding.Income;
import com.ravi.binding.Kid;
import com.ravi.binding.Kids;
import com.ravi.binding.PlanSelection;
import com.ravi.binding.Summary;
import com.ravi.entity.CitizenRegistrationEntity;
import com.ravi.entity.EducationEntity;
import com.ravi.entity.IncomeEntity;
import com.ravi.entity.KidEntity;
import com.ravi.entity.PlanSelectionEntity;
import com.ravi.entity.UserEntity;
import com.ravi.repository.CitizenRegistrationRepo;
import com.ravi.repository.EducationRepo;
import com.ravi.repository.IncomeRepo;
import com.ravi.repository.KidRepo;
import com.ravi.repository.PlanSelectionRepo;
import com.ravi.repository.UserRepo;

@Service
public class DcServiceImpl implements DcService {

	@Autowired
	private PlanSelectionRepo planSelectionRepo;
	
	@Autowired
	private IncomeRepo incomeRepo;
	
	@Autowired
	private EducationRepo educationRepo;
	
	@Autowired
	private KidRepo kidRepo;
	
	@Autowired
	private CitizenRegistrationRepo citizenRepo;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public Map<Integer, String> getPlanName() {
		Map<Integer, String> map = new HashMap<>();
		List<PlanSelectionEntity> plans = planSelectionRepo.findAll();
		for(PlanSelectionEntity entity : plans) {
			map.put(entity.getPlanId(), entity.getPlanName());
		}
		return map;
	}

	@Override
	public boolean updatePlanSelection(PlanSelection plan) {
		Integer caseNumber = plan.getCaseNumber();
		Integer userId = plan.getUserId();
		
		CitizenRegistrationEntity citizenEntity= citizenRepo.findById(caseNumber).get();
		 UserEntity userEntity = userRepo.findById(userId).get();
		
			citizenEntity.setPlanId(plan.getPlanId());
			citizenRepo.save(citizenEntity);
			citizenEntity.setUser(userEntity);
			
			return true;

	}

	@Override
	public boolean saveIncome(Income income) {
		IncomeEntity entity = new IncomeEntity();
		BeanUtils.copyProperties(income, entity);
		
		Integer caseNumber = income.getCaseNumber();
		Integer userId = income.getUserId();
		
		CitizenRegistrationEntity citizenEntity = citizenRepo.findById(caseNumber).get();
		UserEntity userEntity = userRepo.findById(userId).get();
		
		entity.setCitizenRegistration(citizenEntity);
		entity.setUser(userEntity);
		
		incomeRepo.save(entity);
		
		return true;
	}

	@Override
	public boolean saveEducation(Education education) {
		
		EducationEntity entity = new EducationEntity();
		BeanUtils.copyProperties(education, entity);
		Integer caseNumber = education.getCaseNumber();
		Integer userId = education.getUserId();
		
		CitizenRegistrationEntity citizenEntity = citizenRepo.findById(caseNumber).get();
		UserEntity userEntity = userRepo.findById(userId).get();
		
		entity.setCitizenRegistration(citizenEntity);
		entity.setUser(userEntity);
		
		educationRepo.save(entity);
		
		return true;
	}

	@Override
	public boolean saveKids(Kids kids) {
		
		Integer caseNumber = kids.getCaseNumber();
		Integer userId = kids.getUserId();
		
		CitizenRegistrationEntity citizenEntity = citizenRepo.findById(caseNumber).get();
		UserEntity userEntity = userRepo.findById(userId).get();
		
		List<Kid> kidsList = kids.getKids();
		for(Kid kid  : kidsList) {
			KidEntity entity = new KidEntity();
			BeanUtils.copyProperties(kid, entity);
			
			entity.setCitizenRegistration(citizenEntity);
			entity.setUser(userEntity);
			
			kidRepo.save(entity);
		}
		return true;
	}

	@Override
	public Summary getSummaryDetails(Integer caseNumber) {
		CitizenRegistrationEntity citizenEntity = citizenRepo.findById(caseNumber).get();
		PlanSelectionEntity planEntity = planSelectionRepo.findById(citizenEntity.getPlanId()).get();
		IncomeEntity incomeEntity = incomeRepo.findByCaseNumber(caseNumber);
		EducationEntity educationEntity = educationRepo.findByCaseNumber(caseNumber);
		List<KidEntity> kidsEntity = kidRepo.findByCaseNumber(caseNumber);
		
		Summary summary = new Summary();
		
		summary.setCaseNumber(caseNumber);
		summary.setPlanName(planEntity.getPlanName());
		
		Income income = new Income();
		BeanUtils.copyProperties(incomeEntity, income);
		summary.setIncome(income);
		
		List<Kid> kidList = new ArrayList<>();
		for(KidEntity entity : kidsEntity) {
			Kid kid = new Kid();
			BeanUtils.copyProperties(entity, kid);
			kidList.add(kid);
		}
		Kids kids = new Kids();
		kids.setKids(kidList);
		
		summary.setKids(kids);
		
		Education education = new Education();
		BeanUtils.copyProperties(educationEntity, education);
		summary.setEducation(education);
		
		return summary;
	}

}
