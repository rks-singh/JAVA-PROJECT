package com.ravi.service;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ravi.binding.CorrespondenceInfo;
import com.ravi.binding.EligibilityDeterminationInfo;
import com.ravi.entity.CitizenRegistrationEntity;
import com.ravi.entity.CorrespondenceEntity;
import com.ravi.entity.EligibilityDeterminationEntity;
import com.ravi.repository.CitizenRegistrationRepo;
import com.ravi.repository.CorrespondenceRepo;
import com.ravi.repository.EligibilityDeterminationRepo;
import com.ravi.utils.EmailUtils;
import com.ravi.utils.PdfUtils;
import com.ravi.utils.S3Utils;

@Service
public class CorrespondenceServiceImpl implements CorrespondenceService {

	@Autowired
	private CorrespondenceRepo correspondenceRepo;
	
	@Autowired
	private EligibilityDeterminationRepo eligibilityRepo;
	
	@Autowired
	private CitizenRegistrationRepo citizenRepo;
	
	@Autowired
	private EmailUtils emiaUtils;
	
	@Autowired
	private PdfUtils pdfUtils;
	
	@Autowired
	private S3Utils s3Utils;
	
	@Override
	public List<CorrespondenceInfo> getNotices(Integer caseNumber, String planStatus) {
		
		List<CorrespondenceInfo> records = new ArrayList<>();
		
		CitizenRegistrationEntity citizenEntity = new CitizenRegistrationEntity();
		citizenEntity.setCaseNumber(caseNumber);
		
		CorrespondenceEntity  coEntity = new CorrespondenceEntity();
		coEntity.setCitizenRegistration(citizenEntity);
		coEntity.setNoticeStatus(planStatus);
		
		List<CorrespondenceEntity> entities = correspondenceRepo.findAll(Example.of(coEntity));
		
		for(CorrespondenceEntity entity : entities) {
			CorrespondenceInfo info  = new CorrespondenceInfo();
			BeanUtils.copyProperties(entity, info);
			records.add(info);
		}
		return records;
	}

	@Override
	public boolean printNotice(Integer noticeId) {
		
		CorrespondenceEntity correspondenceEntity = correspondenceRepo.findById(noticeId).get();
		Integer caseNumber = correspondenceEntity.getCitizenRegistration().getCaseNumber();
		
		EligibilityDeterminationEntity eligiblityRecord = eligibilityRepo.findByCaseNumber(caseNumber);
		
		EligibilityDeterminationInfo info = new EligibilityDeterminationInfo();
		BeanUtils.copyProperties(eligiblityRecord, info);
		
		File generatePdf = pdfUtils.generatePdf(info);
		
		String objectUrl = s3Utils.uploadObject(generatePdf);
		
		correspondenceEntity.setNoticeS3Url(objectUrl);
		correspondenceEntity.setNoticePrintDate(LocalDate.now());
		correspondenceEntity.setNoticeStatus("History");
		
		correspondenceRepo.save(correspondenceEntity);
		
		//Sending Email..
		
		String citizenEmial = citizenRepo.findById(caseNumber).get().getCitizenEmial();
		
		String to = citizenEmial;
		String subject = "IES APP CITIZEN ED INFO";
		String body ="<h2> Please Download your Report </h2>";
		
		boolean status = emiaUtils.sendEmial(to, subject, body, generatePdf);
		
		return status;
	}

}
